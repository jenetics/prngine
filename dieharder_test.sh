#!/bin/bash

VERSION='2.0.0'

java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder NanoTimeRandom -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder ObjectHashRandom -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder SeedRandom -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder KISS32Random -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder KISS64Random -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder LCG64ShiftRandom -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder MT19937_32Random -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder MT19937_64Random -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder XOR32ShiftRandom -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder XOR64ShiftRandom -a
java -cp prngine/build/libs/prngine-${VERSION}.jar io.jenetics.prngine.internal.DieHarder L64X256MixRandom -a
