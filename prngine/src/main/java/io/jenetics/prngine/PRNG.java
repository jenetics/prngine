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

import static java.lang.Double.doubleToLongBits;
import static java.lang.Double.longBitsToDouble;
import static java.lang.Float.floatToIntBits;
import static java.lang.Float.intBitsToFloat;
import static java.lang.Math.min;
import static java.lang.String.format;
import static io.jenetics.prngine.utils.toBytes;

import java.io.Serial;
import java.util.Random;
import java.util.random.RandomGenerator;

/**
 * Abstract {@code Random} class with additional <i>next</i> random number
 * methods. It also contains static helper methods for creating sane random
 * seed values ({@link #seed()}) and creating random values within a given
 * range.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version 1.0
 */
public abstract class PRNG implements RandomGenerator {

	@Serial
	private static final long serialVersionUID = 2L;

	/**
	 * Create a new {@code PRNG} instance with the given {@code seed}.
	 *
	 * @param seed the seed of the new {@code PRNG} instance.
	 */
	protected PRNG(final long seed) {
		//super(seed);
	}

	/**
	 * Create a new {@code PRNG} instance with a seed created with the
	 * {@link PRNG#seed()} value.
	 */
	protected PRNG() {
		this(seed());
	}

//	/**
//	 * Returns a pseudo-random, uniformly distributed int value between origin
//	 * (included) and bound (excluded).
//	 *
//	 * @param origin the origin (inclusive) of each random value
//	 * @param bound the bound (exclusive) of each random value
//	 * @return a random integer greater than or equal to {@code min} and
//	 *         less than or equal to {@code max}
//	 * @throws IllegalArgumentException if {@code origin >= bound}
//	 *
//	 * @see PRNG#nextInt(int, int, Random)
//	 */
//	public int nextInt(final int origin, final int bound) {
//		return nextInt(origin, bound, this);
//	}

//	/**
//	 * Returns a pseudo-random, uniformly distributed int value between origin
//	 * (included) and bound (excluded).
//	 *
//	 * @param origin the origin (inclusive) of each random value
//	 * @param bound the bound (exclusive) of each random value
//	 * @return a random long integer greater than or equal to {@code min}
//	 *         and less than or equal to {@code max}
//	 * @throws IllegalArgumentException if {@code origin >= bound}
//	 *
//	 * @see PRNG#nextLong(long, long, Random)
//	 */
//	public long nextLong(final long origin, final long bound) {
//		return nextLong(origin, bound, this);
//	}

//	/**
//	 * Returns a pseudorandom, uniformly distributed int value between 0
//	 * (inclusive) and the specified value (exclusive), drawn from the given
//	 * random number generator's sequence.
//	 *
//	 * @param n the bound on the random number to be returned. Must be
//	 *        positive.
//	 * @return the next pseudorandom, uniformly distributed int value
//	 *         between 0 (inclusive) and n (exclusive) from the given random
//	 *         number generator's sequence
//	 * @throws IllegalArgumentException if n is smaller than 1.
//	 *
//	 * @see PRNG#nextLong(long, Random)
//	 */
//	public long nextLong(final long n) {
//		return nextLong(n, this);
//	}

//	/**
//	 * Returns a pseudorandom, uniformly distributed double value between
//	 * origin (inclusively) and bound (exclusively).
//	 *
//	 * @param origin lower bound for generated float value (inclusively)
//	 * @param bound upper bound for generated float value (exclusively)
//	 * @return a random float greater than or equal to {@code origin} and less
//	 *         than to {@code bound}
//	 * @throws IllegalArgumentException if {@code origin} is greater than or
//	 *         equal to {@code bound}
//	 *
//	 * @see PRNG#nextFloat(float, float, Random)
//	 */
//	public float nextFloat(final float origin, final float bound) {
//		return nextFloat(origin, bound, this);
//	}

//	/**
//	 * Returns a pseudorandom, uniformly distributed double value between
//	 * origin (inclusively) and bound (exclusively).
//	 *
//	 * @param origin lower bound for generated double value (inclusively)
//	 * @param bound upper bound for generated double value (exclusively)
//	 * @return a random double greater than or equal to {@code origin} and less
//	 *         than to {@code bound}
//	 * @throws IllegalArgumentException if {@code origin} is greater than or
//	 *         equal to {@code bound}
//	 *
//	 * @see PRNG#nextDouble(double, double, Random)
//	 */
//	public double nextDouble(final double origin, final double bound) {
//		return nextDouble(origin, bound, this);
//	}


