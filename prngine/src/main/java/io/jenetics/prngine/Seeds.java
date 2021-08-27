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

import java.util.random.RandomGenerator;

/**
 * Abstract {@code Random} class with additional <i>next</i> random number
 * methods. It also contains static helper methods for creating sane random
 * seed values ({@link #seed()}) and creating random values within a given
 * range.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__!
 */
public abstract class Seeds {

	private static final class ObjectSeedSource {
		static long seed() {
			final long a = new ObjectSeedSource().hashCode();
			final long b = new ObjectSeedSource().hashCode();
			return mixStafford13(a << 32 | b);
		}
	}

	private Seeds() {
	}

	/**
	 * Returns a {@code long} value (chosen from some machine-dependent entropy
	 * source) that may be useful for initializing a source of seed values for
	 * instances of {@link RandomGenerator} created by zero-argument
	 * constructors.
	 *
	 * @return the random seed value.
	 */
	public static long seed() {
		final long a = mixStafford13(System.currentTimeMillis());
		final long b = mixStafford13(System.nanoTime());
		return seed(mix(a, b));
	}

	private static long seed(final long base) {
		return mix(base, ObjectSeedSource.seed());
	}

	private static long mix(final long a, final long b) {
		long c = a^b;
		c ^= c << 17;
		c ^= c >>> 31;
		c ^= c << 8;
		return c;
	}

	private static long mixStafford13(final long z) {
		long v = (z^(z >>> 30))*0xbf58476d1ce4e5b9L;
		v = (v^(v >>> 27))*0x94d049bb133111ebL;
		return v^(v >>> 31);
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
	 * Fills the given {@code seedBytes} with the given {@code seed} value. If
	 * the {@code length} is bigger than 8, the {@code seed} value is
	 * <em>stretched</em> for filling the returned seed array. This method is
	 * deterministic and doesn't increase the entropy of the input {@code seed}.
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



}
