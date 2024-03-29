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

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 */
public class BytesTest {

	@Test
	public void readInt() {
		for (int i = 1; i < 100; ++i) {
			final byte[] data = new byte[i*4];

			final Random random = new Random(i);
			for (int j = 0; j < i; ++j) {
				System.arraycopy(Bytes.toBytes(random.nextInt()), 0, data, j*4, 4);
			}

			random.setSeed(i);
			for (int j = 0; j < i; ++j) {
				Assert.assertEquals(Bytes.readInt(data, j), random.nextInt());
			}
		}
	}

	@Test
	public void readLong() {
		for (int i = 1; i < 100; ++i) {
			final byte[] data = new byte[i*8];

			final Random random = new Random(i);
			for (int j = 0; j < i; ++j) {
				System.arraycopy(Bytes.toBytes(random.nextLong()), 0, data, j*8, 8);
			}

			random.setSeed(i);
			for (int j = 0; j < i; ++j) {
				Assert.assertEquals(Bytes.readLong(data, j), random.nextLong());
			}
		}
	}

}
