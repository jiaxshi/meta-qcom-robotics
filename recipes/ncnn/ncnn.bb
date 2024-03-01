DESCRIPTION = "ncnn is a high-performance neural network inference framework optimized for the mobile platform"

LICENSE = "BSD-2-Clause & BSD-3-Clause & Zlib"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-2-Clause;md5=cb641bc04cda31daea161b1bc15da69f"
LIC_FILES_CHKSUM += "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
LIC_FILES_CHKSUM += "file://${COREBASE}/meta/files/common-licenses/Zlib;md5=87f239f408daca8a157858e192597633"

inherit cmake

PR = "r0"
PV = "1.0"

SRC_URI = "git://github.com/Tencent/ncnn.git;protocol=https;branch=master;rev=4494aadd74bb7c38843746cc4f15c152637dc158"
S = "${WORKDIR}/git"

FILES:${PN} += "${incdir}/*"
FILES:${PN} += "${libdir}/*"

PACKAGES = "${PN}"
EXTRA_OECMAKE += " -DNCNN_DISABLE_RTTI=OFF"

do_package_qa[noexec] = "1"

INSANE_SKIP:${PN} += "installed-vs-shipped"
