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
import static java.util.Objects.requireNonNull;
import static io.jenetics.prngine.Bytes.readLong;
import static io.jenetics.prngine.IntMath.log2Floor;

import java.util.random.RandomGenerator;

/**
 * This class implements a linear congruential PRNG with additional bit-shift
 * transition.
 *
 * <em>
 * This is a port of the
 * <a href="https://github.com/rabauke/trng4/blob/master/src/lcg64_shift.hpp">
 * trng::lcg64_shift</a> PRNG class of the
 * <a href="http://numbercrunch.de/trng/">TRNG</a> library created by Heiko
 * Bauke.</em>
 *
 * <p>
 * The following listing shows the actual PRNG implementation.
 * <pre>{@code
 * final long a, b = <params>
 * long r = <seed>
 *
 * long nextLong() {
 *     r = q*r + b;
 *
 *     long t = r;
 *     t ^= t >>> 17;
 *     t ^= t << 31;
 *     t ^= t >>> 8;
 *     return t;
 * }
 * }</pre>
 *
 * <p>
 * <strong>Not that the base implementation of the {@code LCG64ShiftRandom}
 * class is not thread-safe.</strong> If multiple threads requests random
 * numbers from this class, it <i>must</i> be synchronized externally.
 *
 * @see <a href="https://github.com/rabauke/trng4/blob/master/doc/trng.pdf">TRNG</a>
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 2.0.0
 */
public class LCG64ShiftRandom implements RandomGenerator.ArbitrarilyJumpableGenerator {

	/* *************************************************************************
	 * Parameter classes.
	 * ************************************************************************/

	/**
	 * Parameter class for the {@code LCG64ShiftRandom} generator, for the
	 * parameters <i>a</i> and <i>b</i> of the LC recursion
	 * <i>r<sub>i+1</sub> = a · r<sub>i</sub> + b</i> mod <i>2<sup>64</sup></i>.
	 *
	 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
	 * @since 1.1
	 * @version 2.0.0
	 *
	 * @param a the LEcuyer parameter a
	 * @param b the LEcuyer parameter b
	 */
	public static final record Param(long a, long b) {

		/**
		 * The default PRNG parameters: a = 0xFBD19FBBC5C07FF5L; b = 1
		 */
		public static final Param DEFAULT = new Param(0xFBD19FBBC5C07FF5L, 1L);

		/**
		 * LEcuyer 1 parameters: a = 0x27BB2EE687B0B0FDL; b = 1
		 */
		public static final Param LECUYER1 = new Param(0x27BB2EE687B0B0FDL, 1L);

		/**
		 * LEcuyer 2 parameters: a = 0x2C6FE96EE78B6955L; b = 1
		 */
		public static final Param LECUYER2 = new Param(0x2C6FE96EE78B6955L, 1L);

		/**
		 * LEcuyer 3 parameters: a = 0x369DEA0F31A53F85L; b = 1
		 */
		public static final Param LECUYER3 = new Param(0x369DEA0F31A53F85L, 1L);

	}


	/**
	 * Represents the state of this random engine
	 */
	private final static class State {
		static final int SEED_BYTES = 8;

		long r;

		private State(final State state) {
			this.r = state.r;
		}

		State(final byte[] seed) {
			if (seed.length < SEED_BYTES) {
				throw new IllegalArgumentException(format(
					"Required %d seed bytes, but got %d.",
					SEED_BYTES, seed.length
				));
			}

			r = readLong(seed, 0);
		}
	}


	/**
	 * The number of seed bytes (8) this PRNG requires.
	 */
	public static final int SEED_BYTES = State.SEED_BYTES;

	private Param param;
	private final State state;

	private LCG64ShiftRandom(final Param param, final State state) {
		this.param = requireNonNull(param);
		this.state = new State(state);
	}

