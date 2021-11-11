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

import java.util.random.RandomGenerator;

import io.jenetics.prngine.KISS32Random;
import io.jenetics.prngine.KISS64Random;
import io.jenetics.prngine.LCG64ShiftRandom;
import io.jenetics.prngine.MT19937_32Random;
import io.jenetics.prngine.MT19937_64Random;
import io.jenetics.prngine.XOR32ShiftRandom;
import io.jenetics.prngine.XOR64ShiftRandom;

/**
 * <b>PRNGine</b> is a pseudo-random number generator library for sequential and
 * parallel <a href="https://de.wikipedia.org/wiki/Monte-Carlo-Simulation">
 * Monte Carlo simulations</a>. All PRNG implementations of this library
 * extends the Java {@link RandomGenerator}, which makes it easily usable in
 * other projects. <em>The PRNGs are <b>not</b> cryptographically strong RNGs.</em>
 * <p>
 * <b>The following PRNGs are implemented</b>
 * </p>
 * <ul>
 *     <li>{@link KISS32Random}: Implementation of a simple PRNG as proposed in
 *     <a href="http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf">
 *     	    Good Practice in (Pseudo) Random Number Generation for Bioinformatics
 *     	    Applications</a> (JKISS32, page 3), <em>David Jones</em>, UCL
 *     	    Bioinformatics Group.
 *     </li>
 *     <li>{@link KISS64Random}: Implementation of a simple PRNG as proposed in
 *     <a href="http://www0.cs.ucl.ac.uk/staff/d.jones/GoodPracticeRNG.pdf">
 *  		Good Practice in (Pseudo) Random Number Generation for Bioinformatics
 *  		Applications</a> (JKISS32, page 10), <em>David Jones</em>, UCL
 *  		Bioinformatics Group.
 *     </li>
 *     <li>{@link LCG64ShiftRandom}: This class implements a linear congruential
 *     PRNG with additional bit-shift transition. It is a port of the
 *     <a href="https://github.com/rabauke/trng4/blob/master/trng/lcg64_shift.hpp">
 *         trng::lcg64_shift</a> PRNG class of the <a href="https://www.numbercrunch.de/trng/">
 *             TRNG</a> library created by Heiko Bauke.</li>
 *     <li>{@link MT19937_32Random}: This is a 32-bit version of Mersenne Twister
 *     pseudorandom number generator.</li>
 *     <li>{@link MT19937_64Random}: This is a 64-bit version of Mersenne Twister
 *     pseudorandom number generator.</li>
 *     <li>{@link XOR32ShiftRandom}:  This generator was discovered and
 *     characterized by George Marsaglia [<a href="http://www.jstatsoft.org/v08/i14/paper">Xorshift RNGs</a>]
 *     In just three XORs and three shifts (generally fast operations) it
 *     produces a full period of 2<sup>32</sup> - 1 on 32 bits. (The missing
 *     value is zero, which perpetuates itself and must be avoided.) High and
 *     low bits pass Diehard.
 *     </li>
 *     <li>{@link XOR64ShiftRandom}:  This generator was discovered and
 *     characterized by George Marsaglia [<a href="http://www.jstatsoft.org/v08/i14/paper">Xorshift RNGs</a>]
 *     In just three XORs and three shifts (generally fast operations) it
 *     produces a full period of 2<sup>4</sup> - 1 on 64 bits. (The missing
 *     value is zero, which perpetuates itself and must be avoided.) High and
 *     low bits pass Diehard.
 *     </li>
 * </ul>
 *
 * <b>PRNG creation</b>
 * <pre>{@code
 * final var random1 = new LCG64ShiftRandom();
 * final RandomGenerator random2 = RandomGenerator.of("LCG64ShiftRandom");
 * final RandomGenerator random3 = RandomGeneratorFactory.of("LCG64ShiftRandom").create();
 * }</pre>
 *
 * <b>PRNG seeding</b>
 * <pre>{@code
 * // This random creation is equivalent to...
 * final RandomGenerator random1 = new LCG64ShiftRandom();
 *
 * // ...creating it with the seed bytes of the PRNG.
 * final byte[] seed = LCG64ShiftRandom.seedBytes();
 * final RandomGenerator random2 = new LCG53ShiftRandom(seed);
 * }</pre>
 *
 * <b>NOTE: </b><em>All implemented random generators are not thread-safe. If
 * they are used in a multi-threaded environment, they must be synchronized
 * externally.</em>
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 2.0.0
 */
module io.jenetics.prngine {
	exports io.jenetics.prngine;

	provides RandomGenerator with
		KISS32Random,
		KISS64Random,
		LCG64ShiftRandom,
		MT19937_32Random,
		MT19937_64Random,
		XOR32ShiftRandom,
		XOR64ShiftRandom;
}