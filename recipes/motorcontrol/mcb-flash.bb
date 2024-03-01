DESCRIPTION = "MCB flash tool"
LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
LIC_FILES_CHKSUM += "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0"

inherit cmake

PR = "r0"
PV = "1.0"


FILESPATH =+ "${WORKSPACE}/vendor/qcom/opensource/robotics-oss:"
S = "${WORKDIR}/mcb-flash"
SRC_URI = "file://mcb-flash"

FILES_${PN} += "/"

PACKAGES = "${PN}"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/../build/mcbflash ${D}${bindir}
}
do_package_qa[noexec] = "1"