	/* *************************************************************************
	 * Static helper methods.
	 **************************************************************************/

	static float toFloat2(final long a) {
		return (int)(a >>> 41)*0x1.0p-23f;
	}

	static double toDouble2(final long a) {
		return (a & 0xFFFFFFFFFFFFFL)*0x1.0p-52d;
	}

	static double toDouble2(final int a, final int b) {
		return (((long)(a >>> 6) << 26) | (b >>> 6))*0x1.0p-52d;
	}

	/**
	 * Returns a pseudo-random, uniformly distributed int value between origin
	 * (included) and bound (excluded).
	 *
	 * @param origin the origin (inclusive) of each random value
	 * @param bound the bound (exclusive) of each random value
	 * @param random the random engine to use for calculating the random int
	 *        value
	 * @return a random integer greater than or equal to {@code min} and
	 *         less than or equal to {@code max}
	 * @throws IllegalArgumentException if {@code origin >= bound}
	 * @throws NullPointerException if the given {@code random}
	 *         engine is {@code null}.
	 */
	public static int nextInt(
		final int origin, final int bound,
		final RandomGenerator random
	) {
		if (origin >= bound) {
			throw new IllegalArgumentException(format(
				"origin >= bound: %d >= %d", origin, bound
			));
		}

		final int value;
		int n = bound - origin;
		if (n > 0) {
			value = random.nextInt(n) + origin;
		} else {
			int r;
			do {
				r = random.nextInt();
			} while (r < origin || r >= bound);
			value = r;
		}

		return value;
	}

	/**
	 * Returns a pseudo-random, uniformly distributed int value between origin
	 * (included) and bound (excluded).
	 *
	 * @param origin the origin (inclusive) of each random value
	 * @param bound the bound (exclusive) of each random value
	 * @param random the random engine to use for calculating the random
	 *        long value
	 * @return a random long integer greater than or equal to {@code min}
	 *         and less than or equal to {@code max}
	 * @throws IllegalArgumentException if {@code origin >= bound}
	 * @throws NullPointerException if the given {@code random}
	 *         engine is {@code null}.
	 */
	public static long nextLong(
		final long origin, final long bound,
		final RandomGenerator random
	) {
		if (origin >= bound) {
			throw new IllegalArgumentException(format(
				"origin >= bound: %d >= %d.", origin, bound
			));
		}

		long value = random.nextLong();
		long n = bound - origin, m = n - 1;
		if ((n & m) == 0L) {
			value = (value & m) + origin;
		} else if (n > 0L) {
			for (long u = value >>> 1;
				 u + m - (value = u % n) < 0L;
				 u = random.nextLong() >>> 1)
			{
			}

			value += origin;
		} else {
			while (value < origin || value >= bound) {
				value = random.nextLong();
			}
		}

		return value;
	}

	/**
	 * Returns a pseudo-random, uniformly distributed int value between 0
	 * (inclusive) and the specified value (exclusive), drawn from the given
	 * random number generator's sequence.
	 *
	 * @param n the bound on the random number to be returned. Must be
	 *        positive.
	 * @param random the random engine used for creating the random number.
	 * @return the next pseudo-random, uniformly distributed int value
	 *         between 0 (inclusive) and n (exclusive) from the given random
	 *         number generator's sequence
	 * @throws IllegalArgumentException if n is smaller than 1.
	 * @throws NullPointerException if the given {@code random}
	 *         engine is {@code null}.
	 */
	public static long nextLong(final long n, final RandomGenerator random) {
		if (n <= 0) {
			throw new IllegalArgumentException(format(
				"n is smaller than one: %d", n
			));
		}

		long bits;
		long result;
		do {
			bits = random.nextLong() & 0x7fffffffffffffffL;
			result = bits%n;
		} while (bits - result + (n - 1) < 0);

		return result;
	}

