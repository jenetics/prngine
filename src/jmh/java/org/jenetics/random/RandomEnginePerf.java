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
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz  Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public class RandomEnginePerf {

	@State(Scope.Benchmark)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public static abstract class Base {

		public Random random;

		@Benchmark
		public int nextInt() {
			return random.nextInt();
		}

		@Benchmark
		public long nextLong() {
			return random.nextLong();
		}

		@Benchmark
		public float nextFloat() {
			return random.nextFloat();
		}

		@Benchmark
		public double nextDouble() {
			return random.nextDouble();
		}

	}

//	public static class LCG64ShiftRandomPerf extends Base {
//		{random = new LCG64ShiftRandom();}
//	}

	/*
	public static class KISSRandomPerf extends Base {
		{random = new KISSRandom();}
	}

	public static class XOR64ShiftRandomPerf extends Base {
		{random = new XOR64ShiftRandom();}
	}
	*/

	public static class SimpleRandom64Perf extends Base {{
		random = new Random64() {
			long _x = 0;
			@Override
			public long nextLong() {
				return ++_x;
			}
		};
	}}

	public static class SimpleRandom32Perf extends Base {{
		random = new Random32() {
			int _x = 0;
			@Override
			public int nextInt() {
				return ++_x;
			}
		};
	}}

	/*
	public static class ThreadLocalRandomPerf extends Base {
		{random = ThreadLocalRandom.current();}
	}
	*/


	public static void main(String[] args) throws RunnerException {
		final Options opt = new OptionsBuilder()
			.include(".*" + RandomEnginePerf.class.getSimpleName() + ".*")
			.warmupIterations(5)
			.measurementIterations(20)
			.threads(1)
			.forks(1)
			.build();

		new Runner(opt).run();
	}


}
