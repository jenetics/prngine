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

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @version 1.0
 * @since 1.0
 */
public final class ObjectHashRandom implements RandomGenerator {
	private static final class ObjectSeedSource {
		static long seed() {
			final long a = new ObjectSeedSource().hashCode();
			final long b = new ObjectSeedSource().hashCode();
			return mixStafford13(a << 32 | b);
		}
		private static long mixStafford13(final long z) {
			long v = (z^(z >>> 30))*0xbf58476d1ce4e5b9L;
			v = (v^(v >>> 27))*0x94d049bb133111ebL;
			return v^(v >>> 31);
		}
	}

	@Override
	public long nextLong() {
		return ObjectSeedSource.seed();
	}
}

/*
#=============================================================================#
# Testing: ObjectHashRandom (2022-02-18 10:48)                                #
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
stdin_input_raw|  2.08e+07  | 804218784|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.99696838|   WEAK
      diehard_operm5|   0|   1000000|     100|0.92800356|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.58587696|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.67880148|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.78114896|  PASSED
        diehard_opso|   0|   2097152|     100|0.22556020|  PASSED
        diehard_oqso|   0|   2097152|     100|0.57996074|  PASSED
         diehard_dna|   0|   2097152|     100|0.74329901|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.59039812|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.29136984|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.35955403|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.98737167|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.13362943|  PASSED
     diehard_squeeze|   0|    100000|     100|0.39279459|  PASSED
        diehard_sums|   0|       100|     100|0.00579638|  PASSED
        diehard_runs|   0|    100000|     100|0.54336767|  PASSED
        diehard_runs|   0|    100000|     100|0.43201299|  PASSED
       diehard_craps|   0|    200000|     100|0.51545713|  PASSED
       diehard_craps|   0|    200000|     100|0.93377294|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.78489023|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.14450678|  PASSED
         sts_monobit|   1|    100000|     100|0.05491415|  PASSED
            sts_runs|   2|    100000|     100|0.16992887|  PASSED
          sts_serial|   1|    100000|     100|0.31183505|  PASSED
          sts_serial|   2|    100000|     100|0.14997635|  PASSED
          sts_serial|   3|    100000|     100|0.22538178|  PASSED
          sts_serial|   3|    100000|     100|0.84806156|  PASSED
          sts_serial|   4|    100000|     100|0.24506937|  PASSED
          sts_serial|   4|    100000|     100|0.41520327|  PASSED
          sts_serial|   5|    100000|     100|0.96837485|  PASSED
          sts_serial|   5|    100000|     100|0.90874089|  PASSED
          sts_serial|   6|    100000|     100|0.66675368|  PASSED
          sts_serial|   6|    100000|     100|0.81135454|  PASSED
          sts_serial|   7|    100000|     100|0.76953932|  PASSED
          sts_serial|   7|    100000|     100|0.93358237|  PASSED
          sts_serial|   8|    100000|     100|0.35380123|  PASSED
          sts_serial|   8|    100000|     100|0.34710439|  PASSED
          sts_serial|   9|    100000|     100|0.63774008|  PASSED
          sts_serial|   9|    100000|     100|0.54969595|  PASSED
          sts_serial|  10|    100000|     100|0.45288840|  PASSED
          sts_serial|  10|    100000|     100|0.98090636|  PASSED
          sts_serial|  11|    100000|     100|0.49385641|  PASSED
          sts_serial|  11|    100000|     100|0.91862474|  PASSED
          sts_serial|  12|    100000|     100|0.10677760|  PASSED
          sts_serial|  12|    100000|     100|0.72777177|  PASSED
          sts_serial|  13|    100000|     100|0.95288137|  PASSED
          sts_serial|  13|    100000|     100|0.70199241|  PASSED
          sts_serial|  14|    100000|     100|0.71731533|  PASSED
          sts_serial|  14|    100000|     100|0.20375968|  PASSED
          sts_serial|  15|    100000|     100|0.87210611|  PASSED
          sts_serial|  15|    100000|     100|0.60539052|  PASSED
          sts_serial|  16|    100000|     100|0.49509519|  PASSED
          sts_serial|  16|    100000|     100|0.34603821|  PASSED
         rgb_bitdist|   1|    100000|     100|0.73301640|  PASSED
         rgb_bitdist|   2|    100000|     100|0.88138055|  PASSED
         rgb_bitdist|   3|    100000|     100|0.70522438|  PASSED
         rgb_bitdist|   4|    100000|     100|0.10519718|  PASSED
         rgb_bitdist|   5|    100000|     100|0.39233210|  PASSED
         rgb_bitdist|   6|    100000|     100|0.49879063|  PASSED
         rgb_bitdist|   7|    100000|     100|0.76375879|  PASSED
         rgb_bitdist|   8|    100000|     100|0.16581409|  PASSED
         rgb_bitdist|   9|    100000|     100|0.05734941|  PASSED
         rgb_bitdist|  10|    100000|     100|0.78644617|  PASSED
         rgb_bitdist|  11|    100000|     100|0.39221429|  PASSED
         rgb_bitdist|  12|    100000|     100|0.63490364|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.51032172|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.33167486|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.09761856|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.47438347|  PASSED
    rgb_permutations|   2|    100000|     100|0.40907488|  PASSED
    rgb_permutations|   3|    100000|     100|0.90247398|  PASSED
    rgb_permutations|   4|    100000|     100|0.07989399|  PASSED
    rgb_permutations|   5|    100000|     100|0.73409233|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.35214188|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.56463435|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.35308951|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.66235047|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.13452500|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.43415499|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.43922853|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.01634727|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.74352694|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.80734758|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.33162169|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.39560082|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.82450984|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.93890308|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.33732127|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.28655495|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.12836181|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.70603892|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.48610400|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.33347950|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.67289406|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.16729529|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.71997265|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.62581610|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.36530495|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.63770552|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.20671279|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.93391265|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.41293126|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.41500133|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.93579948|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.80067576|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.81160373|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.06838945|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.68560256|  PASSED
             dab_dct| 256|     50000|       1|0.51809345|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.96941853|  PASSED
        dab_filltree|  32|  15000000|       1|0.15035661|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.31514109|  PASSED
       dab_filltree2|   1|   5000000|       1|0.66857458|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.85348739|  PASSED
#=============================================================================#
# Summary: PASSED=113, WEAK=1, FAILED=0                                       #
#          235.031,492 MB of random data created with 73,639 MB/sec           #
#=============================================================================#
#=============================================================================#
# Runtime: 0:53:11                                                            #
#=============================================================================#
*/
