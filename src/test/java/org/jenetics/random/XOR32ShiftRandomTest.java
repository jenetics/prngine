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

import org.testng.annotations.DataProvider;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public class XOR32ShiftRandomTest extends RandomTestBase {

	@Override @DataProvider(name = "seededPRNGPair")
	protected Object[][] getSeededPRNGPair() {
		final long seed = math.seed();
		return new Object[][]{
			{new XOR32ShiftRandom(seed), new XOR32ShiftRandom(seed)},
			{new XOR32ShiftRandom.ThreadSafe(seed), new XOR32ShiftRandom.ThreadSafe(seed)}
		};
	}

	@Override @DataProvider(name = "PRNG")
	protected Object[][] getPRNG() {
		final long seed = math.seed();
		return new Object[][]{
			{new XOR32ShiftRandom(seed)},
			{new XOR32ShiftRandom.ThreadSafe(seed)},
			{new XOR32ShiftRandom.ThreadLocal().get()}
		};
	}

}
