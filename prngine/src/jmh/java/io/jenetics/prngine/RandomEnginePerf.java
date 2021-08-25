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

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

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
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz  Wilhelmstötter</a>
 * @version 1.0
 * @since 1.0
 */
public class RandomEnginePerf {

	@State(Scope.Benchmark)
	@BenchmarkMode(Mode.Throughput)
	@OutputTimeUnit(TimeUnit.MICROSECONDS)
	public static class Base {

		public RandomGenerator random;

		@Benchmark
		public int nextInt() {
			return random.nextInt();
		}

		@Benchmark
		public int nextIntRange() {
			return random.nextInt(Integer.MAX_VALUE/2);
		}

		@Benchmark
		public int nextIntRangeOriginBound() {
			return PRNG.nextInt(
				Integer.MAX_VALUE/10,
				Integer.MAX_VALUE/2,
				random
			);
		}

		@Benchmark
		public long nextLong() {
			return random.nextLong();
		}

		@Benchmark
		public long nextLongRange() {
			return PRNG.nextLong(Long.MAX_VALUE/2, random);
		}

		@Benchmark
		public long nextLongRangeOriginBound() {
			return PRNG.nextLong(
				Long.MAX_VALUE/10,
				Long.MAX_VALUE/2,
				random
			);
		}

		@Benchmark
		public float nextFloat() {
			return random.nextFloat();
		}

		@Benchmark
		public float nextFloatRange() {
			return PRNG.nextFloat(
				Float.MAX_VALUE/10,
				Float.MAX_VALUE/2,
				random
			);
		}

		@Benchmark
		public double nextDouble() {
			return random.nextDouble();
		}

		@Benchmark
		public double nextDoubleRange() {
			return PRNG.nextDouble(
				Double.MAX_VALUE/10,
				Double.MAX_VALUE/2,
				random
			);
		}
	}

	public static class KISS32RandomPerf extends Base {{
		random = new KISS32Random();
	}}

	public static class KISS64RandomPerf extends Base {{
		random = new KISS64Random();
	}}

	public static class LCG64ShiftRandomPerf extends Base {{
		random = new LCG64ShiftRandom();
	}}

	public static class MT19937_32RandomPerf extends Base {{
		random = new MT19937_32Random();
	}}

	public static class MT19937_64RandomPerf extends Base {{
		random = new MT19937_64Random();
	}}

	public static class XOR32ShiftRandomPerf extends Base {{
		random = new XOR32ShiftRandom();
	}}

	public static class XOR64ShiftRandomPerf extends Base {{
		random = new XOR64ShiftRandom();
	}}

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

	public static class RandomPerf extends Base {{
		random = new Random();
	}}

	public static class ThreadLocalRandomPerf extends Base {{
		random = ThreadLocalRandom.current();
	}}

	public static void main(String[] args) throws RunnerException {
		final Options opt = new OptionsBuilder()
			.include(".*" + RandomEnginePerf.class.getSimpleName() + ".*")
			.warmupIterations(15)
			.measurementIterations(30)
			.threads(1)
			.forks(1)
			.build();

		new Runner(opt).run();
	}


}

