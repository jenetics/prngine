#!/usr/bin/env bash

read_link() {
	local path=$1
	if [ -d ${path} ] ; then
		local abspath=$(cd ${path}; pwd)
	else
		local prefix=$(cd $(dirname -- ${path}); pwd)
		local suffix=$(basename ${path})
		local abspath="$prefix/$suffix"
	fi
	echo ${abspath}
}

SCRIPT_DIR=$(CDPATH= cd -- "$(dirname -- "$0")" && pwd)
JRUN=`read_link "${SCRIPT_DIR}/../../../../jrun"`

main() {
	${JRUN} io.jenetics.prngine.internal.DieHarder io.jenetics.prngine.KISS32Random -a
	${JRUN} io.jenetics.prngine.internal.DieHarder io.jenetics.prngine.KISS64Random -a
	${JRUN} io.jenetics.prngine.internal.DieHarder io.jenetics.prngine.LCG64ShiftRandom -a
	${JRUN} io.jenetics.prngine.internal.DieHarder io.jenetics.prngine.MT19937_32Random -a
	${JRUN} io.jenetics.prngine.internal.DieHarder io.jenetics.prngine.MT19937_64Random -a
	${JRUN} io.jenetics.prngine.internal.DieHarder io.jenetics.prngine.XOR32ShiftRandom -a
	${JRUN} io.jenetics.prngine.internal.DieHarder io.jenetics.prngine.XOR64ShiftRandom -a
}

main $*
