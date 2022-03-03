package io.jenetics.prngine.objective;

import org.reflections.Reflections;

import io.jenetics.Gene;

public final class Objective {
	private Objective() {
	}


	public static void main(final String[] args) {
		final var reflections = new Reflections("io");
		reflections.getSubTypesOf(Gene.class).forEach(System.out::println);
	}

}
