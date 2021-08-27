# PRNGine

[![Build Status](https://travis-ci.org/jenetics/prngine.svg?branch=master)](https://travis-ci.org/jenetics/prngine)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.jenetics/prngine/badge.svg)](http://search.maven.org/#search|ga|1|a%3A%22prngine%22)
[![Javadoc](https://www.javadoc.io/badge/io.jenetics/prngine.svg)](http://www.javadoc.io/doc/io.jenetics/prngine)

*PRNGine* is a pseudo-random number generator library for sequential and parallel [Monte Carlo simulations](https://de.wikipedia.org/wiki/Monte-Carlo-Simulation). All PRNG implementations of this library extends the Java [RandomGenerator](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/random/RandomGenerator.html) class, which makes it easily usable in other projects. *The PRNGs are* **not** *cryptographically strong RNGs.*

The following PRNGs are implemented:

* `KISS32Random`: Implementation of an simple PRNG as proposed in [Good Practice in (Pseudo) Random Number Generation for Bioinformatics Applications](http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf) (JKISS32, page 3) [*David Jones*](mailto:d.jones@cs.ucl.ac.uk), UCL Bioinformatics Group.
* `KISS64Random`: Implementation of an simple PRNG as proposed in [Good Practice in (Pseudo) Random Number Generation for Bioinformatics Applications](http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf) (JKISS64, page 10) [*David Jones*](mailto:d.jones@cs.ucl.ac.uk), UCL Bioinformatics Group.
* `LCG64ShiftRandom`: This class implements a linear congruential PRNG with additional bit-shift transition. It is a port of the [trng::lcg64_shift](https://github.com/rabauke/trng4/blob/master/trng/lcg64_shift.hpp) PRNG class of the [TRNG](https://www.numbercrunch.de/trng/) library created by Heiko Bauke.
* `MT19937_32Random`: This is a 32-bit version of Mersenne Twister pseudorandom number generator.
* `MT19937_64Random`: This is a 64-bit version of Mersenne Twister pseudorandom number generator.
* `XOR32ShiftRandom`: This generator was discovered and characterized by George Marsaglia [[Xorshift RNGs](http://www.jstatsoft.org/v08/i14/paper)]. In just three XORs and three shifts (generally fast operations) it produces a full period of 2<sup>32</sup> - 1 on 32 bits. (The missing value is zero, which perpetuates itself and must be avoided.) High and low bits pass Diehard.
* `XOR64ShiftRandom`: This generator was discovered and characterized by George Marsaglia  [[Xorshift RNGs](http://www.jstatsoft.org/v08/i14/paper)]. In just  three XORs and three shifts (generally fast operations) it produces a full  period of 2<sup>64</sup> - 1 on 64 bits. (The missing value is zero, which  perpetuates itself and must be avoided.) High and low bits pass Diehard.

> **NOTE**
> 
> All implemented random generators are not thread-safe. If they are used in a multi-threaded environment, they must be *synchronized* externally. 

## Requirements

*  **JDK 17**: You need Java 17 for building the library.

## Building PRNGine

For  building the PRNGine library you have to check out the master branch from Github.

    $ git clone https://github.com/jenetics/prngine.git
    
*Executing the tests:*
    
    $ cd prngine
    $ ./gradle test

*Building the library:*

    $ ./gradle jar


## Examples

### PRNG creation

All random generators can be created with `new` or via the `RandomGenerator.of("<name>")` or `RandomGeneratorFactory.of("<name>")` factory method.

```java
final LCG64ShiftRandom random1 = new LCG64ShiftRandom();
final RandomGenerator random2 = RandomGenerator.of("LCG64ShiftRandom");
final RandomGenerator random3 = RandomGeneratorFactory.of("LCG64ShiftRandom").create();
```

### PRNG seeding

The library also contains methods for creating *random* seed values, which can be used for initializing the available PRNGs.

```java
// Creating a new 64 bit seed value.
final long seed = Seeds.seed();
final Random ranomd = new LCG64ShiftRandom(seed);
```

Every random engine has a `seedBytes()` method, which return the seed `byte[]` array with the length required by the PRNG.

```java
// This random creation is equivalent to...
final RandomGenerator random1 = new LCG64ShiftRandom();

// ...creating it with the seed bytes of the PRNG. 
final byte[] seed = LCG64ShiftRandom.seedBytes();
final RandomGenerator random2 = new LCG53ShiftRandom(seed);
```

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
  
### Runtime performance tests  

The runtime performance of the PRNGs was tested with the [JMH](http://openjdk.java.net/projects/code-tools/jmh/) testing framework on an *Intel Core i7-6700HQ CPU @ 2.60GHz* with *Java SE Runtime Environment (build 1.8.0_112-b15)—Java HotSpot*. 
  
  PRNG | 10<sup>6</sup> ints/s | 10<sup>6</sup> floats/s | 10<sup>6</sup> longs/s | 10<sup>6</sup> doubles/s
  -----|-------|---------|--------|---------
  KISS32Random | 189 | 143 |129 | 108
  KISS64Random | 128 | 124 |115 | 124
  LCG64ShiftRandom | 258 | 185 |261 | 191
  MT19937_32Random | 140 | 115 |92 | 82
  MT19937_64Random | 148 | 120 |148 | 120
  XOR32ShiftRandom | 227 | 161 |140 | 120
  XOR64ShiftRandom | 225 | 166 |235 | 166
  
  
## License

The library is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html).

    Copyright 2017-2021 Franz Wilhelmstötter

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

## Release notes

### [2.0.0](https://github.com/jenetics/prngine/releases/tag/v2.0.0)

* Make the random generators work seamlessly with the new Java 17 `RandomGenerator` API.

### [1.1.0](https://github.com/jenetics/prngine/releases/tag/v1.1.0)

#### Improvements

* [#26](https://github.com/jenetics/prngine/issues/26): Convert Gradle build scripts from Groovy to Kotlin and prepare for Java 11.

### [1.0.2](https://github.com/jenetics/prngine/releases/tag/v1.0.2)

#### Improvements

* [#21](https://github.com/jenetics/prngine/issues/21): Update Gradle version and add CI build for Java 11.

#### Bugs

* [#20](https://github.com/jenetics/prngine/issues/20): Fix alerts found by [LGTM](https://lgtm.com/projects/g/jenetics/prngine/alerts?mode=list).

### [1.0.1](https://github.com/jenetics/prngine/releases/tag/v1.0.1)

#### Improvements

* [#3](https://github.com/jenetics/prngine/issues/3): Define stable module name. Set the `Automatic-Module-Name` to `io.jenetics.prngine`.
