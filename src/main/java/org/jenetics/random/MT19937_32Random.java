/*
 * Java Genetic Algorithm Library (@__identifier__@).
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
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.random;

import static org.jenetics.random.internal.util.Equality.eq;

import java.io.Serializable;

import org.jenetics.random.internal.util.Equality;
import org.jenetics.random.internal.util.Hash;

/**
 * This is a 32-bit version of Mersenne Twister pseudorandom number generator.
 * <p>
 * <i>
 * References:<br>
 * M. Matsumoto and T. Nishimura,<br>
 * "Mersenne Twister: a 623-dimensionally equidistributed<br>
 * uniform pseudorandom number generator"<br>
 * ACM Transactions on Modeling and<br>
 * Computer Simulation 8. (Jan. 1998) 3--30.<br>
 * </i>
 * <p>
 * <em>
 * This is an re-implementation of the
 * <a href="https://github.com/rabauke/trng4/blob/master/src/mt19937.hpp">
 * trng::mt19937</a> PRNG class of the
 * <a href="http://numbercrunch.de/trng/">TRNG</a> library created by Heiko
 * Bauke.</em>
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__! &mdash; <em>$Date: 2014-12-29 $</em>
 */
public class MT19937_32Random extends Random32 {

	private static final long serialVersionUID = 1L;

	private static final int N = 624;
	private static final int M = 397;

	private static final int UM = 0x80000000; // most significant bit
	private static final int LM = 0x7FFFFFFF; // least significant 31 bits

	/**
	 * This class represents a <i>thread local</i> implementation of the
	 * {@code MT19937_32Random} PRNG.
	 *
	 * It's recommended to initialize the {@code RandomRegistry} the following
	 * way:
	 *
	 * [code]
	 * // Register the PRNG with the default parameters.
	 * RandomRegistry.setRandom(new MT19937_32Random.ThreadLocal());
	 * [/code]
	 *
	 * Be aware, that calls of the {@code setSeed(long)} method will throw an
	 * {@code UnsupportedOperationException} for <i>thread local</i> instances.
	 * [code]
	 * RandomRegistry.setRandom(new MT19937_32Random.ThreadLocal());
	 *
	 * // Will throw 'UnsupportedOperationException'.
	 * RandomRegistry.getRandom().setSeed(1234);
	 * [/code]
	 *
	 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
	 * @since !__version__!
	 * @version !__version__! &mdash; <em>$Date: 2014-12-29 $</em>
	 */
	public static class ThreadLocal
		extends java.lang.ThreadLocal<MT19937_32Random>
	{
		@Override
		protected synchronized MT19937_32Random initialValue() {
			return new TLMT19937_32Random(math.seed());
		}
	}

	private static final class TLMT19937_32Random extends MT19937_32Random {
		private static final long serialVersionUID = 1L;

		private final Boolean _sentry = Boolean.TRUE;

		private TLMT19937_32Random(final long seed) {
			super(seed);
		}

		@Override
		public void setSeed(final long seed) {
			if (_sentry != null) {
				throw new UnsupportedOperationException(
					"The 'setSeed(long)' method is not supported " +
						"for thread local instances."
				);
			}
		}

	}

	/**
	 * This is a <i>thread safe</i> variation of the this PRGN&mdash;by
	 * synchronizing the random number generation.
	 *
	 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
	 * @since !__version__!
	 * @version !__version__! &mdash; <em>$Date: 2014-12-29 $</em>
	 */
	public static class ThreadSafe extends MT19937_32Random {
		private static final long serialVersionUID = 1L;

		public ThreadSafe(final long seed) {
			super(seed);
		}

		public ThreadSafe() {
			super();
		}

		@Override
		public synchronized int nextInt() {
			return super.nextInt();
		}

		@Override
		public synchronized void setSeed(final long seed) {
			super.setSeed(seed);
		}
	}

	/**
	 * The internal state of this random engine.
	 */
	private static final class State implements Serializable {
		private static final long serialVersionUID = 1L;

		int mti = 0;
		int[] mt = new int[N];

		State(final long seed) {
			setSeed(seed);
		}

		void setSeed(final long seed) {
			mt[0] = (int)seed;
			for (mti = 1; mti < N; ++mti) {
				mt[mti] = (1812433253*(mt[mti - 1]^(mt[mti - 1] >>> 30)) + mti);
			}
		}

