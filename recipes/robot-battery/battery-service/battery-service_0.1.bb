inherit pkgconfig qprebuilt autotools-brokensep systemd

DESCRIPTION = "battery service"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

DEPENDS += "dbus"

SRC_URI += "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robot-battery.git;protocol=https;rev=cb5e2cea40f53509ffa15dbf65f19727ad2da804;branch=robotics.qclinux.1.0.r1-rel"
S = "${WORKDIR}/git/battery-service"

addtask do_configure after do_prepare_recipe_sysroot before do_install
addtask do_compile after do_configure before do_install

#EXTRA_OECONF += " --with-sanitized-headers=${STAGING_KERNEL_BUILDDIR}/usr/include"
#EXTRA_OECONF += " --with-glib"

#Disable the split of debug information into -dbg files
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"

#Skips check for .so symlinks
INSANE_SKIP:${PN} = "dev-so"

# need to export these variables for python-config to work
FILES:${PN} += "${includedir}/*"
FILES:${PN} += "/usr/lib/*"
FILES:${PN} += "/usr/bin/*"
FILES:${PN}-dev  = "${libdir}/*.la ${includedir}"
FILES:${PN} += "${sysconfdir}/sensors/*"
FILES:${PN} += "${systemd_unitdir}/system/"
FILES:${PN} += "/systemd/system/*"
RM_WORK_EXCLUDE += "${PN}"
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

PACKAGE_ARCH    ?= "${MACHINE_ARCH}"

# adding user add packages
USERADD_PACKAGES = "${PN}"
USERADD_PARAM_${PN} = "-u 1234 -d /home/myuser -r -s /bin/false myuser"

do_install:append() {
    install -d ${D}/${sysconfdir}/init.d
    install -m 0755 ${S}/battery_service -D ${D}/sbin/battery_service
    if ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'true', 'false', d)}; then
        install -d ${D}${systemd_unitdir}/system/
        install -m 644 ${S}/battery-config-default.txt -D ${D}/${sysconfdir}/battery-config-default.txt
        install -m 666 ${S}/battery-config.txt -D ${D}/${sysconfdir}/battery-config.txt
        install -m 0644 ${S}/battery.service -D ${D}${systemd_unitdir}/system/battery.service
        install -d ${D}${systemd_unitdir}/system/multi-user.target.wants/
        ln -sf ${systemd_unitdir}/system/battery.service \
           ${D}${systemd_unitdir}/system/multi-user.target.wants/battery.service
    fi
    install -m 644 ${S}/battery-dbus.conf -D ${D}/etc/dbus-1/system.d/battery-dbus.conf
}
do_package_qa[noexec] = "1"