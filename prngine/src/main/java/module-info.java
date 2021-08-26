import java.util.random.RandomGenerator;

import io.jenetics.prngine.KISS32Random;
import io.jenetics.prngine.KISS64Random;
import io.jenetics.prngine.LCG64ShiftRandom;
import io.jenetics.prngine.MT19937_32Random;
import io.jenetics.prngine.MT19937_64Random;
import io.jenetics.prngine.XOR32ShiftRandom;
import io.jenetics.prngine.XOR64ShiftRandom;

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