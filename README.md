# PRNGine
Pseudo Random Number Engine implementations

Work in progress...

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
  