		@Override
		public int hashCode() {
			return Hash.of(getClass())
				.and(mti)
				.and(mt).value();
		}

		@Override
		public boolean equals(final Object obj) {
			return Equality.of(this, obj).test(status ->
				eq(mti, status.mti) &&
				eq(mt, status.mt)
			);
		}
	}

	private final State _state;

	/**
	 * Create a new random engine with the given seed.
	 *
	 * @param seed the seed of the random engine
	 */
	public MT19937_32Random(final long seed) {
		_state = new State(seed);
	}

	/**
	 * Return a new random engine with a safe seed value.
	 */
	public MT19937_32Random() {
		this(math.seed());
	}

	@Override
	public int nextInt() {
		int x;
		final int[] mag01 = {0, 0x9908b0df};

		// Generate N words at one time.
		if (_state.mti >= N) {
			int i = 0;
			for (i = 0; i < N - M; ++i) {
				x = (_state.mt[i] & UM) | (_state.mt[i + 1] & LM);
				_state.mt[i] = _state.mt[i + M]^(x >>> 1)^mag01[x & 1];
			}
			for (; i < N - 1; ++i) {
				x = (_state.mt[i] & UM) | (_state.mt[i + 1] & LM);
				_state.mt[i] = _state.mt[i + (M - N)]^(x >>> 1)^mag01[x & 1];
			}

			x = (_state.mt[N - 1] & UM)|(_state.mt[0] & LM);
			_state.mt[N - 1] = _state.mt[M - 1]^(x >>> 1)^mag01[x & 1];
			_state.mti = 0;
		}

		x = _state.mt[_state.mti++];
		x ^= (x >>> 11);
		x ^= (x << 7) & 0x9d2c5680;
		x ^= (x << 15) & 0xefc60000;
		x ^= (x >>> 18);

		return x;
	}

	@Override
	public void setSeed(final long seed) {
		if (_state != null) _state.setSeed(seed);
	}

	@Override
	public int hashCode() {
		return Hash.of(getClass()).and(_state).value();
	}

	@Override
	public boolean equals(final Object obj) {
		return Equality.of(this, obj).test(random -> eq(_state, random._state));
	}

}

