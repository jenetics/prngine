package io.jenetics.prngine.objective;

public interface Property {

	DataTypeMirror object();

	String path();

	String name();

	DataMirror type();

}
