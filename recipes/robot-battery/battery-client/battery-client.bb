inherit pkgconfig qprebuilt autotools-brokensep

DESCRIPTION = "battery client"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"


DEPENDS += "dbus"

SRC_URI += "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robot-battery.git;protocol=https;rev=cb5e2cea40f53509ffa15dbf65f19727ad2da804;branch=robotics.qclinux.1.0.r1-rel"
S = "${WORKDIR}/git/battery-client"

EXTRA_OECONF += " --with-sanitized-headers=${STAGING_KERNEL_BUILDDIR}/usr/include"
EXTRA_OECONF += " --with-glib"

addtask do_configure after do_prepare_recipe_sysroot before do_install
addtask do_compile after do_configure before do_install

#Disable the split of debug information into -dbg files
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

FILES:${PN} += "${libdir}/*"
FILES:${PN}-dev = "${libdir}/* ${includedir}"

#Skips check for .so symlinks
INSANE_SKIP:${PN} = "dev-so"

# need to export these variables for python-config to work
FILES:${PN} += "${includedir}/*"
FILES:${PN} += "/usr/lib/*"
FILES:${PN} += "/usr/lib64/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
FILES:${PN} += "${sysconfdir}/sensors/*"
FILES:${PN} += "${systemd_unitdir}/system/"
FILES:${PN} += "/systemd/system/*"
RM_WORK_EXCLUDE += "${PN}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

do_install:append() {
    install -m 0755 ${S}/battery_client_test -D ${D}/sbin/battery_client_test
    install -d ${D}/usr/include/
    install -m 0755 ${S}/inc/*.hpp -D ${D}/usr/include
}

PACKAGE_ARCH    ?= "${MACHINE_ARCH}"