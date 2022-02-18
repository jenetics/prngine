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

import java.util.concurrent.TimeUnit;
import java.util.random.RandomGenerator;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz  Wilhelmstötter</a>
 * @version 2.0
 * @since 1.0
 */
@Fork(value = 1, warmups = 3)
@Warmup(iterations = 3)
@BenchmarkMode(Mode.Throughput)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
public class RandomEnginePerf {

	@State(Scope.Benchmark)
	public static class BenchmarkState {

		@Param({
			"KISS32Random",
			"KISS64Random",
			"LCG64ShiftRandom",
			"MT19937_32Random",
			"MT19937_64Random",
			"XOR32ShiftRandom",
			"XOR64ShiftRandom",
			"L64X256MixRandom"
		})
		public String name;

		public RandomGenerator random;

		@Setup(Level.Trial)
		public void setUp() {
			random = RandomGenerator.of(name);
		}

	}

	@Benchmark
	public int nextInt(final BenchmarkState state) {
		return state.random.nextInt();
	}

	@Benchmark
	public int nextIntRange(final BenchmarkState state) {
		return state.random.nextInt(Integer.MAX_VALUE/2);
	}

	@Benchmark
	public int nextIntRangeOriginBound(final BenchmarkState state) {
		return state.random.nextInt(Integer.MAX_VALUE/10, Integer.MAX_VALUE/2);
	}

	@Benchmark
	public long nextLong(final BenchmarkState state) {
		return state.random.nextLong();
	}

	@Benchmark
	public long nextLongRange(final BenchmarkState state) {
		return state.random.nextLong(Long.MAX_VALUE/2);
	}

	@Benchmark
	public long nextLongRangeOriginBound(final BenchmarkState state) {
		return state.random.nextLong(Long.MAX_VALUE/10, Long.MAX_VALUE/2);
	}

	@Benchmark
	public float nextFloat(final BenchmarkState state) {
		return state.random.nextFloat();
	}

	@Benchmark
	public float nextFloatRange(final BenchmarkState state) {
		return state.random.nextFloat(Float.MAX_VALUE/10, Float.MAX_VALUE/2);
	}

	@Benchmark
	public double nextDouble(final BenchmarkState state) {
		return state.random.nextDouble();
	}