	/**
	 * Returns a pseudo-random, uniformly distributed double value between
	 * origin (inclusively) and bound (exclusively).
	 *
	 * @param origin lower bound for generated float value (inclusively)
	 * @param bound upper bound for generated float value (exclusively)
	 * @param random the random engine used for creating the random number.
	 * @return a random float greater than or equal to {@code origin} and less
	 *         than to {@code bound}
	 * @throws IllegalArgumentException if {@code origin} is greater than or
	 *         equal to {@code bound}
	 * @throws NullPointerException if the given {@code random}
	 *         engine is {@code null}.
	 */
	public static float nextFloat(
		final float origin, final float bound,
		final RandomGenerator random
	) {
		if (!(origin < bound)) {
			throw new IllegalArgumentException(format(
				"min >= max: %f >= %f.", origin, bound
			));
		}

		float value = random.nextFloat();
		if (origin < bound) {
			value = value*(bound - origin) + origin;
			if (value >= bound) {
				value = intBitsToFloat(floatToIntBits(bound) - 1);
			}
		}

		return value;
	}

	/**
	 * Returns a pseudo-random, uniformly distributed double value between
	 * origin (inclusively) and bound (exclusively).
	 *
	 * @param origin lower bound for generated double value (inclusively)
	 * @param bound upper bound for generated double value (exclusively)
	 * @param random the random engine used for creating the random number.
	 * @return a random double greater than or equal to {@code min} and less
	 *         than to {@code max}
	 * @throws IllegalArgumentException if {@code origin} is greater than or
	 *         equal to {@code bound}
	 * @throws NullPointerException if the given {@code random}
	 *         engine is {@code null}.
	 */
	public static double nextDouble(
		final double origin, final double bound,
		final RandomGenerator random
	) {
		if (!(origin < bound)) {
			throw new IllegalArgumentException(format(
				"min >= max: %f >= %f.", origin, bound
			));
		}

		double value = random.nextDouble();
		if (origin < bound) {
			value = value*(bound - origin) + origin;
			if (value >= bound) {
				value = longBitsToDouble(doubleToLongBits(bound) - 1);
			}
		}

		return value;
	}

	/**
	 * Create a new <em>seed</em> byte array of the given length.
	 *
	 * @see #seedBytes(byte[])
	 * @see #seed()
	 *
	 * @param length the length of the returned byte array.
	 * @return a new <em>seed</em> byte array of the given length
	 * @throws NegativeArraySizeException if the given length is smaller
	 *         than zero.
	 */
	public static byte[] seedBytes(final int length) {
		return seedBytes(new byte[length]);
	}

	/**
	 * Fills the given byte array with random bytes, created by successive
	 * calls of the {@link #seed()} method. The given {@code seed} array is
	 * filled as follows:
	 * <pre>{@code
	 * for (int i = 0, len = seed.length; i < len;) {
	 *     int n = Math.min(len - i, Long.SIZE/Byte.SIZE);
	 *
	 *     for (long x = seed(); n-- > 0; x >>= Byte.SIZE) {
	 *         seed[i++] = (byte)x;
	 *     }
	 * }
	 * }</pre>
	 *
	 * @see #seed()
	 *
	 * @param seed the byte array seed to fill with random bytes.
	 * @return the given byte array, for method chaining.
	 * @throws NullPointerException if the {@code seed} array is {@code null}.
	 */
	public static byte[] seedBytes(final byte[] seed) {
		for (int i = 0, len = seed.length; i < len;) {
			int n = Math.min(len - i, Long.SIZE/Byte.SIZE);

			for (long x = seed(); n-- > 0; x >>= Byte.SIZE) {
				seed[i++] = (byte)x;
			}
		}

		return seed;
	}

