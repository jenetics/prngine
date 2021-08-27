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

import static java.lang.Math.min;
import static io.jenetics.prngine.utils.toBytes;

/**
 * Abstract {@code Random} class with additional <i>next</i> random number
 * methods. It also contains static helper methods for creating sane random
 * seed values ({@link #seed()}) and creating random values within a given
 * range.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 1.0
 * @version !__version__!
 */
public abstract class PRNGSupport {
	private PRNGSupport() {
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
	 * @see #expandSeedToBytes(long, int)
	 *
	 * @param seed the seed value
	 * @param seedBytes the resulting seeding byte array to fill
	 * @return the given byte array, for method chaining.
	 * @throws NullPointerException if the {@code seedBytes} array is
	 *         {@code null}.
	 */
	public static byte[] expandSeedToBytes(final long seed, final byte[] seedBytes) {
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
	 * @see #expandSeedToBytes(long, byte[])
	 *
	 * @param seed the seed value
	 * @param length the length of the new seed byte array
	 * @return a new seed byte array filled with the given seed value
	 * @throws NegativeArraySizeException if the given {@code length} is smaller
	 *         than zero
	 */
	public static byte[] expandSeedToBytes(final long seed, final int length) {
		return expandSeedToBytes(seed, new byte[length]);
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
		final long a = mixStafford13(System.currentTimeMillis());
		final long b = mixStafford13(System.nanoTime());
		return seed(mix(a, b));
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

	private static long mixStafford13(long z) {
		z = (z ^ (z >>> 30)) * 0xbf58476d1ce4e5b9L;
		z = (z ^ (z >>> 27)) * 0x94d049bb133111ebL;
		return z ^ (z >>> 31);
	}

	private static long objectHashSeed() {
		return mixStafford13(
			(long)new Object().hashCode() << 32 |
				new Object().hashCode()
		);
	}

}
