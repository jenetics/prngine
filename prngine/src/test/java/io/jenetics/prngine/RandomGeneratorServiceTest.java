package io.jenetics.prngine;

import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RandomGeneratorServiceTest {

	@Test(dataProvider = "names")
	public void creation(final String name) {
		final var random = RandomGenerator.of(name);
		Assert.assertNotNull(random);

		final var factory = RandomGeneratorFactory.of(name);
		Assert.assertNotNull(factory);

		final var random2 = factory.create();
		Assert.assertEquals(random2.getClass(), random.getClass());

		final var random3 = factory.create(System.currentTimeMillis());
		Assert.assertEquals(random3.getClass(), random.getClass());

		final var seed = new byte[10_000];
		random.nextBytes(seed);
		final var random4 = factory.create(seed);
		Assert.assertEquals(random4.getClass(), random.getClass());
	}

	@DataProvider
	public Object[][] names() {
		return new Object[][] {
			{"KISS32Random"},
			{"KISS64Random"},
			{"LCG64ShiftRandom"},
			{"MT19937_32Random"},
			{"MT19937_64Random"},
			{"XOR32ShiftRandom"},
			{"XOR64ShiftRandom"}
		};
	}

}