	/**
	 * Fills the given {@code seedBytes} with the given {@code seed} value. If
	 * the {@code length} is bigger than 8, the {@code seed} value is
	 * <em>stretched</em> for filling the returned seed array. This method is
	 * deterministic and doesn't increase the entropy of the input {@code seed}.
	 *
	 * <pre>{@code
	 * long seedValue = seed;
	 * for (int i = 0, len = seedBytes.length; i < len;) {
	 *     int n = min(len - i, Long.SIZE/Byte.SIZE);
	 *
	 *     for (long x = seedValue; n-- > 0; x >>= Byte.SIZE) {
	 *         seedBytes[i++] = (byte)x;
	 *     }
	 *
	 *     seedValue ^= Long.rotateLeft(seedValue, 7);
	 *     seedValue ^= seedValue << 17;
	 *     seedValue ^= seedValue >>> 31;
	 *     seedValue ^= seedValue << 8;
	 * }
	 * }</pre>
	 *
	 * @see #seedBytes(long, int)
	 *
	 * @param seed the seed value
	 * @param seedBytes the resulting seeding byte array to fill
	 * @return the given byte array, for method chaining.
	 * @throws NullPointerException if the {@code seedBytes} array is
	 *         {@code null}.
	 */
	public static byte[] seedBytes(final long seed, final byte[] seedBytes) {
		long seedValue = seed;
		for (int i = 0, len = seedBytes.length; i < len;) {
			final int n = min(len - i, Long.SIZE/Byte.SIZE);
			final byte[] bytes = toBytes(seedValue);

			System.arraycopy(bytes, 0, seedBytes, i, n);
			i += n;

			seedValue ^= Long.rotateLeft(seedValue, 7);
			seedValue ^= seedValue << 17;
			seedValue ^= seedValue >>> 31;
			seedValue ^= seedValue << 8;
		}

		return seedBytes;
	}

	/**
	 * Creates a new {@code byte} array with the given length and fills it with
	 * the given {@code seed} value. If the {@code length} is bigger than 8, the
	 * {@code seed} value is <em>stretched</em> for filling the returned seed
	 * array. This method is deterministic and doesn't increase the entropy of
	 * the input {@code seed}.
	 *
	 * @see #seedBytes(long, byte[])
	 *
	 * @param seed the seed value
	 * @param length the length of the new seed byte array
	 * @return a new seed byte array filled with the given seed value
	 * @throws NegativeArraySizeException if the given {@code length} is smaller
	 *         than zero
	 */
	public static byte[] seedBytes(final long seed, final int length) {
		return seedBytes(seed, new byte[length]);
	}

	/**
	 * Calculating a 64 bit seed value which can be used for initializing
	 * PRNGs. This method uses a combination of {@code System.nanoTime()}
	 * and {@code new Object().hashCode()} calls to create a reasonable safe
	 * seed value:
	 * <pre>{@code
	 * public static long seed() {
	 *     return seed(System.nanoTime());
	 * }
	 * }</pre>
	 * <p>
	 * This method passes all of the statistical tests of the
	 * <a href="http://www.phy.duke.edu/~rgb/General/dieharder.php">
	 * dieharder</a> test suite&mdash;executed on a linux machine with
	 * JDK version 1.7. <em>Since there is no prove that this will the case
	 * for every Java version and OS, it is recommended to only use this
	 * method for seeding other PRNGs.</em>
	 *
	 * @see #seed(long)
	 *
	 * @return the random seed value.
	 */
	public static long seed() {
		return seed(System.nanoTime());
	}

	/**
	 * Uses the given {@code base} value to create a reasonable safe seed
	 * value. This is done by combining it with values of
	 * {@code new Object().hashCode()}:
	 * <pre>{@code
	 * public static long seed(final long base) {
	 *     final long objectHashSeed = ((long)(new Object().hashCode()) << 32) |
	 *                                         new Object().hashCode();
	 *     long seed = base^objectHashSeed;
	 *     seed ^= seed << 17;
	 *     seed ^= seed >>> 31;
	 *     seed ^= seed << 8;
	 *     return seed;
	 * }
	 * }</pre>
	 *
	 * @param base the base value of the seed to create
	 * @return the created seed value.
	 */
	public static long seed(final long base) {
		return mix(base, objectHashSeed());
	}

	private static long mix(final long a, final long b) {
		long c = a^b;
		c ^= c << 17;
		c ^= c >>> 31;
		c ^= c << 8;
		return c;
	}

	private static long objectHashSeed() {
		return (long)new Object().hashCode() << 32 | new Object().hashCode();
	}


}
