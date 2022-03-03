package io.jenetics.prngine.objective;

import java.util.List;

public interface DataTypeMirror {

	List<DataTypeMirror> implementations();

	List<Property> properties();

}
