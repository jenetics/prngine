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
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//import org.jenetics.util.TestData;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version <em>$Date: 2014-12-29 $</em>
 */
public class MT19937_32RandomCompatibilityTest {

	private final static String TEST_RESOURCE =
		"/org/jenetix/random/MT19937_32Random/%d";

//	@Test(dataProvider = "seeds")
//	public void constructorSeed(final long seed) {
//		final Random random = new MT19937_32Random(seed);
//
//		final String resource = String.format(TEST_RESOURCE, seed);
//		for (final String[] value : TestData.of(resource)) {
//			final int expected = Integer.parseInt(value[0]);
//			Assert.assertEquals(random.nextInt(), expected);
//		}
//	}
//
//	@Test(dataProvider = "seeds")
//	public void setSeedSeed(final long seed) {
//		final Random random = new MT19937_32Random(1234);
//		random.setSeed(seed);
//
//		final String resource = String.format(TEST_RESOURCE, seed);
//		for (final String[] value : TestData.of(resource)) {
//			final int expected = Integer.parseInt(value[0]);
//			Assert.assertEquals(random.nextInt(), expected);
//		}
//	}
//
//	@DataProvider(name = "seeds")
//	public Object[][] seeds() {
//		return LongStream.range(0, 100)
//			.mapToObj(i -> new Long[]{i*32344})
//			.collect(Collectors.toList())
//			.toArray(new Object[0][]);
//	}

}
