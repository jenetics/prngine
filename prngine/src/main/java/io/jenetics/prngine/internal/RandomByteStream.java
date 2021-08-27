package io.jenetics.prngine.internal;

import java.io.IOException;

import io.jenetics.prngine.KISS32Random;

public class RandomByteStream {
	public static void main(String[] args) throws IOException {
		final var random = new KISS32Random();
		for (;;) {
			byte[] num = new byte[4096];
			random.nextBytes(num);
			System.out.write(num);
		}
	}
}
