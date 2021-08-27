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
# Testing: io.jenetics.prngine.internal.ObjectHashRandom (2017-03-03 02:23)   #
#=============================================================================#
#=============================================================================#
# Linux 4.8.0-40-generic (amd64)                                              #
# java version "1.8.0_112"                                                    #
# Java(TM) SE Runtime Environment (build 1.8.0_112-b15)                       #
# Java HotSpot(TM) 64-Bit Server VM (build 25.112-b15)                        #
#=============================================================================#
#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
rng_name    |rands/second|   Seed   |
stdin_input_raw|  2.37e+07  |  37135072|
#=============================================================================#
		test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
diehard_birthdays|   0|       100|     100|0.76290408|  PASSED
	diehard_operm5|   0|   1000000|     100|0.60551289|  PASSED
diehard_rank_32x32|   0|     40000|     100|0.00000000|  FAILED
	diehard_rank_6x8|   0|    100000|     100|0.28065701|  PASSED
diehard_bitstream|   0|   2097152|     100|0.00000000|  FAILED
		diehard_opso|   0|   2097152|     100|0.04182323|  PASSED
		diehard_oqso|   0|   2097152|     100|0.90022964|  PASSED
		diehard_dna|   0|   2097152|     100|0.00000000|  FAILED
diehard_count_1s_str|   0|    256000|     100|0.00000000|  FAILED
diehard_count_1s_byt|   0|    256000|     100|0.00000000|  FAILED
diehard_parking_lot|   0|     12000|     100|0.00000000|  FAILED
	diehard_2dsphere|   2|      8000|     100|0.00000000|  FAILED
	diehard_3dsphere|   3|      4000|     100|0.00000000|  FAILED
	diehard_squeeze|   0|    100000|     100|0.00000000|  FAILED
		diehard_sums|   0|       100|     100|0.00000000|  FAILED
		diehard_runs|   0|    100000|     100|0.06878659|  PASSED
		diehard_runs|   0|    100000|     100|0.59930805|  PASSED
	diehard_craps|   0|    200000|     100|0.00000000|  FAILED
	diehard_craps|   0|    200000|     100|0.00000000|  FAILED
marsaglia_tsang_gcd|   0|  10000000|     100|0.00000000|  FAILED
marsaglia_tsang_gcd|   0|  10000000|     100|0.18943916|  PASSED
		sts_monobit|   1|    100000|     100|0.00000000|  FAILED
			sts_runs|   2|    100000|     100|0.00000000|  FAILED
		sts_serial|   1|    100000|     100|0.00000000|  FAILED
		sts_serial|   2|    100000|     100|0.00000000|  FAILED
		sts_serial|   3|    100000|     100|0.00000000|  FAILED
		sts_serial|   3|    100000|     100|0.95999522|  PASSED
		sts_serial|   4|    100000|     100|0.00000000|  FAILED
		sts_serial|   4|    100000|     100|0.26178675|  PASSED
		sts_serial|   5|    100000|     100|0.00000000|  FAILED
		sts_serial|   5|    100000|     100|0.87233306|  PASSED
		sts_serial|   6|    100000|     100|0.00000000|  FAILED
		sts_serial|   6|    100000|     100|0.98551082|  PASSED
		sts_serial|   7|    100000|     100|0.00000000|  FAILED
		sts_serial|   7|    100000|     100|0.43253610|  PASSED
		sts_serial|   8|    100000|     100|0.00000000|  FAILED
		sts_serial|   8|    100000|     100|0.13145682|  PASSED
		sts_serial|   9|    100000|     100|0.00000000|  FAILED
		sts_serial|   9|    100000|     100|0.35892706|  PASSED
		sts_serial|  10|    100000|     100|0.00000000|  FAILED
		sts_serial|  10|    100000|     100|0.21327351|  PASSED
		sts_serial|  11|    100000|     100|0.00000000|  FAILED
		sts_serial|  11|    100000|     100|0.15287650|  PASSED
		sts_serial|  12|    100000|     100|0.00000000|  FAILED
		sts_serial|  12|    100000|     100|0.53955683|  PASSED
		sts_serial|  13|    100000|     100|0.00000000|  FAILED
		sts_serial|  13|    100000|     100|0.83742508|  PASSED
		sts_serial|  14|    100000|     100|0.00000000|  FAILED
		sts_serial|  14|    100000|     100|0.33667462|  PASSED
		sts_serial|  15|    100000|     100|0.00000000|  FAILED
		sts_serial|  15|    100000|     100|0.21037352|  PASSED
		sts_serial|  16|    100000|     100|0.00000000|  FAILED
		sts_serial|  16|    100000|     100|0.61982184|  PASSED
		rgb_bitdist|   1|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   2|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   3|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   4|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   5|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   6|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   7|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   8|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|   9|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|  10|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|  11|    100000|     100|0.00000000|  FAILED
		rgb_bitdist|  12|    100000|     100|0.00000000|  FAILED
rgb_minimum_distance|   2|     10000|    1000|0.00000000|  FAILED
rgb_minimum_distance|   3|     10000|    1000|0.00000000|  FAILED
rgb_minimum_distance|   4|     10000|    1000|0.00000000|  FAILED
rgb_minimum_distance|   5|     10000|    1000|0.00000000|  FAILED
	rgb_permutations|   2|    100000|     100|0.91719366|  PASSED
	rgb_permutations|   3|    100000|     100|0.89536099|  PASSED
	rgb_permutations|   4|    100000|     100|0.45245209|  PASSED
	rgb_permutations|   5|    100000|     100|0.98806221|  PASSED
	rgb_lagged_sum|   0|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   1|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   2|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   3|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   4|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   5|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   6|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   7|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   8|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|   9|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  10|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  11|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  12|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  13|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  14|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  15|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  16|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  17|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  18|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  19|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  20|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  21|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  22|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  23|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  24|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  25|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  26|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  27|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  28|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  29|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  30|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  31|   1000000|     100|0.00000000|  FAILED
	rgb_lagged_sum|  32|   1000000|     100|0.00000000|  FAILED
	rgb_kstest_test|   0|     10000|    1000|0.00000000|  FAILED
	dab_bytedistrib|   0|  51200000|       1|0.00000000|  FAILED
			dab_dct| 256|     50000|       1|0.00000000|  FAILED
Preparing to run test 207.  ntuple = 0
		dab_filltree|  32|  15000000|       1|0.30773420|  PASSED
		dab_filltree|  32|  15000000|       1|0.90771712|  PASSED
Preparing to run test 208.  ntuple = 0
	dab_filltree2|   0|   5000000|       1|0.00000000|  FAILED
	dab_filltree2|   1|   5000000|       1|0.00000000|  FAILED
Preparing to run test 209.  ntuple = 0
		dab_monobit2|  12|  65000000|       1|1.00000000|  FAILED
#=============================================================================#
# Summary: PASSED=28, WEAK=0, FAILED=86                                       #
#          234,759.852 MB of random data created with 57.421 MB/sec           #
#=============================================================================#
#=============================================================================#
# Runtime: 1:08:08                                                            #
#=============================================================================#
*/
