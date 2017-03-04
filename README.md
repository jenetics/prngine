# PRNGine

This library contains Pseudo Random Number Generators suitable for simulation and Monte Carlo applications, respectively. It has been designed to work smoothly with the [Jenetics](http://jenetics.io) GA library, but it has no dependency to it. All PRNG implementations of this library extends the Java [Random](http://docs.oracle.com/javase/8/docs/api/java/util/Random.html) class, which makes it easily usable in other projects. *The PRNGs are* **not** *cryptographically strong RNGs.*

The following PRNGs are currently implemented:

* `KISS32Random`: Implementation of an simple PRNG as proposed in [Good Practice in (Pseudo) Random Number Generation for Bioinformatics Applications](http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf) (JKISS32, page 3) [*David Jones*](mailto:d.jones@cs.ucl.ac.uk), UCL Bioinformatics Group.
* `KISS64Random`: Implementation of an simple PRNG as proposed in [Good Practice in (Pseudo) Random Number Generation for Bioinformatics Applications](http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf) (JKISS64, page 10) [*David Jones*](mailto:d.jones@cs.ucl.ac.uk), UCL Bioinformatics Group.
* `LCG64ShiftRandom`: This class implements a linear congruential PRNG with additional bit-shift transition. It is a port of the [trng::lcg64_shift](https://github.com/rabauke/trng4/blob/master/src/lcg64_shift.hpp) PRNG class of the [TRNG](http://numbercrunch.de/trng/) library created by Heiko Bauke.
* `MT19937_32Random`: This is a 32-bit version of Mersenne Twister pseudorandom number generator.
* `MT19937_64Random`: This is a 64-bit version of Mersenne Twister pseudorandom number generator.
* `XOR32ShiftRandom`: This generator was discovered and characterized by George Marsaglia [[Xorshift RNGs](http://www.jstatsoft.org/v08/i14/paper)]. In just three XORs and three shifts (generally fast operations) it produces a full period of 2<sup>32</sup> - 1 on 32 bits. (The missing value is zero, which perpetuates itself and must be avoided.) High and low bits pass Diehard.
* `XOR64ShiftRandom`: This generator was discovered and characterized by George Marsaglia  [[Xorshift RNGs](http://www.jstatsoft.org/v08/i14/paper)]. In just  three XORs and three shifts (generally fast operations) it produces a full  period of 2<sup>64</sup> - 1 on 64 bits. (The missing value is zero, which  perpetuates itself and must be avoided.) High and low bits pass Diehard.


## [Dieharder](https://www.phy.duke.edu/~rgb/General/dieharder.php) test results

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
  