/*
Result: 93.621 ±(99.9%) 0.786 ops/us [Average]
  Statistics: (min, avg, max) = (91.236, 93.621, 95.813), stdev = 1.176
  Confidence interval (99.9%): [92.835, 94.407]


# Run complete. Total time: 01:39:52

Benchmark                                                                 Mode  Samples    Score    Error   Units
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextDouble                       thrpt       30  108.980 ±  0.952  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextDoubleRange                  thrpt       30   82.745 ±  0.553  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextFloat                        thrpt       30  143.543 ±  1.249  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextFloatRange                   thrpt       30  131.575 ±  1.230  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextInt                          thrpt       30  189.185 ±  0.953  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextIntRange                     thrpt       30  140.279 ±  1.062  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextIntRangeOriginBound          thrpt       30   86.235 ±  0.958  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextLong                         thrpt       30  129.601 ±  1.000  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextLongRange                    thrpt       30   98.970 ±  0.880  ops/us
i.j.p.RandomEnginePerf.KISS32RandomPerf.nextLongRangeOriginBound         thrpt       30   65.443 ±  0.533  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextDouble                       thrpt       30  124.977 ±  0.912  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextDoubleRange                  thrpt       30  106.565 ±  0.810  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextFloat                        thrpt       30  124.570 ±  1.088  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextFloatRange                   thrpt       30  109.127 ±  0.818  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextInt                          thrpt       30  128.290 ±  0.860  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextIntRange                     thrpt       30  112.656 ±  1.290  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextIntRangeOriginBound          thrpt       30   71.065 ±  0.464  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextLong                         thrpt       30  115.579 ±  2.724  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextLongRange                    thrpt       30  112.886 ±  0.770  ops/us
i.j.p.RandomEnginePerf.KISS64RandomPerf.nextLongRangeOriginBound         thrpt       30   71.897 ±  0.636  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextDouble                   thrpt       30  191.542 ±  1.804  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextDoubleRange              thrpt       30  149.449 ±  1.647  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextFloat                    thrpt       30  185.905 ±  1.835  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextFloatRange               thrpt       30  151.814 ±  1.132  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextInt                      thrpt       30  258.176 ±  2.336  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextIntRange                 thrpt       30  165.544 ±  1.125  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextIntRangeOriginBound      thrpt       30   93.036 ±  0.821  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextLong                     thrpt       30  261.378 ±  1.793  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextLongRange                thrpt       30  171.629 ±  1.426  ops/us
i.j.p.RandomEnginePerf.LCG64ShiftRandomPerf.nextLongRangeOriginBound     thrpt       30   95.318 ±  0.828  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextDouble                   thrpt       30   82.108 ±  0.937  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextDoubleRange              thrpt       30   73.231 ±  0.518  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextFloat                    thrpt       30  115.502 ±  0.955  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextFloatRange               thrpt       30  101.599 ±  0.967  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextInt                      thrpt       30  139.905 ±  1.456  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextIntRange                 thrpt       30   74.943 ±  0.969  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextIntRangeOriginBound      thrpt       30   46.537 ±  0.666  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextLong                     thrpt       30   92.482 ±  0.775  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextLongRange                thrpt       30   43.989 ±  0.398  ops/us
i.j.p.RandomEnginePerf.MT19937_32RandomPerf.nextLongRangeOriginBound     thrpt       30   51.871 ±  0.598  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextDouble                   thrpt       30  120.021 ±  1.162  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextDoubleRange              thrpt       30  109.709 ±  1.036  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextFloat                    thrpt       30  120.003 ±  1.050  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextFloatRange               thrpt       30  106.882 ±  0.905  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextInt                      thrpt       30  148.063 ±  2.281  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextIntRange                 thrpt       30  110.096 ±  0.974  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextIntRangeOriginBound      thrpt       30   48.837 ±  0.451  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextLong                     thrpt       30  148.754 ±  1.912  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextLongRange                thrpt       30  113.181 ±  0.849  ops/us
i.j.p.RandomEnginePerf.MT19937_64RandomPerf.nextLongRangeOriginBound     thrpt       30   33.221 ±  0.257  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextDouble                             thrpt       30   45.940 ±  0.302  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextDoubleRange                        thrpt       30   45.943 ±  0.323  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextFloat                              thrpt       30   89.979 ±  0.578  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextFloatRange                         thrpt       30   89.148 ±  0.742  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextInt                                thrpt       30   91.534 ±  0.661  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextIntRange                           thrpt       30   91.308 ±  0.634  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextIntRangeOriginBound                thrpt       30   67.470 ±  0.457  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextLong                               thrpt       30   45.943 ±  0.419  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextLongRange                          thrpt       30   45.798 ±  0.338  ops/us
i.j.p.RandomEnginePerf.RandomPerf.nextLongRangeOriginBound               thrpt       30   35.013 ±  0.235  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextDouble                     thrpt       30  242.038 ±  2.067  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextDoubleRange                thrpt       30  181.977 ±  1.444  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextFloat                      thrpt       30  291.308 ±  2.507  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextFloatRange                 thrpt       30  199.341 ±  2.204  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextInt                        thrpt       30  385.895 ±  4.669  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextIntRange                   thrpt       30  147.417 ± 13.065  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextIntRangeOriginBound        thrpt       30  254.544 ± 35.546  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextLong                       thrpt       30  341.733 ±  3.556  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextLongRange                  thrpt       30  211.438 ±  2.030  ops/us
i.j.p.RandomEnginePerf.SimpleRandom32Perf.nextLongRangeOriginBound       thrpt       30  192.143 ± 27.292  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextDouble                     thrpt       30  289.913 ±  2.796  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextDoubleRange                thrpt       30  199.822 ±  1.608  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextFloat                      thrpt       30  294.616 ±  3.889  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextFloatRange                 thrpt       30  198.561 ±  1.888  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextInt                        thrpt       30  379.173 ±  3.450  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextIntRange                   thrpt       30  243.228 ±  2.536  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextIntRangeOriginBound        thrpt       30  235.848 ±  2.416  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextLong                       thrpt       30  382.261 ±  4.154  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextLongRange                  thrpt       30  243.553 ±  2.730  ops/us
i.j.p.RandomEnginePerf.SimpleRandom64Perf.nextLongRangeOriginBound       thrpt       30  242.283 ±  2.770  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextDouble                  thrpt       30  216.874 ±  2.710  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextDoubleRange             thrpt       30  177.427 ±  1.706  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextFloat                   thrpt       30  224.512 ±  1.823  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextFloatRange              thrpt       30  178.026 ±  1.553  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextInt                     thrpt       30  264.788 ±  4.002  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextIntRange                thrpt       30  219.853 ±  1.976  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextIntRangeOriginBound     thrpt       30  110.796 ±  0.992  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextLong                    thrpt       30  268.130 ±  1.724  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextLongRange               thrpt       30  185.155 ±  9.011  ops/us
i.j.p.RandomEnginePerf.ThreadLocalRandomPerf.nextLongRangeOriginBound    thrpt       30  106.594 ±  0.689  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextDouble                   thrpt       30  120.950 ±  0.741  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextDoubleRange              thrpt       30   98.611 ±  1.152  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextFloat                    thrpt       30  161.981 ±  1.891  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextFloatRange               thrpt       30  145.842 ±  1.494  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextInt                      thrpt       30  227.096 ±  2.598  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextIntRange                 thrpt       30  155.976 ±  1.480  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextIntRangeOriginBound      thrpt       30   93.288 ±  0.997  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextLong                     thrpt       30  140.663 ±  1.423  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextLongRange                thrpt       30  110.254 ±  0.927  ops/us
i.j.p.RandomEnginePerf.XOR32ShiftRandomPerf.nextLongRangeOriginBound     thrpt       30   72.120 ±  0.703  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextDouble                   thrpt       30  166.923 ±  1.558  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextDoubleRange              thrpt       30  144.352 ±  1.614  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextFloat                    thrpt       30  166.756 ±  1.408  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextFloatRange               thrpt       30  149.360 ±  1.613  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextInt                      thrpt       30  225.211 ±  1.581  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextIntRange                 thrpt       30  157.666 ±  1.115  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextIntRangeOriginBound      thrpt       30   90.737 ±  0.573  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextLong                     thrpt       30  235.305 ±  1.428  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextLongRange                thrpt       30  156.713 ±  1.301  ops/us
i.j.p.RandomEnginePerf.XOR64ShiftRandomPerf.nextLongRangeOriginBound     thrpt       30   93.621 ±  0.786  ops/us
*/
