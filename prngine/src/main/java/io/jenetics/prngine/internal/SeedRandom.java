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

import io.jenetics.prngine.PRNG;
import io.jenetics.prngine.Random64;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 1.0
 */
public final class SeedRandom extends Random64 {

	private static final long serialVersionUID = 1L;

	@Override
	public long nextLong() {
		return PRNG.seed();
	}

}

/*
#=============================================================================#
# Testing: io.jenetics.prngine.internal.SeedRandom (2017-03-03 03:31)         #
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
stdin_input_raw|  1.80e+07  |3661220842|
#=============================================================================#
		test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
diehard_birthdays|   0|       100|     100|0.80879726|  PASSED
	diehard_operm5|   0|   1000000|     100|0.89784192|  PASSED
diehard_rank_32x32|   0|     40000|     100|0.49876303|  PASSED
	diehard_rank_6x8|   0|    100000|     100|0.48695002|  PASSED
diehard_bitstream|   0|   2097152|     100|0.91012903|  PASSED
		diehard_opso|   0|   2097152|     100|0.79515040|  PASSED
		diehard_oqso|   0|   2097152|     100|0.11317405|  PASSED
		diehard_dna|   0|   2097152|     100|0.91310284|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.82656457|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.29456352|  PASSED
diehard_parking_lot|   0|     12000|     100|0.18103491|  PASSED
	diehard_2dsphere|   2|      8000|     100|0.72159911|  PASSED
	diehard_3dsphere|   3|      4000|     100|0.25239274|  PASSED
	diehard_squeeze|   0|    100000|     100|0.32910035|  PASSED
		diehard_sums|   0|       100|     100|0.01507325|  PASSED
		diehard_runs|   0|    100000|     100|0.02632514|  PASSED
		diehard_runs|   0|    100000|     100|0.43060182|  PASSED
	diehard_craps|   0|    200000|     100|0.91561498|  PASSED
	diehard_craps|   0|    200000|     100|0.97896092|  PASSED
marsaglia_tsang_gcd|   0|  10000000|     100|0.74475043|  PASSED
marsaglia_tsang_gcd|   0|  10000000|     100|0.45297002|  PASSED
		sts_monobit|   1|    100000|     100|0.31805718|  PASSED
			sts_runs|   2|    100000|     100|0.09857592|  PASSED
		sts_serial|   1|    100000|     100|0.41813564|  PASSED
		sts_serial|   2|    100000|     100|0.09278960|  PASSED
		sts_serial|   3|    100000|     100|0.84946003|  PASSED
		sts_serial|   3|    100000|     100|0.52498822|  PASSED
		sts_serial|   4|    100000|     100|0.98277134|  PASSED
		sts_serial|   4|    100000|     100|0.55918531|  PASSED
		sts_serial|   5|    100000|     100|0.41062514|  PASSED
		sts_serial|   5|    100000|     100|0.62648261|  PASSED
		sts_serial|   6|    100000|     100|0.99990141|   WEAK
		sts_serial|   6|    100000|     100|0.23034072|  PASSED
		sts_serial|   7|    100000|     100|0.56432143|  PASSED
		sts_serial|   7|    100000|     100|0.27724453|  PASSED
		sts_serial|   8|    100000|     100|0.96206177|  PASSED
		sts_serial|   8|    100000|     100|0.25201884|  PASSED
		sts_serial|   9|    100000|     100|0.31763486|  PASSED
		sts_serial|   9|    100000|     100|0.65675980|  PASSED
		sts_serial|  10|    100000|     100|0.20445493|  PASSED
		sts_serial|  10|    100000|     100|0.76179233|  PASSED
		sts_serial|  11|    100000|     100|0.33778473|  PASSED
		sts_serial|  11|    100000|     100|0.80606360|  PASSED
		sts_serial|  12|    100000|     100|0.97301278|  PASSED
		sts_serial|  12|    100000|     100|0.88124186|  PASSED
		sts_serial|  13|    100000|     100|0.98994846|  PASSED
		sts_serial|  13|    100000|     100|0.61561347|  PASSED
		sts_serial|  14|    100000|     100|0.23008969|  PASSED
		sts_serial|  14|    100000|     100|0.48920599|  PASSED
		sts_serial|  15|    100000|     100|0.25556506|  PASSED
		sts_serial|  15|    100000|     100|0.49892223|  PASSED
		sts_serial|  16|    100000|     100|0.08158279|  PASSED
		sts_serial|  16|    100000|     100|0.78161338|  PASSED
		rgb_bitdist|   1|    100000|     100|0.98865357|  PASSED
		rgb_bitdist|   2|    100000|     100|0.13505094|  PASSED
		rgb_bitdist|   3|    100000|     100|0.99999957|  FAILED
		rgb_bitdist|   4|    100000|     100|0.95045654|  PASSED
		rgb_bitdist|   5|    100000|     100|0.69844729|  PASSED
		rgb_bitdist|   6|    100000|     100|0.82276440|  PASSED
		rgb_bitdist|   7|    100000|     100|0.46754009|  PASSED
		rgb_bitdist|   8|    100000|     100|0.93100123|  PASSED
		rgb_bitdist|   9|    100000|     100|0.97547356|  PASSED
		rgb_bitdist|  10|    100000|     100|0.73062085|  PASSED
		rgb_bitdist|  11|    100000|     100|0.26207725|  PASSED
		rgb_bitdist|  12|    100000|     100|0.48499464|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.78328676|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.29126221|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.93349270|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.25989540|  PASSED
	rgb_permutations|   2|    100000|     100|0.46473861|  PASSED
	rgb_permutations|   3|    100000|     100|0.65782817|  PASSED
	rgb_permutations|   4|    100000|     100|0.94121241|  PASSED
	rgb_permutations|   5|    100000|     100|0.97894487|  PASSED
	rgb_lagged_sum|   0|   1000000|     100|0.98450107|  PASSED
	rgb_lagged_sum|   1|   1000000|     100|0.36927158|  PASSED
	rgb_lagged_sum|   2|   1000000|     100|0.05097375|  PASSED
	rgb_lagged_sum|   3|   1000000|     100|0.67696472|  PASSED
	rgb_lagged_sum|   4|   1000000|     100|0.63500537|  PASSED
	rgb_lagged_sum|   5|   1000000|     100|0.91812256|  PASSED
	rgb_lagged_sum|   6|   1000000|     100|0.76884401|  PASSED
	rgb_lagged_sum|   7|   1000000|     100|0.79205773|  PASSED
	rgb_lagged_sum|   8|   1000000|     100|0.36462610|  PASSED
	rgb_lagged_sum|   9|   1000000|     100|0.30351732|  PASSED
	rgb_lagged_sum|  10|   1000000|     100|0.85349654|  PASSED
	rgb_lagged_sum|  11|   1000000|     100|0.23733566|  PASSED
	rgb_lagged_sum|  12|   1000000|     100|0.12759286|  PASSED
	rgb_lagged_sum|  13|   1000000|     100|0.70889661|  PASSED
	rgb_lagged_sum|  14|   1000000|     100|0.05180929|  PASSED
	rgb_lagged_sum|  15|   1000000|     100|0.33186904|  PASSED
	rgb_lagged_sum|  16|   1000000|     100|0.71239135|  PASSED
	rgb_lagged_sum|  17|   1000000|     100|0.71022467|  PASSED
	rgb_lagged_sum|  18|   1000000|     100|0.92672056|  PASSED
	rgb_lagged_sum|  19|   1000000|     100|0.17650208|  PASSED
	rgb_lagged_sum|  20|   1000000|     100|0.22011306|  PASSED
	rgb_lagged_sum|  21|   1000000|     100|0.60450414|  PASSED
	rgb_lagged_sum|  22|   1000000|     100|0.90933189|  PASSED
	rgb_lagged_sum|  23|   1000000|     100|0.65556895|  PASSED
	rgb_lagged_sum|  24|   1000000|     100|0.58149509|  PASSED
	rgb_lagged_sum|  25|   1000000|     100|0.74465075|  PASSED
	rgb_lagged_sum|  26|   1000000|     100|0.83450810|  PASSED
	rgb_lagged_sum|  27|   1000000|     100|0.28469222|  PASSED
	rgb_lagged_sum|  28|   1000000|     100|0.89287884|  PASSED
	rgb_lagged_sum|  29|   1000000|     100|0.68278352|  PASSED
	rgb_lagged_sum|  30|   1000000|     100|0.84390304|  PASSED
	rgb_lagged_sum|  31|   1000000|     100|0.99676822|   WEAK
	rgb_lagged_sum|  32|   1000000|     100|0.27832571|  PASSED
	rgb_kstest_test|   0|     10000|    1000|0.81679024|  PASSED
	dab_bytedistrib|   0|  51200000|       1|0.84647886|  PASSED
			dab_dct| 256|     50000|       1|0.10758683|  PASSED
Preparing to run test 207.  ntuple = 0
		dab_filltree|  32|  15000000|       1|0.17345638|  PASSED
		dab_filltree|  32|  15000000|       1|0.40697045|  PASSED
Preparing to run test 208.  ntuple = 0
	dab_filltree2|   0|   5000000|       1|0.08049150|  PASSED
	dab_filltree2|   1|   5000000|       1|0.22583776|  PASSED
Preparing to run test 209.  ntuple = 0
		dab_monobit2|  12|  65000000|       1|0.88057640|  PASSED
#=============================================================================#
# Summary: PASSED=111, WEAK=2, FAILED=1                                       #
#          235,031.336 MB of random data created with 53.069 MB/sec           #
#=============================================================================#
#=============================================================================#
# Runtime: 1:13:48                                                            #
#=============================================================================#
*/
