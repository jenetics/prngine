/*
 * PRNGine - Java PRNG Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmail.com)
 */
package io.jenetics.prngine.internal;

import java.util.random.RandomGenerator;

import io.jenetics.prngine.Seeds;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 1.0
 */
public final class SeedRandom implements RandomGenerator {
	@Override
	public long nextLong() {
		return Seeds.seed();
	}
}

/*
#=============================================================================#
# Testing: SeedRandom (2022-02-18 11:41)                                      #
#=============================================================================#
#=============================================================================#
# Mac OS X 10.15.7 (x86_64)                                                   #
# java version "17"                                                           #
# Java(TM) SE Runtime Environment (build 17+35-LTS-2724)                      #
# Java HotSpot(TM) 64-Bit Server VM (build 17+35-LTS-2724)                    #
#=============================================================================#
#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  1.53e+07  |1974724897|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.26089141|  PASSED
      diehard_operm5|   0|   1000000|     100|0.29406078|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.71643889|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.95372582|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.80406851|  PASSED
        diehard_opso|   0|   2097152|     100|0.65282530|  PASSED
        diehard_oqso|   0|   2097152|     100|0.71099593|  PASSED
         diehard_dna|   0|   2097152|     100|0.80611832|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.98114570|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.99546416|   WEAK
 diehard_parking_lot|   0|     12000|     100|0.27377983|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.99036561|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.11617826|  PASSED
     diehard_squeeze|   0|    100000|     100|0.03889473|  PASSED
        diehard_sums|   0|       100|     100|0.87867789|  PASSED
        diehard_runs|   0|    100000|     100|0.31429298|  PASSED
        diehard_runs|   0|    100000|     100|0.86939068|  PASSED
       diehard_craps|   0|    200000|     100|0.26333902|  PASSED
       diehard_craps|   0|    200000|     100|0.82763595|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.07883458|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.92601562|  PASSED
         sts_monobit|   1|    100000|     100|0.68756276|  PASSED
            sts_runs|   2|    100000|     100|0.76796959|  PASSED
          sts_serial|   1|    100000|     100|0.99800448|   WEAK
          sts_serial|   2|    100000|     100|0.69123140|  PASSED
          sts_serial|   3|    100000|     100|0.95454029|  PASSED
          sts_serial|   3|    100000|     100|0.92941914|  PASSED
          sts_serial|   4|    100000|     100|0.52624623|  PASSED
          sts_serial|   4|    100000|     100|0.06817326|  PASSED
          sts_serial|   5|    100000|     100|0.66471314|  PASSED
          sts_serial|   5|    100000|     100|0.56388450|  PASSED
          sts_serial|   6|    100000|     100|0.97611955|  PASSED
          sts_serial|   6|    100000|     100|0.15518473|  PASSED
          sts_serial|   7|    100000|     100|0.65378884|  PASSED
          sts_serial|   7|    100000|     100|0.43143980|  PASSED
          sts_serial|   8|    100000|     100|0.30447134|  PASSED
          sts_serial|   8|    100000|     100|0.27799978|  PASSED
          sts_serial|   9|    100000|     100|0.14017109|  PASSED
          sts_serial|   9|    100000|     100|0.13042567|  PASSED
          sts_serial|  10|    100000|     100|0.22936088|  PASSED
          sts_serial|  10|    100000|     100|0.66640675|  PASSED
          sts_serial|  11|    100000|     100|0.10892535|  PASSED
          sts_serial|  11|    100000|     100|0.22978950|  PASSED
          sts_serial|  12|    100000|     100|0.97475910|  PASSED
          sts_serial|  12|    100000|     100|0.01131324|  PASSED
          sts_serial|  13|    100000|     100|0.44704736|  PASSED
          sts_serial|  13|    100000|     100|0.12129031|  PASSED
          sts_serial|  14|    100000|     100|0.75119668|  PASSED
          sts_serial|  14|    100000|     100|0.92222395|  PASSED
          sts_serial|  15|    100000|     100|0.62347427|  PASSED
          sts_serial|  15|    100000|     100|0.54302850|  PASSED
          sts_serial|  16|    100000|     100|0.80279783|  PASSED
          sts_serial|  16|    100000|     100|0.93313137|  PASSED
         rgb_bitdist|   1|    100000|     100|0.62238091|  PASSED
         rgb_bitdist|   2|    100000|     100|0.82425306|  PASSED
         rgb_bitdist|   3|    100000|     100|0.61441551|  PASSED
         rgb_bitdist|   4|    100000|     100|0.98030084|  PASSED
         rgb_bitdist|   5|    100000|     100|0.82659027|  PASSED
         rgb_bitdist|   6|    100000|     100|0.56376475|  PASSED
         rgb_bitdist|   7|    100000|     100|0.70811431|  PASSED
         rgb_bitdist|   8|    100000|     100|0.70289024|  PASSED
         rgb_bitdist|   9|    100000|     100|0.00229008|   WEAK
         rgb_bitdist|  10|    100000|     100|0.74555013|  PASSED
         rgb_bitdist|  11|    100000|     100|0.38949000|  PASSED
         rgb_bitdist|  12|    100000|     100|0.07011598|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.96824868|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.77681854|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.88843414|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.43551616|  PASSED
    rgb_permutations|   2|    100000|     100|0.43650766|  PASSED
    rgb_permutations|   3|    100000|     100|0.26866304|  PASSED
    rgb_permutations|   4|    100000|     100|0.63147800|  PASSED
    rgb_permutations|   5|    100000|     100|0.40374679|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.59480744|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.35484085|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.80070501|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.99787818|   WEAK
      rgb_lagged_sum|   4|   1000000|     100|0.99293157|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.91217551|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.76431330|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.01880524|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.44531056|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.70599134|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.94032085|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.12220660|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.95915238|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.89408791|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.65634815|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.70818238|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.33714258|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.48890855|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.57172963|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.41282137|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.13613917|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.74376301|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.84028598|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.26076309|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.83664333|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.63289045|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.67297228|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.75277186|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.71542923|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.26363550|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.03454470|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.54302270|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.88088959|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.67331603|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.18582232|  PASSED
             dab_dct| 256|     50000|       1|0.37247578|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.43533784|  PASSED
        dab_filltree|  32|  15000000|       1|0.60831188|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.01861691|  PASSED
       dab_filltree2|   1|   5000000|       1|0.44036163|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.70318922|  PASSED
#=============================================================================#
# Summary: PASSED=110, WEAK=4, FAILED=0                                       #
#          235.031,438 MB of random data created with 50,160 MB/sec           #
#=============================================================================#
#=============================================================================#
# Runtime: 1:18:05                                                            #
#=============================================================================#
*/
