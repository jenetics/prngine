import java.util.random.RandomGenerator;

import io.jenetics.prngine.KISS32Random;

module io.jenetics.prngine {
	exports io.jenetics.prngine;

	provides RandomGenerator with KISS32Random;
}