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

import java.util.random.RandomGenerator;
import java.util.stream.Stream;

/**
 * Default implementations for most of the <em>split</em> methods.
 *
 * @author <a href="mailto:franz.wilhelmstoetter@gmail.com">Franz Wilhelmstötter</a>
 * @since 2.0
 * @version 2.0
 */
interface SplittableRandom extends RandomGenerator.SplittableGenerator {

	@Override
	default SplittableGenerator split() {
		return split(this);
	}

	@Override
	default Stream<SplittableGenerator> splits(final long streamSize) {
		return Stream.generate(this::split).limit(streamSize);
	}

	@Override
	default Stream<SplittableGenerator> splits(final SplittableGenerator source) {
		return Stream.generate(() -> split(source));
	}

	@Override
	default Stream<SplittableGenerator> splits(
		final long streamSize,
		final SplittableGenerator source
	) {
		return splits(source).limit(streamSize);
	}

}
