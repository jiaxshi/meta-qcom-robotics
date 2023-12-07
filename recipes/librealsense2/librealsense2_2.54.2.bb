SUMMARY = "Library for Intel Realsense D435i/D455"
HOMEPAGE = "https://github.com/IntelRealSense/librealsense"
SECTION = "libs"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit cmake pkgconfig ccache
SRC_URI = "git://github.com/IntelRealSense/librealsense.git;protocol=https;branch=master;rev=2dbaaf5964490cb02f811cf2ed38c8a893f5c027"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += " \
    -DBUILD_SHARED_LIBS=ON \
    -DBUILD_WITH_TM2=OFF \
    -DBUILD_EXAMPLES=ON \
    -DFORCE_RSUSB_BACKEND=ON \
    -DBUILD_GRAPHICAL_EXAMPLES=OFF \
    -DBUILD_GLSL_EXTENSIONS=OFF \
    -DBUILD_WITH_OPENMP=true \
    -DCMAKE_BUILD_TYPE=Release"

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM_class-target:qrb5165-rb5 = "BOTH"

DEPENDS = "udev libusb1 ccache-native"

RDEPENDS:${PN}-tests += "${PN}"

PACKAGES =+ "${PN}-tests"

FILES:${PN} = "${libdir}/${PN}.so.* \
       ${sysconfdir}/udev/rules.d/* "

FILES:${PN}-tests = "${bindir}/rs-color \
       ${bindir}/rs-depth \
       ${bindir}/rs-distance \
       ${bindir}/rs-save-to-disk \
       ${bindir}/rs-enumerate-devices \
       ${bindir}/rs-pose \
       ${bindir}/rs-fw-logger \
       ${bindir}/rs-fw-update "

do_install:append() {
    install -d "${D}${sysconfdir}/udev/rules.d"
    install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}${sysconfdir}/udev/rules.d/99-${PN}-libusb.rules
}

INSANE_SKIP:${PN} += "installed-vs-shipped"
