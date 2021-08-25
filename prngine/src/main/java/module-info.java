import java.util.random.RandomGenerator;

import io.jenetics.prngine.KISS64Random;

module io.jenetics.prngine {
	exports io.jenetics.prngine;

	provides RandomGenerator with KISS64Random;
}