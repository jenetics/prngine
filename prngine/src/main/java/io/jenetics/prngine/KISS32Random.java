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
package io.jenetics.prngine;

import static java.lang.String.format;
import static io.jenetics.prngine.utils.readInt;

import java.util.Random;

/**
 * Implementation of an simple PRNG as proposed in
 * <a href="http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf">
 * Good Practice in (Pseudo) Random Number Generation for Bioinformatics
 * Applications</a> (JKISS32, page 3) by <em><a href="mailto:d.jones@cs.ucl.ac.uk">
 * David Jones</a>, UCL Bioinformatics Group</em>.
 * <p>
 * The following listing shows the actual PRNG implementation.
 * <pre>{@code
 * private int x, y, z, w = <seed>
 * private int c = 0;
 *
 * int nextInt() {
 *     int t;
 *     y ^= y << 5;
 *     y ^= y >>> 7;
 *     y ^= y << 22;
 *
 *     t = z + w + c;
 *     z = w;
 *     c = t >>> 31;
 *     w = t & 2147483647;
 *     x += 1411392427;
 *
 *     return x + y + w;
 * }
 * }</pre>
 *
 * <p>
 * The period of this <i>PRNG</i> is &asymp; 2<sup>121</sup>
 * &asymp; 2.6&sdot;10<sup>36</sup>
 *
 * <p>
 * <strong>Not that the base implementation of the {@code KISS32Random}
 * class is not thread-safe.</strong> If multiple threads requests random
 * numbers from this class, it <i>must</i> be synchronized externally.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version !__version__!
 */
public class KISS32Random extends Random32 {

	/**
	 * The internal state of random engine.
	 *
	 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
	 * @since 1.0
	 * @version !__version__!
	 */
	private static final class State {
		private static final int SEED_BYTES = 16;

		int x, y, z, w, c;

		State(final byte[] seed) {
			if (seed.length < SEED_BYTES) {
				throw new IllegalArgumentException(format(
					"Required %d seed bytes, but got %d.",
					SEED_BYTES, seed.length
				));
			}

			x = readInt(seed, 0);
			y = readInt(seed, 1);
			z = readInt(seed, 2);
			w = readInt(seed, 3);
			c = 0;
		}
	}

	/* *************************************************************************
	 * Main class.
	 * ************************************************************************/

	/**
	 * The number of seed bytes (16) this PRNG requires.
	 */
	public static final int SEED_BYTES = State.SEED_BYTES;

	private final State state;

	/**
	 * Create a new <em>not</em> thread-safe instance of the {@code KISS32Random}
	 * engine.
	 *
	 * <pre>{@code
	 * final byte[] seed = KISS32Random.seedBytes();
	 * final RandomGenerator random = new KISS32Random(seed);
	 * }</pre>
	 *
	 * @see #seedBytes()
	 *
	 * @param seed the random seed value. The seed must be (at least)
	 *        {@link #SEED_BYTES} long.
	 * @throws IllegalArgumentException if the given seed is shorter than
	 *         {@link #SEED_BYTES}
	 */
	public KISS32Random(final byte[] seed) {
		state = new State(seed);
	}

	/**
	 * Create a new <em>not</em> thread-safe instance of the {@code KISS32Random}
	 * engine. The constructed PRNG is equivalent with
	 * <pre>{@code
	 * final long seed = ...;
	 * final Random random = new KISS32Random();
	 * random.setSeed(seed);
	 * }</pre>
	 * which is there for compatibility reasons with the Java {@link Random}
	 * engine.
	 *
	 * @param seed the random seed value
	 */
	public KISS32Random(final long seed) {
		this(Seeds.expandSeedToBytes(seed, SEED_BYTES));
	}

	/**
	 * Create a new <em>not</em> thread-safe instance of the {@code KISS32Random}
	 * engine. The PRNG is initialized with {@link #seedBytes()}.
	 */
	public KISS32Random() {
		this(seedBytes());
	}

	@Override
	public int nextInt() {
		state.y ^= state.y << 5;
		state.y ^= state.y >>> 7;
		state.y ^= state.y << 22;

		final int t = state.z + state.w + state.c;
		state.z = state.w;
		state.c = t >>> 31;
		state.w = t&2147483647;
		state.x += 1411392427;

		return state.x + state.y + state.w;
	}

	/**
	 * Create a new <em>seed</em> byte array suitable for this PRNG. The
	 * returned seed array is {@link #SEED_BYTES} long.
	 *
	 * @see Seeds#seedBytes(int)
	 *
	 * @return a new <em>seed</em> byte array of length {@link #SEED_BYTES}
	 */
	public static byte[] seedBytes() {
		return Seeds.seedBytes(SEED_BYTES);
	}

}

