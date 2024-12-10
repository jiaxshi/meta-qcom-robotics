SUMMARY = "Library for the qcom-robotic-controller user driver"
SECTION = "libs"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

inherit cmake pkgconfig ccache robotics-package

SRC_URI +=  "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robotics-oss.git;protocol=https;rev=a5b0e54e888928a3b410bbddb9cd446023e4ab7e;branch=robotics.qclinux.1.0.r1-rel"
S =  "${WORKDIR}/git/qrc/libqrc-udriver/"

DEPENDS = "libgpiod"

FILES:${PN} += "${pkg_dest}/${libdir}/${PN}.so.*"

INSANE_SKIP:${PN} += "installed-vs-shipped"