	@Benchmark
	public double nextDoubleRange(final BenchmarkState state) {
		return state.random.nextDouble(Double.MAX_VALUE/10, Double.MAX_VALUE/2);
	}


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
# 18.02.2022
# Run complete. Total time: 07:07:52

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                            (name)   Mode  Cnt    Score   Error   Units
RandomEnginePerf.nextDouble                    KISS32Random  thrpt    5  107.810 ± 1.011  ops/us
RandomEnginePerf.nextDouble                    KISS64Random  thrpt    5  118.855 ± 0.738  ops/us
RandomEnginePerf.nextDouble                LCG64ShiftRandom  thrpt    5  185.832 ± 2.250  ops/us
RandomEnginePerf.nextDouble                MT19937_32Random  thrpt    5   82.944 ± 0.492  ops/us
RandomEnginePerf.nextDouble                MT19937_64Random  thrpt    5  118.778 ± 0.967  ops/us
RandomEnginePerf.nextDouble                XOR32ShiftRandom  thrpt    5  116.759 ± 1.763  ops/us
RandomEnginePerf.nextDouble                XOR64ShiftRandom  thrpt    5  161.614 ± 1.422  ops/us
RandomEnginePerf.nextDouble                L64X256MixRandom  thrpt    5  142.088 ± 5.123  ops/us
RandomEnginePerf.nextDoubleRange               KISS32Random  thrpt    5   85.193 ± 1.636  ops/us
RandomEnginePerf.nextDoubleRange               KISS64Random  thrpt    5  102.741 ± 2.415  ops/us
RandomEnginePerf.nextDoubleRange           LCG64ShiftRandom  thrpt    5  149.922 ± 2.543  ops/us
RandomEnginePerf.nextDoubleRange           MT19937_32Random  thrpt    5   68.689 ± 0.653  ops/us
RandomEnginePerf.nextDoubleRange           MT19937_64Random  thrpt    5  112.990 ± 2.277  ops/us
RandomEnginePerf.nextDoubleRange           XOR32ShiftRandom  thrpt    5   98.601 ± 1.300  ops/us
RandomEnginePerf.nextDoubleRange           XOR64ShiftRandom  thrpt    5  147.273 ± 2.067  ops/us
RandomEnginePerf.nextDoubleRange           L64X256MixRandom  thrpt    5  128.304 ± 0.513  ops/us
RandomEnginePerf.nextFloat                     KISS32Random  thrpt    5  141.915 ± 1.528  ops/us
RandomEnginePerf.nextFloat                     KISS64Random  thrpt    5  116.767 ± 1.472  ops/us
RandomEnginePerf.nextFloat                 LCG64ShiftRandom  thrpt    5  168.775 ± 0.947  ops/us
RandomEnginePerf.nextFloat                 MT19937_32Random  thrpt    5  127.777 ± 0.298  ops/us
RandomEnginePerf.nextFloat                 MT19937_64Random  thrpt    5  120.071 ± 1.411  ops/us
RandomEnginePerf.nextFloat                 XOR32ShiftRandom  thrpt    5  160.533 ± 1.568  ops/us
RandomEnginePerf.nextFloat                 XOR64ShiftRandom  thrpt    5  156.456 ± 4.971  ops/us
RandomEnginePerf.nextFloat                 L64X256MixRandom  thrpt    5  136.481 ± 1.805  ops/us
RandomEnginePerf.nextFloatRange                KISS32Random  thrpt    5  127.456 ± 1.202  ops/us
RandomEnginePerf.nextFloatRange                KISS64Random  thrpt    5  101.647 ± 1.310  ops/us
RandomEnginePerf.nextFloatRange            LCG64ShiftRandom  thrpt    5  139.638 ± 1.942  ops/us
RandomEnginePerf.nextFloatRange            MT19937_32Random  thrpt    5  113.059 ± 1.191  ops/us
RandomEnginePerf.nextFloatRange            MT19937_64Random  thrpt    5  107.812 ± 1.011  ops/us
RandomEnginePerf.nextFloatRange            XOR32ShiftRandom  thrpt    5  144.330 ± 2.306  ops/us
RandomEnginePerf.nextFloatRange            XOR64ShiftRandom  thrpt    5  143.415 ± 1.038  ops/us
RandomEnginePerf.nextFloatRange            L64X256MixRandom  thrpt    5  121.806 ± 1.628  ops/us
RandomEnginePerf.nextInt                       KISS32Random  thrpt    5  169.538 ± 1.751  ops/us
RandomEnginePerf.nextInt                       KISS64Random  thrpt    5  128.948 ± 2.466  ops/us
RandomEnginePerf.nextInt                   LCG64ShiftRandom  thrpt    5  234.304 ± 2.190  ops/us
RandomEnginePerf.nextInt                   MT19937_32Random  thrpt    5  164.359 ± 1.749  ops/us
RandomEnginePerf.nextInt                   MT19937_64Random  thrpt    5  147.191 ± 1.947  ops/us
RandomEnginePerf.nextInt                   XOR32ShiftRandom  thrpt    5  206.866 ± 6.698  ops/us
RandomEnginePerf.nextInt                   XOR64ShiftRandom  thrpt    5  189.013 ± 1.452  ops/us
RandomEnginePerf.nextInt                   L64X256MixRandom  thrpt    5  162.190 ± 3.239  ops/us
RandomEnginePerf.nextIntRange                  KISS32Random  thrpt    5  134.528 ± 1.255  ops/us
RandomEnginePerf.nextIntRange                  KISS64Random  thrpt    5  108.802 ± 1.320  ops/us
RandomEnginePerf.nextIntRange              LCG64ShiftRandom  thrpt    5  147.772 ± 1.314  ops/us
RandomEnginePerf.nextIntRange              MT19937_32Random  thrpt    5  114.181 ± 0.664  ops/us
RandomEnginePerf.nextIntRange              MT19937_64Random  thrpt    5  109.633 ± 1.543  ops/us
RandomEnginePerf.nextIntRange              XOR32ShiftRandom  thrpt    5  148.291 ± 1.760  ops/us
RandomEnginePerf.nextIntRange              XOR64ShiftRandom  thrpt    5  133.048 ± 1.569  ops/us
RandomEnginePerf.nextIntRange              L64X256MixRandom  thrpt    5  125.118 ± 0.873  ops/us
RandomEnginePerf.nextIntRangeOriginBound       KISS32Random  thrpt    5   86.209 ± 1.229  ops/us
RandomEnginePerf.nextIntRangeOriginBound       KISS64Random  thrpt    5   67.116 ± 0.811  ops/us
RandomEnginePerf.nextIntRangeOriginBound   LCG64ShiftRandom  thrpt    5   87.564 ± 1.440  ops/us
RandomEnginePerf.nextIntRangeOriginBound   MT19937_32Random  thrpt    5   51.792 ± 0.529  ops/us
RandomEnginePerf.nextIntRangeOriginBound   MT19937_64Random  thrpt    5   63.910 ± 2.715  ops/us
RandomEnginePerf.nextIntRangeOriginBound   XOR32ShiftRandom  thrpt    5   90.937 ± 0.800  ops/us
RandomEnginePerf.nextIntRangeOriginBound   XOR64ShiftRandom  thrpt    5   90.119 ± 1.121  ops/us
RandomEnginePerf.nextIntRangeOriginBound   L64X256MixRandom  thrpt    5   75.187 ± 0.646  ops/us
RandomEnginePerf.nextLong                      KISS32Random  thrpt    5  124.859 ± 0.738  ops/us
RandomEnginePerf.nextLong                      KISS64Random  thrpt    5  131.932 ± 1.541  ops/us
RandomEnginePerf.nextLong                  LCG64ShiftRandom  thrpt    5  244.672 ± 2.164  ops/us
RandomEnginePerf.nextLong                  MT19937_32Random  thrpt    5   92.299 ± 0.681  ops/us
RandomEnginePerf.nextLong                  MT19937_64Random  thrpt    5  148.415 ± 1.300  ops/us
RandomEnginePerf.nextLong                  XOR32ShiftRandom  thrpt    5  135.271 ± 1.325  ops/us
RandomEnginePerf.nextLong                  XOR64ShiftRandom  thrpt    5  207.799 ± 2.774  ops/us
RandomEnginePerf.nextLong                  L64X256MixRandom  thrpt    5  166.659 ± 1.161  ops/us
RandomEnginePerf.nextLongRange                 KISS32Random  thrpt    5   98.124 ± 0.642  ops/us
RandomEnginePerf.nextLongRange                 KISS64Random  thrpt    5  112.333 ± 1.801  ops/us
RandomEnginePerf.nextLongRange             LCG64ShiftRandom  thrpt    5  162.372 ± 3.885  ops/us
RandomEnginePerf.nextLongRange             MT19937_32Random  thrpt    5   44.922 ± 0.659  ops/us
RandomEnginePerf.nextLongRange             MT19937_64Random  thrpt    5  115.043 ± 1.585  ops/us
RandomEnginePerf.nextLongRange             XOR32ShiftRandom  thrpt    5  108.893 ± 0.982  ops/us
RandomEnginePerf.nextLongRange             XOR64ShiftRandom  thrpt    5  139.520 ± 2.505  ops/us
RandomEnginePerf.nextLongRange             L64X256MixRandom  thrpt    5  130.932 ± 1.497  ops/us
RandomEnginePerf.nextLongRangeOriginBound      KISS32Random  thrpt    5   64.092 ± 0.502  ops/us
RandomEnginePerf.nextLongRangeOriginBound      KISS64Random  thrpt    5   71.070 ± 0.514  ops/us
RandomEnginePerf.nextLongRangeOriginBound  LCG64ShiftRandom  thrpt    5   89.863 ± 1.342  ops/us
RandomEnginePerf.nextLongRangeOriginBound  MT19937_32Random  thrpt    5   30.742 ± 0.318  ops/us
RandomEnginePerf.nextLongRangeOriginBound  MT19937_64Random  thrpt    5   33.834 ± 0.239  ops/us
RandomEnginePerf.nextLongRangeOriginBound  XOR32ShiftRandom  thrpt    5   67.081 ± 0.757  ops/us
RandomEnginePerf.nextLongRangeOriginBound  XOR64ShiftRandom  thrpt    5   88.871 ± 1.010  ops/us
RandomEnginePerf.nextLongRangeOriginBound  L64X256MixRandom  thrpt    5   76.897 ± 2.615  ops/us
 */

/*
# Run complete. Total time: 13:55:10

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                                                              Mode  Cnt    Score    Error   Units
RandomEnginePerf.DefaultRandomGeneratorPerf.nextDouble                thrpt   25   97.360 ±  0.463  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextDoubleRange           thrpt   25   89.932 ±  0.154  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextFloat                 thrpt   25  160.578 ±  0.439  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextFloatRange            thrpt   25  135.929 ±  0.334  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextInt                   thrpt   25  190.206 ±  0.250  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextIntRange              thrpt   25  144.070 ±  1.348  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextIntRangeOriginBound   thrpt   25   86.885 ±  0.572  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextLong                  thrpt   25  119.714 ±  0.297  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextLongRange             thrpt   25   94.908 ±  0.212  ops/us
RandomEnginePerf.DefaultRandomGeneratorPerf.nextLongRangeOriginBound  thrpt   25   63.190 ±  0.154  ops/us
RandomEnginePerf.JavaRandomPerf.nextDouble                            thrpt   25   47.168 ±  0.077  ops/us
RandomEnginePerf.JavaRandomPerf.nextDoubleRange                       thrpt   25   46.351 ±  0.090  ops/us
RandomEnginePerf.JavaRandomPerf.nextFloat                             thrpt   25   93.864 ±  0.199  ops/us
RandomEnginePerf.JavaRandomPerf.nextFloatRange                        thrpt   25   92.733 ±  0.156  ops/us
RandomEnginePerf.JavaRandomPerf.nextInt                               thrpt   25   94.410 ±  0.210  ops/us
RandomEnginePerf.JavaRandomPerf.nextIntRange                          thrpt   25   92.186 ±  2.473  ops/us
RandomEnginePerf.JavaRandomPerf.nextIntRangeOriginBound               thrpt   25   68.462 ±  0.128  ops/us
RandomEnginePerf.JavaRandomPerf.nextLong                              thrpt   25   47.256 ±  0.072  ops/us
RandomEnginePerf.JavaRandomPerf.nextLongRange                         thrpt   25   47.208 ±  0.082  ops/us
RandomEnginePerf.JavaRandomPerf.nextLongRangeOriginBound              thrpt   25   34.775 ±  0.324  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextDouble                 thrpt   25  142.655 ±  0.281  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextDoubleRange            thrpt   25  124.341 ±  0.162  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextFloat                  thrpt   25  211.338 ±  0.621  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextFloatRange             thrpt   25  163.035 ±  0.289  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextInt                    thrpt   25  253.591 ±  0.549  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextIntRange               thrpt   25  186.080 ±  0.314  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextIntRangeOriginBound    thrpt   25   98.175 ±  0.433  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextLong                   thrpt   25  253.087 ±  0.696  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextLongRange              thrpt   25  164.764 ±  0.394  ops/us
RandomEnginePerf.JavaThreadLocalRandomPerf.nextLongRangeOriginBound   thrpt   25   94.589 ±  0.300  ops/us
RandomEnginePerf.KISS32RandomPerf.nextDouble                          thrpt   25   98.665 ±  0.202  ops/us
RandomEnginePerf.KISS32RandomPerf.nextDoubleRange                     thrpt   25   83.710 ±  0.218  ops/us
RandomEnginePerf.KISS32RandomPerf.nextFloat                           thrpt   25  120.126 ±  0.612  ops/us
RandomEnginePerf.KISS32RandomPerf.nextFloatRange                      thrpt   25  109.802 ±  0.233  ops/us
RandomEnginePerf.KISS32RandomPerf.nextInt                             thrpt   25  148.482 ±  0.542  ops/us
RandomEnginePerf.KISS32RandomPerf.nextIntRange                        thrpt   25  126.518 ±  0.569  ops/us
RandomEnginePerf.KISS32RandomPerf.nextIntRangeOriginBound             thrpt   25   81.452 ±  0.466  ops/us
RandomEnginePerf.KISS32RandomPerf.nextLong                            thrpt   25  109.987 ±  0.187  ops/us
RandomEnginePerf.KISS32RandomPerf.nextLongRange                       thrpt   25   91.283 ±  0.164  ops/us
RandomEnginePerf.KISS32RandomPerf.nextLongRangeOriginBound            thrpt   25   65.615 ±  0.122  ops/us
RandomEnginePerf.KISS64RandomPerf.nextDouble                          thrpt   25  122.836 ±  0.286  ops/us
RandomEnginePerf.KISS64RandomPerf.nextDoubleRange                     thrpt   25  106.883 ±  0.228  ops/us
RandomEnginePerf.KISS64RandomPerf.nextFloat                           thrpt   25  119.527 ±  0.489  ops/us
RandomEnginePerf.KISS64RandomPerf.nextFloatRange                      thrpt   25  104.145 ±  0.583  ops/us
RandomEnginePerf.KISS64RandomPerf.nextInt                             thrpt   25  132.728 ±  0.230  ops/us
RandomEnginePerf.KISS64RandomPerf.nextIntRange                        thrpt   25  112.677 ±  0.144  ops/us
RandomEnginePerf.KISS64RandomPerf.nextIntRangeOriginBound             thrpt   25   69.398 ±  0.146  ops/us
RandomEnginePerf.KISS64RandomPerf.nextLong                            thrpt   25  135.122 ±  0.163  ops/us
RandomEnginePerf.KISS64RandomPerf.nextLongRange                       thrpt   25  116.227 ±  0.249  ops/us
RandomEnginePerf.KISS64RandomPerf.nextLongRangeOriginBound            thrpt   25   71.885 ±  0.193  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextDouble                      thrpt   25  190.805 ±  0.322  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextDoubleRange                 thrpt   25  152.657 ±  0.247  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextFloat                       thrpt   25  174.456 ±  0.606  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextFloatRange                  thrpt   25  150.500 ±  0.170  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextInt                         thrpt   25  240.318 ±  0.502  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextIntRange                    thrpt   25  167.222 ±  0.388  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextIntRangeOriginBound         thrpt   25   93.285 ±  1.071  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextLong                        thrpt   25  250.122 ±  0.628  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextLongRange                   thrpt   25  148.523 ±  0.296  ops/us
RandomEnginePerf.LCG64ShiftRandomPerf.nextLongRangeOriginBound        thrpt   25   91.225 ±  0.250  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextDouble                      thrpt   25   86.248 ±  0.221  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextDoubleRange                 thrpt   25   74.306 ±  0.600  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextFloat                       thrpt   25  131.913 ±  0.727  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextFloatRange                  thrpt   25  114.268 ±  0.222  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextInt                         thrpt   25  168.558 ±  0.347  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextIntRange                    thrpt   25  120.130 ±  0.912  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextIntRangeOriginBound         thrpt   25   62.006 ±  7.089  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextLong                        thrpt   25   97.436 ±  1.738  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextLongRange                   thrpt   25   66.622 ± 12.412  ops/us
RandomEnginePerf.MT19937_32RadnomPerf.nextLongRangeOriginBound        thrpt   25   30.576 ±  0.083  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextDouble                      thrpt   25  124.367 ±  0.164  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextDoubleRange                 thrpt   25  117.178 ±  0.210  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextFloat                       thrpt   25  118.080 ±  1.728  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextFloatRange                  thrpt   25  110.365 ±  0.242  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextInt                         thrpt   25  152.713 ±  0.250  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextIntRange                    thrpt   25  111.553 ±  0.224  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextIntRangeOriginBound         thrpt   25   62.858 ±  4.299  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextLong                        thrpt   25  141.779 ± 15.605  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextLongRange                   thrpt   25  115.722 ±  0.168  ops/us
RandomEnginePerf.MT19937_64RandomPerf.nextLongRangeOriginBound        thrpt   25   68.247 ±  0.786  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextDouble                      thrpt   25  120.176 ±  0.176  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextDoubleRange                 thrpt   25  102.624 ±  0.226  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextFloat                       thrpt   25  165.008 ±  2.746  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextFloatRange                  thrpt   25  151.449 ±  0.293  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextInt                         thrpt   25  220.940 ±  0.538  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextIntRange                    thrpt   25  151.161 ±  1.723  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextIntRangeOriginBound         thrpt   25   93.949 ±  0.469  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextLong                        thrpt   25  140.559 ±  0.258  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextLongRange                   thrpt   25  110.855 ±  0.201  ops/us
RandomEnginePerf.XOR32ShiftRandomPerf.nextLongRangeOriginBound        thrpt   25   68.239 ±  0.319  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextDouble                      thrpt   25  164.714 ±  1.710  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextDoubleRange                 thrpt   25  150.338 ±  1.485  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextFloat                       thrpt   25  163.754 ±  2.070  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextFloatRange                  thrpt   25  145.982 ±  0.632  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextInt                         thrpt   25  193.338 ±  0.278  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextIntRange                    thrpt   25  146.203 ±  1.309  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextIntRangeOriginBound         thrpt   25   89.656 ±  0.931  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextLong                        thrpt   25  217.812 ±  0.716  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextLongRange                   thrpt   25  153.408 ±  0.359  ops/us
RandomEnginePerf.XOR64ShiftRandomPerf.nextLongRangeOriginBound        thrpt   25   88.905 ±  1.318  ops/us
 */

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
