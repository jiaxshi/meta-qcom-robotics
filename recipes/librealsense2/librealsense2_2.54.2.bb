SUMMARY = "Library for Intel Realsense D435i/D455"
HOMEPAGE = "https://github.com/IntelRealSense/librealsense"
SECTION = "libs"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/\
${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

inherit cmake pkgconfig ccache robotics-package
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

FILES:${PN} = "${pkg_dest}/${libdir}/${PN}.so.* \
       ${pkg_dest}/${sysconfdir}/udev/rules.d/* "

FILES:${PN}-tests = "${pkg_dest}/${bindir}/rs-color \
       ${pkg_dest}/${bindir}/rs-depth \
       ${pkg_dest}/${bindir}/rs-distance \
       ${pkg_dest}/${bindir}/rs-save-to-disk \
       ${pkg_dest}/${bindir}/rs-enumerate-devices \
       ${pkg_dest}/${bindir}/rs-pose \
       ${pkg_dest}/${bindir}/rs-fw-logger \
       ${pkg_dest}/${bindir}/rs-fw-update "

do_install:append() {
    install -d "${D}/${pkg_dest}/${sysconfdir}/udev/rules.d"
    install -m 0644 ${S}/config/99-realsense-libusb.rules ${D}/${pkg_dest}/${sysconfdir}/udev/rules.d/99-${PN}-libusb.rules
}

INSANE_SKIP:${PN} += "installed-vs-shipped"