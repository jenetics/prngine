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

import java.text.NumberFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__!
 */
public class RandomPerformanceTests {


	public static void main(final String[] args) {
		final int loops = 500_000_000;

		test(new Random(), loops);
		test(ThreadLocalRandom.current(), loops);
		test(new XORShiftRandom(), loops);
	}

	private static void test(final Random random, final int loops) {
		System.out.println(String.format(
			"%-20s %-10s; %-10s; %-10s; %-10s",
			random.getClass().getSimpleName() + ":",
			testNextInt(random, loops),
			testNextLong(random, loops),
			testNextFloat(random, loops),
			testNextDouble(random, loops)
		));
	}

	private static String testNextInt(final Random random, final long loops) {
		long start = System.nanoTime();
		for (long i = 0; i < loops; ++i) {
			random.nextInt();
		}
		long end = System.nanoTime();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s i/sec", format.format(perSec(loops, start, end)));
	}

	private static String testNextLong(final Random random, final long loops) {
		long start = System.nanoTime();
		for (long i = 0; i < loops; ++i) {
			random.nextLong();
		}
		long end = System.nanoTime();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s l/sec", format.format(perSec(loops, start, end)));
	}

	private static String testNextFloat(final Random random, final long loops) {
		long start = System.nanoTime();
		for (long i = 0; i < loops; ++i) {
			random.nextFloat();
		}
		long end = System.nanoTime();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s f/sec", format.format(perSec(loops, start, end)));
	}

	private static String testNextDouble(final Random random, final long loops) {
		long start = System.nanoTime();
		for (long i = 0; i < loops; ++i) {
			random.nextDouble();
		}
		long end = System.nanoTime();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s d/sec", format.format(perSec(loops, start, end)));
	}

	private static long perSec(final long loops, final long start, final long end) {
		final double seconds = (end - start)/1_000_000_000.0;
		return (long)(loops/seconds);
	}

}