/*
#=============================================================================#
# Testing: org.jenetix.random.MT19937_32Random (2014-07-28 04:32)             #
#=============================================================================#
#=============================================================================#
# Linux 3.13.0-32-generic (amd64)                                             #
# java version "1.8.0_11"                                                     #
# Java(TM) SE Runtime Environment (build 1.8.0_11-b12)                        #
# Java HotSpot(TM) 64-Bit Server VM (build 25.11-b03)                         #
#=============================================================================#
#=============================================================================#
#            dieharder version 3.31.1 Copyright 2003 Robert G. Brown          #
#=============================================================================#
   rng_name    |rands/second|   Seed   |
stdin_input_raw|  2.61e+07  |3963544050|
#=============================================================================#
        test_name   |ntup| tsamples |psamples|  p-value |Assessment
#=============================================================================#
   diehard_birthdays|   0|       100|     100|0.84201435|  PASSED
      diehard_operm5|   0|   1000000|     100|0.51745697|  PASSED
  diehard_rank_32x32|   0|     40000|     100|0.94039216|  PASSED
    diehard_rank_6x8|   0|    100000|     100|0.85053059|  PASSED
   diehard_bitstream|   0|   2097152|     100|0.94556717|  PASSED
        diehard_opso|   0|   2097152|     100|0.93734115|  PASSED
        diehard_oqso|   0|   2097152|     100|0.04315045|  PASSED
         diehard_dna|   0|   2097152|     100|0.29754447|  PASSED
diehard_count_1s_str|   0|    256000|     100|0.31793581|  PASSED
diehard_count_1s_byt|   0|    256000|     100|0.50327043|  PASSED
 diehard_parking_lot|   0|     12000|     100|0.16579004|  PASSED
    diehard_2dsphere|   2|      8000|     100|0.81126761|  PASSED
    diehard_3dsphere|   3|      4000|     100|0.65742196|  PASSED
     diehard_squeeze|   0|    100000|     100|0.93430921|  PASSED
        diehard_sums|   0|       100|     100|0.31953917|  PASSED
        diehard_runs|   0|    100000|     100|0.14704930|  PASSED
        diehard_runs|   0|    100000|     100|0.23182662|  PASSED
       diehard_craps|   0|    200000|     100|0.15465180|  PASSED
       diehard_craps|   0|    200000|     100|0.63545903|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.85260818|  PASSED
 marsaglia_tsang_gcd|   0|  10000000|     100|0.95452135|  PASSED
         sts_monobit|   1|    100000|     100|0.78175053|  PASSED
            sts_runs|   2|    100000|     100|0.98821656|  PASSED
          sts_serial|   1|    100000|     100|0.80401696|  PASSED
          sts_serial|   2|    100000|     100|0.66957861|  PASSED
          sts_serial|   3|    100000|     100|0.40346216|  PASSED
          sts_serial|   3|    100000|     100|0.40869087|  PASSED
          sts_serial|   4|    100000|     100|0.02873039|  PASSED
          sts_serial|   4|    100000|     100|0.11106837|  PASSED
          sts_serial|   5|    100000|     100|0.44215295|  PASSED
          sts_serial|   5|    100000|     100|0.67954971|  PASSED
          sts_serial|   6|    100000|     100|0.15184780|  PASSED
          sts_serial|   6|    100000|     100|0.17994287|  PASSED
          sts_serial|   7|    100000|     100|0.12527495|  PASSED
          sts_serial|   7|    100000|     100|0.64612178|  PASSED
          sts_serial|   8|    100000|     100|0.44301286|  PASSED
          sts_serial|   8|    100000|     100|0.03089712|  PASSED
          sts_serial|   9|    100000|     100|0.21747539|  PASSED
          sts_serial|   9|    100000|     100|0.85573938|  PASSED
          sts_serial|  10|    100000|     100|0.56098061|  PASSED
          sts_serial|  10|    100000|     100|0.72106127|  PASSED
          sts_serial|  11|    100000|     100|0.95460974|  PASSED
          sts_serial|  11|    100000|     100|0.36562087|  PASSED
          sts_serial|  12|    100000|     100|0.79536981|  PASSED
          sts_serial|  12|    100000|     100|0.62640941|  PASSED
          sts_serial|  13|    100000|     100|0.47363135|  PASSED
          sts_serial|  13|    100000|     100|0.78078312|  PASSED
          sts_serial|  14|    100000|     100|0.13487877|  PASSED
          sts_serial|  14|    100000|     100|0.79202246|  PASSED
          sts_serial|  15|    100000|     100|0.86134855|  PASSED
          sts_serial|  15|    100000|     100|0.13025356|  PASSED
          sts_serial|  16|    100000|     100|0.99834508|   WEAK
          sts_serial|  16|    100000|     100|0.96747954|  PASSED
         rgb_bitdist|   1|    100000|     100|0.91326346|  PASSED
         rgb_bitdist|   2|    100000|     100|0.99454805|  PASSED
         rgb_bitdist|   3|    100000|     100|0.20189430|  PASSED
         rgb_bitdist|   4|    100000|     100|0.85276744|  PASSED
         rgb_bitdist|   5|    100000|     100|0.67503768|  PASSED
         rgb_bitdist|   6|    100000|     100|0.29182726|  PASSED
         rgb_bitdist|   7|    100000|     100|0.88875729|  PASSED
         rgb_bitdist|   8|    100000|     100|0.77440564|  PASSED
         rgb_bitdist|   9|    100000|     100|0.52803756|  PASSED
         rgb_bitdist|  10|    100000|     100|0.02903749|  PASSED
         rgb_bitdist|  11|    100000|     100|0.36231046|  PASSED
         rgb_bitdist|  12|    100000|     100|0.52974673|  PASSED
rgb_minimum_distance|   2|     10000|    1000|0.64799713|  PASSED
rgb_minimum_distance|   3|     10000|    1000|0.07452077|  PASSED
rgb_minimum_distance|   4|     10000|    1000|0.27640111|  PASSED
rgb_minimum_distance|   5|     10000|    1000|0.01879431|  PASSED
    rgb_permutations|   2|    100000|     100|0.85562915|  PASSED
    rgb_permutations|   3|    100000|     100|0.78778699|  PASSED
    rgb_permutations|   4|    100000|     100|0.43294819|  PASSED
    rgb_permutations|   5|    100000|     100|0.99413557|  PASSED
      rgb_lagged_sum|   0|   1000000|     100|0.29044084|  PASSED
      rgb_lagged_sum|   1|   1000000|     100|0.15339864|  PASSED
      rgb_lagged_sum|   2|   1000000|     100|0.01384291|  PASSED
      rgb_lagged_sum|   3|   1000000|     100|0.72004075|  PASSED
      rgb_lagged_sum|   4|   1000000|     100|0.43786334|  PASSED
      rgb_lagged_sum|   5|   1000000|     100|0.89514084|  PASSED
      rgb_lagged_sum|   6|   1000000|     100|0.40013187|  PASSED
      rgb_lagged_sum|   7|   1000000|     100|0.08237175|  PASSED
      rgb_lagged_sum|   8|   1000000|     100|0.29359611|  PASSED
      rgb_lagged_sum|   9|   1000000|     100|0.57903166|  PASSED
      rgb_lagged_sum|  10|   1000000|     100|0.71583987|  PASSED
      rgb_lagged_sum|  11|   1000000|     100|0.94239065|  PASSED
      rgb_lagged_sum|  12|   1000000|     100|0.35785422|  PASSED
      rgb_lagged_sum|  13|   1000000|     100|0.31976331|  PASSED
      rgb_lagged_sum|  14|   1000000|     100|0.54860609|  PASSED
      rgb_lagged_sum|  15|   1000000|     100|0.20599041|  PASSED
      rgb_lagged_sum|  16|   1000000|     100|0.26335106|  PASSED
      rgb_lagged_sum|  17|   1000000|     100|0.80047368|  PASSED
      rgb_lagged_sum|  18|   1000000|     100|0.37075523|  PASSED
      rgb_lagged_sum|  19|   1000000|     100|0.87757358|  PASSED
      rgb_lagged_sum|  20|   1000000|     100|0.89604898|  PASSED
      rgb_lagged_sum|  21|   1000000|     100|0.27495941|  PASSED
      rgb_lagged_sum|  22|   1000000|     100|0.82973431|  PASSED
      rgb_lagged_sum|  23|   1000000|     100|0.93849397|  PASSED
      rgb_lagged_sum|  24|   1000000|     100|0.95147375|  PASSED
      rgb_lagged_sum|  25|   1000000|     100|0.99940168|   WEAK
      rgb_lagged_sum|  26|   1000000|     100|0.27979568|  PASSED
      rgb_lagged_sum|  27|   1000000|     100|0.92152621|  PASSED
      rgb_lagged_sum|  28|   1000000|     100|0.63444086|  PASSED
      rgb_lagged_sum|  29|   1000000|     100|0.72110224|  PASSED
      rgb_lagged_sum|  30|   1000000|     100|0.25857145|  PASSED
      rgb_lagged_sum|  31|   1000000|     100|0.81542766|  PASSED
      rgb_lagged_sum|  32|   1000000|     100|0.32023174|  PASSED
     rgb_kstest_test|   0|     10000|    1000|0.74940978|  PASSED
     dab_bytedistrib|   0|  51200000|       1|0.20960784|  PASSED
             dab_dct| 256|     50000|       1|0.55779709|  PASSED
Preparing to run test 207.  ntuple = 0
        dab_filltree|  32|  15000000|       1|0.16954481|  PASSED
        dab_filltree|  32|  15000000|       1|0.01837060|  PASSED
Preparing to run test 208.  ntuple = 0
       dab_filltree2|   0|   5000000|       1|0.33270946|  PASSED
       dab_filltree2|   1|   5000000|       1|0.56177333|  PASSED
Preparing to run test 209.  ntuple = 0
        dab_monobit2|  12|  65000000|       1|0.22932926|  PASSED
#=============================================================================#
# Summary: PASSED=112, WEAK=2, FAILED=0                                       #
#          235,031.242 MB of random data created with 101.030 MB/sec          #
#=============================================================================#
#=============================================================================#
# Runtime: 0:38:46                                                            #
#=============================================================================#
*/

