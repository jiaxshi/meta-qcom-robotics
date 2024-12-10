DESCRIPTION = "Sensor service"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "glib-2.0 property-vault"
DEPENDS += "qmi-framework"
DEPENDS += "protobuf"
DEPENDS += "protobuf-native"
DEPENDS += "qcom-sensors-api"
DEPENDS += "qcom-sensors-utils"
DEPENDS += "qcom-sensinghub"
DEPENDS += "jsoncpp"
DEPENDS += "libbsd"
RDEPENDS:${PN} += "jsoncpp"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "e007009ab571c285edc64ff141e065aedf81c9efc72b4cceb7ddbbfc7692dbad"

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

PACKAGE_ARCH    ?= "${SOC_ARCH}"

do_install() {
    cp -r ${WORKDIR}/etc ${D}/
    cp -r ${WORKDIR}/usr ${D}/
}

do_package_qa[noexec] = "1"
