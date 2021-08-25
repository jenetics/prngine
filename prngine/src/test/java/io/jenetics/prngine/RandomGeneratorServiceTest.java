package io.jenetics.prngine;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

public class RandomGeneratorServiceTest {

	public static void main(final String[] args) {
		RandomGeneratorFactory.all().forEach(f -> {
			final var r = f.create();
			System.out.println(r);
		});

		final var random = RandomGenerator.of("KISS64Random");
		System.out.println();
		System.out.println(random);

		final var rf = RandomGeneratorFactory.of("KISS64Random");
		System.out.println();
		//System.out.println(rf + ":" + rf.stateBits());
		System.out.println(rf.create(12));
		System.out.println(rf.create(new byte[]{1, 2}));
	}

}
