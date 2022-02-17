package io.jenetics.prngine.objective;

import java.util.random.RandomGenerator;

@FunctionalInterface
public interface Randomizer<T> {

	T next(final RandomGenerator random);

}
