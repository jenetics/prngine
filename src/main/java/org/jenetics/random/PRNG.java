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

import java.util.Random;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz  Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__!
 */
abstract class PRNG extends Random {

	private static final long serialVersionUID = 1L;

	/**
	 * Create a new {@code PRNG} instance with the given {@code seed}.
	 *
	 * @param seed the seed of the new {@code PRNG} instance.
	 */
	protected PRNG(final long seed) {
		super(seed);
	}

	/**
	 * Create a new {@code PRNG} instance with a seed created with the
	 */
	protected PRNG() {
		this(math.seed());
	}

	/**
	 * Returns a pseudorandom, uniformly distributed int value between min and
	 * max (end points included).
	 *
	 * @param min lower bound for generated integer (inclusively)
	 * @param max upper bound for generated integer (inclusively)
	 * @return a random integer greater than or equal to {@code min} and less
	 *         than or equal to {@code max}
	 * @throws IllegalArgumentException if {@code min >= max}
	 */
	public int nextInt(final int min, final int max) {
		return math.nextInt(this, min, max);
	}

	/**
	 * Returns a pseudorandom, uniformly distributed int value between min
	 * and max (end points included).
	 *
	 * @param min lower bound for generated long integer (inclusively)
	 * @param max upper bound for generated long integer (inclusively)
	 * @return a random long integer greater than or equal to {@code min}
	 *         and less than or equal to {@code max}
	 * @throws IllegalArgumentException if {@code min >= max}
	 *
	 */
	public long nextLong(final long min, final long max) {
		return math.nextLong(this, min, max);
	}

	/**
	 * Returns a pseudorandom, uniformly distributed int value between 0
	 * (inclusive) and the specified value (exclusive), drawn from the given
	 * random number generator's sequence.
	 *
	 * @param n the bound on the random number to be returned. Must be
	 *        positive.
	 * @return the next pseudorandom, uniformly distributed int value
	 *         between 0 (inclusive) and n (exclusive) from the given random
	 *         number generator's sequence
	 * @throws IllegalArgumentException if n is smaller than 1.
	 */
	public long nextLong(final long n) {
		return math.nextLong(this, n);
	}

	/**
	 * Returns a pseudorandom, uniformly distributed double value between
	 * min (inclusively) and max (exclusively).
	 *
	 * @param min lower bound for generated float value (inclusively)
	 * @param max upper bound for generated float value (exclusively)
	 * @return a random float greater than or equal to {@code min} and less
	 *         than to {@code max}
	 */
	public float nextFloat(final float min, final float max) {
		return math.nextFloat(this, min, max);
	}

	/**
	 * Returns a pseudorandom, uniformly distributed double value between
	 * min (inclusively) and max (exclusively).
	 *
	 * @param min lower bound for generated double value (inclusively)
	 * @param max upper bound for generated double value (exclusively)
	 * @return a random double greater than or equal to {@code min} and less
	 *         than to {@code max}
	 */
	public double nextDouble(final double min, final double max) {
		return math.nextDouble(this, min, max);
	}

}
