DESCRIPTION = "Sensor service"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "glib-2.0 property-vault qmi-framework protobuf protobuf-native sensors-ship-qti jsoncpp libbsd"

SRC_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_00039.2/le-qcrobotics-1-0-r1/apps_proc/prebuilt_HY22/sensor-service_2.1_qcm6490.tar.gz"
SRC_URI[sha256sum] = "ef9677205d8c01b38b74ce5f0e6dc8eeb18160ad300c15d36fc9b8bbaaaac732"

S = "${WORKDIR}/sensor-service"

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

do_install() {
    cp -r ${WORKDIR}/etc ${D}/
    cp -r ${WORKDIR}/lib ${D}/
    cp -r ${WORKDIR}/sbin ${D}/
    cp -r ${WORKDIR}/usr ${D}/
}

do_package_qa[noexec] = "1"