	/**
	 * Create a new PRNG instance with the given parameter and seed.
	 *
	 * @param param the parameter of the PRNG.
	 * @param seed the seed of the PRNG.
	 * @throws NullPointerException if the given {@code param} or {@code seed}
	 *         is {@code null}.
	 * @throws IllegalArgumentException if the given seed is shorter than
	 *         {@link #SEED_BYTES}
	 */
	public LCG64ShiftRandom(final Param param, final byte[] seed) {
		this.param = requireNonNull(param, "PRNG param must not be null.");
		state = new State(seed);
	}

	/**
	 * Create a new PRNG instance with the given parameter and seed.
	 *
	 * @param param the parameter of the PRNG.
	 * @param seed the seed of the PRNG.
	 * @throws NullPointerException if the given {@code param} is {@code null}.
	 */
	public LCG64ShiftRandom(final Param param, final long seed) {
		this(param, Seeds.expandSeedToBytes(seed, SEED_BYTES));
	}

	/**
	 * Create a new PRNG instance with the given parameter and a safe seed
	 *
	 * @param param the PRNG parameter.
	 * @throws NullPointerException if the given {@code param} is null.
	 */
	public LCG64ShiftRandom(final Param param) {
		this(param, seedBytes());
	}

	/**
	 * Create a new PRNG instance with the given parameter and seed.
	 *
	 * @param seed the seed of the PRNG.
	 * @throws NullPointerException if the given {@code seed} is {@code null}.
	 * @throws IllegalArgumentException if the given seed is shorter than
	 *         {@link #SEED_BYTES}
	 */
	public LCG64ShiftRandom(final byte[] seed) {
		this(Param.DEFAULT, seed);
	}

	/**
	 * Create a new PRNG instance with {@link Param#DEFAULT} parameter and the
	 * given seed.
	 *
	 * @param seed the seed of the PRNG
	 */
	public LCG64ShiftRandom(final long seed) {
		this(Param.DEFAULT, Seeds.expandSeedToBytes(seed, SEED_BYTES));
	}

	/**
	 * Create a new PRNG instance with {@link Param#DEFAULT} parameter and safe
	 * seed.
	 */
	public LCG64ShiftRandom() {
		this(Param.DEFAULT, Seeds.seed());
	}

	@Override
	public long nextLong() {
		step();

		long t = state.r;
		t ^= t >>> 17;
		t ^= t << 31;
		t ^= t >>> 8;
		return t;
	}

	private void step() {
		state.r = param.a* state.r + param.b;
	}

	/**
	 * Changes the internal state of the PRNG in a way that future calls to
	 * {@link #nextLong()} will generated the s<sup>th</sup> sub-stream of
	 * p<sup>th</sup> sub-streams. <i>s</i> must be within the range of
	 * {@code [0, p-1)}. This method is mainly used for <i>parallelization</i>
	 * via <i>leap-frogging</i>.
	 *
	 * @param p the overall number of sub-streams
	 * @param s the s<sup>th</sup> sub-stream
	 * @throws IllegalArgumentException if {@code p < 1 || s >= p}.
	 */
	public void split(final int p, final int s) {
		if (p < 1) {
			throw new IllegalArgumentException(format(
				"p must be >= 1 but was %d.", p
			));
		}
		if (s >= p) {
			throw new IllegalArgumentException(format(
				"s must be < %d but was %d.", p, s
			));
		}

		if (p > 1) {
			jump(s + 1);
			final long b = param.b*f(p, param.a);
			final long a = IntMath.pow(param.a, p);
			param = new Param(a, b);
			backward();
		}
	}

	/**
	 * Changes the internal state of the PRNG in such a way that the engine
	 * <i>jumps</i> 2<sup>s</sup> steps ahead.
	 *
	 * @param s the 2<sup>s</sup> steps to jump ahead.
	 * @throws IllegalArgumentException if {@code s < 0}.
	 */
	@Override
	public void jumpPowerOfTwo(final int s) {
		if (s < 0) {
			throw new IllegalArgumentException(format(
				"s must be positive but was %d.", s
			));
		}

		if (s >= Long.SIZE) {
			throw new IllegalArgumentException(format(
				"The 'jump2' size must be smaller than %d but was %d.",
				Long.SIZE, s
			));
		}

		state.r = state.r *IntMath.pow(param.a, 1L << s) +
					f(1L << s, param.a)* param.b;
	}

