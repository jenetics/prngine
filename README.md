# PRNGine

*PRNGine* is a pseudo-random number generator library for sequential and parallel [Monte Carlo simulations](https://de.wikipedia.org/wiki/Monte-Carlo-Simulation). It has been designed to work smoothly with the [Jenetics](http://jenetics.io) GA library, but it has no dependency to it. All PRNG implementations of this library extends the Java [Random](http://docs.oracle.com/javase/8/docs/api/java/util/Random.html) class, which makes it easily usable in other projects. *The PRNGs are* **not** *cryptographically strong RNGs.*

The following PRNGs are currently implemented:

* `KISS32Random`: Implementation of an simple PRNG as proposed in [Good Practice in (Pseudo) Random Number Generation for Bioinformatics Applications](http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf) (JKISS32, page 3) [*David Jones*](mailto:d.jones@cs.ucl.ac.uk), UCL Bioinformatics Group.
* `KISS64Random`: Implementation of an simple PRNG as proposed in [Good Practice in (Pseudo) Random Number Generation for Bioinformatics Applications](http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf) (JKISS64, page 10) [*David Jones*](mailto:d.jones@cs.ucl.ac.uk), UCL Bioinformatics Group.
* `LCG64ShiftRandom`: This class implements a linear congruential PRNG with additional bit-shift transition. It is a port of the [trng::lcg64_shift](https://github.com/rabauke/trng4/blob/master/src/lcg64_shift.hpp) PRNG class of the [TRNG](http://numbercrunch.de/trng/) library created by Heiko Bauke.
* `MT19937_32Random`: This is a 32-bit version of Mersenne Twister pseudorandom number generator.
* `MT19937_64Random`: This is a 64-bit version of Mersenne Twister pseudorandom number generator.
* `XOR32ShiftRandom`: This generator was discovered and characterized by George Marsaglia [[Xorshift RNGs](http://www.jstatsoft.org/v08/i14/paper)]. In just three XORs and three shifts (generally fast operations) it produces a full period of 2<sup>32</sup> - 1 on 32 bits. (The missing value is zero, which perpetuates itself and must be avoided.) High and low bits pass Diehard.
* `XOR64ShiftRandom`: This generator was discovered and characterized by George Marsaglia  [[Xorshift RNGs](http://www.jstatsoft.org/v08/i14/paper)]. In just  three XORs and three shifts (generally fast operations) it produces a full  period of 2<sup>64</sup> - 1 on 64 bits. (The missing value is zero, which  perpetuates itself and must be avoided.) High and low bits pass Diehard.

## Requirements

### Runtime
*  **JRE 8**: Java runtime version 8 is needed for using the library.

### Build time
*  **JDK 8**: The Java [JDK 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html) must be installed.
*  **Gradle 3.x**: [Gradle](http://www.gradle.org/) is used for building the library. (Gradle is download automatically, if you are using the Gradle Wrapper script `./gradlew`, located in the base directory, for building the library.)
*  **TestNG 6.10**: PRNGine uses [TestNG](http://testng.org/doc/index.html) framework for unit tests.

## Building PRNGine

[![Build Status](https://travis-ci.org/jenetics/prngine.svg?branch=master)](https://travis-ci.org/jenetics/prngine)

For  building the PRNGine library you have to check out the master branch from Github.

    $ git clone https://github.com/jenetics/prngine.git
    
*Executing the tests:*
    
    $ cd prngine
    $ ./gradle test

*Building the library:*

    $ ./gradle jar
    
## Download

* **Github**: <https://github.com/jenetics/prngine/archive/v1.0.0.zip>
*  **Maven**: `io.jenetics:prngine:1.0.0` on [Maven Central](http://search.maven.org/#search%7Cga%7C1%7Ca%3A%22prgnine%22) 

## Examples

### PRN creation

Every PRNG of the library comes in three flavours, a un-synchronized *base* implementation, a synchronized implementation and in a *thread-local* implementation.

**Un-synchronized base implementation** with the naming scheme `XXXRandom`:
```java
final Random random = new LCG64ShiftRandom();
random.doubles(10).forEach(System.out::println);
```

**Synchronized implementation** with the naming scheme `XXXRandom.ThreadSafe`:
```java
final Random random = new LCG64ShiftRandom.ThreadSafe();
final Runnable runnable = () -> random.doubles(10).forEach(System.out::println);

final ExecutionService executor = ...;
for (int i = 0; i < 10; ++i) {
	executor.submit(runnable);
}
```

**`ThreadLocal `implementation** with the naming scheme `XXXRandom.ThreadLocal`:
```java
static final ThreadLocal<? extends Random> random = 
    new LCG64ShiftRandom.ThreadLocal();

final Runnable runnable = () -> random.get()
    .doubles(10).forEach(System.out::println);

final ExecutionService executor = ...;
for (int i = 0; i < 10; ++i) {
	executor.submit(runnable);
}
```

### PRN seeding

The library also contains methods for creating *random* seed values, which can be used for initializing the available PRNGs.

```java
// Creating a new 64 bit seed value.
final long seed = PRNG.seed();
final Random ranomd = new LCG64ShiftRandom(seed);
```

A more detailed description of how the seeding is implemented can be found [here](random_seeding.adoc).


## Test results

### Statistical tests ([dieharder](https://www.phy.duke.edu/~rgb/General/dieharder.php))

All implemented PRNGs has been tested with the [dieharder](https://www.phy.duke.edu/~rgb/General/dieharder.php) test suite.

 PRNG | Passed | Weak | Failed
 -----|--------|------|-------
  KISS32Random | 108 | 6 | 0
  KISS64Random | 109 | 5 | 0
  LCG64ShiftRandom | 110 | 4 | 0
  MT19937_32Random | 113 | 1 | 0
  MT19937_64Random | 111 | 3 | 0
  XOR32ShiftRandom | 101 | 4 | 9
  XOR64ShiftRandom | 107 | 7 | 0
  java.util.Random | 106 | 4 | 4
  
### Runtime performance tests  

The runtime performance of the PRNGs was tested with the [JMH](http://openjdk.java.net/projects/code-tools/jmh/) testing framework on on a *Intel Core i7-6700HQ CPU @ 2.60GHz* with *Java(TM) SE Runtime Environment (build 1.8.0_102-b14)—Java HotSpot*. 
  
  PRNG | 10<sup>6</sup> ints/s | 10<sup>6</sup> floats/s | 10<sup>6</sup> longs/s | 10<sup>6</sup> doubles/s
  -----|-------|---------|--------|---------
  KISS32Random | 189 | 143 |129 | 108
  KISS64Random | 128 | 124 |115 | 124
  LCG64ShiftRandom | 258 | 185 |261 | 191
  MT19937_32Random | 140 | 115 |92 | 82
  MT19937_64Random | 148 | 120 |148 | 120
  XOR32ShiftRandom | 227 | 161 |140 | 120
  XOR64ShiftRandom | 225 | 166 |235 | 166
  java.util.Random | 91 | 89 |46 | 46
  
  
## License

The library is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).

    Copyright 2017 Franz Wilhelmstötter

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