/*
#=============================================================================#
# Testing: org.jenetics.random.KISS32Random (2016-09-29 22:12)                #
#=============================================================================#
#=============================================================================#
# Linux 4.4.0-38-generic (amd64)                                              #
# java version "1.8.0_102"                                                    #
# Java(TM) SE Runtime Environment (build 1.8.0_102-b14)                       #
# Java HotSpot(TM) 64-Bit Server VM (build 25.102-b14)                        #
#=============================================================================#
#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  4.62e+07  |2265299075|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.55535722|  PASSED
      diehard_operm5|   0|   1000000|     100|0.76876591|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.36859167|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.69162523|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.66626521|  PASSED
        diehard_opso|   0|   2097152|     100|0.66718776|  PASSED
        diehard_oqso|   0|   2097152|     100|0.98783832|  PASSED
         diehard_dna|   0|   2097152|     100|0.99896257|   WEAK
diehard_count_1s_str|   0|    256000|     100|0.18260425|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.56757988|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.16579004|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.89796932|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.41719032|  PASSED
     diehard_squeeze|   0|    100000|     100|0.99011490|  PASSED
        diehard_sums|   0|       100|     100|0.46755440|  PASSED
        diehard_runs|   0|    100000|     100|0.07707424|  PASSED
        diehard_runs|   0|    100000|     100|0.49713031|  PASSED
       diehard_craps|   0|    200000|     100|0.68722910|  PASSED
       diehard_craps|   0|    200000|     100|0.80666991|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.12401733|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.84594454|  PASSED
         sts_monobit|   1|    100000|     100|0.34304695|  PASSED
            sts_runs|   2|    100000|     100|0.04820776|  PASSED
          sts_serial|   1|    100000|     100|0.44750704|  PASSED
          sts_serial|   2|    100000|     100|0.85679253|  PASSED
          sts_serial|   3|    100000|     100|0.92707600|  PASSED
          sts_serial|   3|    100000|     100|0.77327827|  PASSED
          sts_serial|   4|    100000|     100|0.98841389|  PASSED
          sts_serial|   4|    100000|     100|0.72248283|  PASSED
          sts_serial|   5|    100000|     100|0.96505715|  PASSED
          sts_serial|   5|    100000|     100|0.58249979|  PASSED
          sts_serial|   6|    100000|     100|0.73642816|  PASSED
          sts_serial|   6|    100000|     100|0.41886772|  PASSED
          sts_serial|   7|    100000|     100|0.68037807|  PASSED
          sts_serial|   7|    100000|     100|0.97031075|  PASSED
          sts_serial|   8|    100000|     100|0.63251435|  PASSED
          sts_serial|   8|    100000|     100|0.30112464|  PASSED
          sts_serial|   9|    100000|     100|0.60820100|  PASSED
          sts_serial|   9|    100000|     100|0.35032978|  PASSED
          sts_serial|  10|    100000|     100|0.92808212|  PASSED
          sts_serial|  10|    100000|     100|0.79007610|  PASSED
          sts_serial|  11|    100000|     100|0.74982933|  PASSED
          sts_serial|  11|    100000|     100|0.23908370|  PASSED
          sts_serial|  12|    100000|     100|0.86923729|  PASSED
          sts_serial|  12|    100000|     100|0.23756072|  PASSED
          sts_serial|  13|    100000|     100|0.85706323|  PASSED
          sts_serial|  13|    100000|     100|0.86960370|  PASSED
          sts_serial|  14|    100000|     100|0.46731737|  PASSED
          sts_serial|  14|    100000|     100|0.14802675|  PASSED
          sts_serial|  15|    100000|     100|0.60289416|  PASSED
          sts_serial|  15|    100000|     100|0.74117464|  PASSED
          sts_serial|  16|    100000|     100|0.89192987|  PASSED
          sts_serial|  16|    100000|     100|0.64966691|  PASSED
         rgb_bitdist|   1|    100000|     100|0.53268767|  PASSED
         rgb_bitdist|   2|    100000|     100|0.98573281|  PASSED
         rgb_bitdist|   3|    100000|     100|0.23889975|  PASSED
         rgb_bitdist|   4|    100000|     100|0.12541853|  PASSED
         rgb_bitdist|   5|    100000|     100|0.70123091|  PASSED
         rgb_bitdist|   6|    100000|     100|0.97738708|  PASSED
         rgb_bitdist|   7|    100000|     100|0.42879387|  PASSED
         rgb_bitdist|   8|    100000|     100|0.25646583|  PASSED
         rgb_bitdist|   9|    100000|     100|0.67329703|  PASSED
         rgb_bitdist|  10|    100000|     100|0.85853725|  PASSED
         rgb_bitdist|  11|    100000|     100|0.99795269|   WEAK
         rgb_bitdist|  12|    100000|     100|0.74241853|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.99177466|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.68235279|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.83292329|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.78066619|  PASSED
    rgb_permutations|   2|    100000|     100|0.94634603|  PASSED
    rgb_permutations|   3|    100000|     100|0.07891847|  PASSED
    rgb_permutations|   4|    100000|     100|0.91606921|  PASSED
    rgb_permutations|   5|    100000|     100|0.48792567|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.97683820|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.53879827|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.66362050|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.75387985|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.65335968|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.71879262|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.48344883|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.33447926|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.89278899|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.07282754|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.92641204|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.60909908|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.57544425|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.39703509|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.37732883|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.77517969|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.67179658|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.99998043|   WEAK
      rgb_lagged_sum|  18|   1000000|     100|0.87690390|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.99597108|   WEAK
      rgb_lagged_sum|  20|   1000000|     100|0.50684575|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.72488174|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.17730397|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.21772195|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.31062369|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.20819840|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.38985919|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.52991363|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.86684778|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.80273740|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.47508669|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.94128727|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.51061648|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.60312487|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.48742068|  PASSED
             dab_dct| 256|     50000|       1|0.38913063|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.48041901|  PASSED
        dab_filltree|  32|  15000000|       1|0.06710978|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.80253491|  PASSED
       dab_filltree2|   1|   5000000|       1|0.29685622|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.76828048|  PASSED
#=============================================================================#
# Summary: PASSED=110, WEAK=4, FAILED=0                                       #
#          235,031.461 MB of random data created with 120.402 MB/sec          #
#=============================================================================#
#=============================================================================#
# Runtime: 0:32:32                                                            #
#=============================================================================#
*/
