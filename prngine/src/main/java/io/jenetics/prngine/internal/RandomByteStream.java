package io.jenetics.prngine.internal;

import java.io.IOException;

/**
 * java -cp prngine/build/libs/prngine-2.0.0-SNAPSHOT.jar \
 *     io.jenetics.prngine.internal.RandomByteStream | ./RNG_test stdin
 */
public class RandomByteStream {
	public static void main(String[] args) throws IOException {
		final var random = new SeedRandom();
		for (;;) {
			byte[] num = new byte[4096];
			random.nextBytes(num);
			System.out.write(num);
		}
	}
}
