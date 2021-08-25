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

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 */
public class MT19937_32RandomTest extends Random32TestBase {

	@Test
	public void create() {
		new MT19937_32Random();
	}

	@Test
	public void createThreadSafe() {
		new MT19937_32Random.ThreadSafe();
	}

	@Test
	public void createThreadLocal() {
		new MT19937_32Random.ThreadLocal().get();
	}

	//@Override
	@DataProvider(name = "seededPRNGPair")
	protected Object[][] seededPRNGPair() {
		final byte[] seed = MT19937_32Random.seedBytes();

		return new Object[][] {
			{new MT19937_32Random(seed), new MT19937_32Random(seed)},
			{new MT19937_32Random.ThreadSafe(seed), new MT19937_32Random(seed)},
			{new MT19937_32Random.ThreadSafe(seed), new MT19937_32Random.ThreadSafe(seed)}
		};
	}

	@Override
	@DataProvider(name = "PRNG")
	protected Object[][] getPRNG() {
		final byte[] seed = MT19937_32Random.seedBytes();

		return new Object[][] {
			{new MT19937_32Random(seed)},
			{new MT19937_32Random.ThreadSafe(seed)},
			{new MT19937_32Random.ThreadLocal().get()}
		};
	}
}
