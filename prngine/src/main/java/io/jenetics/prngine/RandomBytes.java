package io.jenetics.prngine;

import static java.lang.Math.min;

import java.util.Random;

public abstract class RandomBytes extends PRNG {

	private static final long serialVersionUID = 1L;

	protected RandomBytes(final long seed) {
		super(seed);
	}

	protected RandomBytes() {
		this(PRNG.seed());
	}

	/**
	 * Force to explicitly override the {@link Random#nextBytes(byte[])} method. All other
	 * methods of this class are implemented by calling this method.
	 */
	@Override
	public abstract void nextBytes(final byte[] bytes);

	/**
	 * Force to explicitly override the Random.nextLong() method. All other
	 * methods of this class are implemented by calling this method.
	 */
	@Override
	public abstract long nextLong();

	@Override
	public boolean nextBoolean() {
		return (nextLong() & 0x8000000000000000L) != 0L;
	}

	@Override
	public int nextInt() {
		return (int)(nextLong() >>> Integer.SIZE);
	}

	@Override
	protected int next(final int bits) {
		return (int)(nextLong() >>> (Long.SIZE - bits));
	}

	@Override
	public float nextFloat() {
		return PRNG.toFloat2(nextLong());
	}

	/**
	 * Optimized version of the {@link Random#nextDouble()} method for 64-bit
	 * random engines.
	 */
	@Override
	public double nextDouble() {
		return PRNG.toDouble2(nextLong());
	}

}