	@Override
	public void jump(final double step) {
		if (step < 0) {
			throw new IllegalArgumentException(format(
				"step must be positive but was %d", step
			));
		}

		if (step < 16) {
			for (int i = 0; i < step; ++i) {
				step();
			}
		} else {
			long s = Math.round(step);
			int i = 0;
			while (s > 0) {
				if (s%2 == 1) {
					jumpPowerOfTwo(i);
				}
				++i;
				s >>= 1;
			}
		}
	}

	private void backward() {
		for (int i = 0; i < Long.SIZE; ++i) {
			jumpPowerOfTwo(i);
		}
	}

	@Override
	public double jumpDistance() {
		return 1 << 20;
	}

	@Override
	public double leapDistance() {
		return 1L << 40;
	}

	@Override
	public LCG64ShiftRandom copy() {
		return new LCG64ShiftRandom(param, state);
	}

	/**
	 * Return the parameters for {@code this} random generator.
	 *
	 * @return the parameters for {@code this} random generator
	 */
	public Param param() {
		return param;
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


	/* *************************************************************************
	 * Some static helper methods
	 ***************************************************************************/

	/**
	 * Compute prod(1+a^(2^i), i=0..l-1).
	 */
	private static long g(final int l, final long a) {
		long p = a;
		long res = 1;
		for (int i = 0; i < l; ++i) {
			res *= 1 + p;
			p *= p;
		}

		return res;
	}

	/**
	 * Compute sum(a^i, i=0..s-1).
	 */
	private static long f(final long s, final long a) {
		long y = 0;

		if (s != 0) {
			long e = log2Floor(s);
			long p = a;

			for (int l = 0; l <= e; ++l) {
				if (((1L << l) & s) != 0) {
					y = g(l, a) + p*y;
				}
				p *= p;
			}
		}

		return y;
	}

}

/*
#=============================================================================#
# Testing: org.jenetics.random.LCG64ShiftRandom (2016-09-29 23:17)            #
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
stdin_input_raw|  4.87e+07  |2860611910|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.93948674|  PASSED
      diehard_operm5|   0|   1000000|     100|0.41718130|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.82362883|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.93736677|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.37166295|  PASSED
        diehard_opso|   0|   2097152|     100|0.99044594|  PASSED
        diehard_oqso|   0|   2097152|     100|0.93344874|  PASSED
         diehard_dna|   0|   2097152|     100|0.47254070|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.46327590|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.47819901|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.30305851|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.99637344|   WEAK
    diehard_3dsphere|   3|      4000|     100|0.14298519|  PASSED
     diehard_squeeze|   0|    100000|     100|0.91539126|  PASSED
        diehard_sums|   0|       100|     100|0.28099208|  PASSED
        diehard_runs|   0|    100000|     100|0.05113419|  PASSED
        diehard_runs|   0|    100000|     100|0.12435607|  PASSED
       diehard_craps|   0|    200000|     100|0.32967882|  PASSED
       diehard_craps|   0|    200000|     100|0.99758109|   WEAK
 marsaglia_tsang_gcd|   0|  10000000|     100|0.72187004|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.27385062|  PASSED
         sts_monobit|   1|    100000|     100|0.54796795|  PASSED
            sts_runs|   2|    100000|     100|0.61565412|  PASSED
          sts_serial|   1|    100000|     100|0.83681474|  PASSED
          sts_serial|   2|    100000|     100|0.95462176|  PASSED
          sts_serial|   3|    100000|     100|0.86888598|  PASSED
          sts_serial|   3|    100000|     100|0.20041922|  PASSED
          sts_serial|   4|    100000|     100|0.16759929|  PASSED
          sts_serial|   4|    100000|     100|0.22057463|  PASSED
          sts_serial|   5|    100000|     100|0.07197275|  PASSED
          sts_serial|   5|    100000|     100|0.67452252|  PASSED
          sts_serial|   6|    100000|     100|0.16350724|  PASSED
          sts_serial|   6|    100000|     100|0.26609519|  PASSED
          sts_serial|   7|    100000|     100|0.53541464|  PASSED
          sts_serial|   7|    100000|     100|0.67809716|  PASSED
          sts_serial|   8|    100000|     100|0.10456303|  PASSED
          sts_serial|   8|    100000|     100|0.03314409|  PASSED
          sts_serial|   9|    100000|     100|0.71981605|  PASSED
          sts_serial|   9|    100000|     100|0.36932626|  PASSED
          sts_serial|  10|    100000|     100|0.52610127|  PASSED
          sts_serial|  10|    100000|     100|0.43168931|  PASSED
          sts_serial|  11|    100000|     100|0.68342054|  PASSED
          sts_serial|  11|    100000|     100|0.84941060|  PASSED
          sts_serial|  12|    100000|     100|0.39924170|  PASSED
          sts_serial|  12|    100000|     100|0.50188109|  PASSED
          sts_serial|  13|    100000|     100|0.58559940|  PASSED
          sts_serial|  13|    100000|     100|0.99721116|   WEAK
          sts_serial|  14|    100000|     100|0.13375150|  PASSED
          sts_serial|  14|    100000|     100|0.25762610|  PASSED
          sts_serial|  15|    100000|     100|0.43499723|  PASSED
          sts_serial|  15|    100000|     100|0.50519428|  PASSED
          sts_serial|  16|    100000|     100|0.76394759|  PASSED
          sts_serial|  16|    100000|     100|0.49269857|  PASSED
         rgb_bitdist|   1|    100000|     100|0.08406606|  PASSED
         rgb_bitdist|   2|    100000|     100|0.02321297|  PASSED
         rgb_bitdist|   3|    100000|     100|0.94495709|  PASSED
         rgb_bitdist|   4|    100000|     100|0.60204842|  PASSED
         rgb_bitdist|   5|    100000|     100|0.95754833|  PASSED
         rgb_bitdist|   6|    100000|     100|0.71711263|  PASSED
         rgb_bitdist|   7|    100000|     100|0.55483624|  PASSED
         rgb_bitdist|   8|    100000|     100|0.97556643|  PASSED
         rgb_bitdist|   9|    100000|     100|0.45217161|  PASSED
         rgb_bitdist|  10|    100000|     100|0.78482749|  PASSED
         rgb_bitdist|  11|    100000|     100|0.52983264|  PASSED
         rgb_bitdist|  12|    100000|     100|0.86045095|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.09996568|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.18815626|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.94143483|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.38347776|  PASSED
    rgb_permutations|   2|    100000|     100|0.31756071|  PASSED
    rgb_permutations|   3|    100000|     100|0.83271033|  PASSED
    rgb_permutations|   4|    100000|     100|0.00108378|   WEAK
    rgb_permutations|   5|    100000|     100|0.35438600|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.24006888|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.22817846|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.87767765|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.34166564|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.52394734|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.73223501|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.26657917|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.56441049|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.26532297|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.99800248|   WEAK
      rgb_lagged_sum|  10|   1000000|     100|0.64792592|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.98414511|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.41152466|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.88595971|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.69813447|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.71919855|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.86478205|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.65315584|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.98237763|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.42941752|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.89240030|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.22684952|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.08681878|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.84683827|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.33488855|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.62081325|  PASSED
      rgb_lagged_sum|  26|   1000000|     100|0.93315457|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.98180986|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.30865968|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.88913225|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.27065720|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.47413844|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.15827029|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.10735958|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.32388688|  PASSED
             dab_dct| 256|     50000|       1|0.50467027|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.57781812|  PASSED
        dab_filltree|  32|  15000000|       1|0.21640899|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.45014020|  PASSED
       dab_filltree2|   1|   5000000|       1|0.83540421|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.90672841|  PASSED
#=============================================================================#
# Summary: PASSED=109, WEAK=5, FAILED=0                                       #
#          235,031.406 MB of random data created with 122.000 MB/sec          #
#=============================================================================#
#=============================================================================#
# Runtime: 0:32:06                                                            #
#=============================================================================#
*/
