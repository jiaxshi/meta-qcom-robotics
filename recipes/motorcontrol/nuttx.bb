DESCRIPTION = "motor control board FW "

LICENSE = "BSD-3-Clause & BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"
LIC_FILES_CHKSUM += "file://${COREBASE}/meta-qti-bsp/files/common-licenses/\
BSD-3-Clause-Clear;md5=3771d4920bd6cdb8cbdf1e8344489ee0"

#inherit cmake

PR = "r0"
PV = "1.0"


FILESPATH =+ "${WORKSPACE}/external:"
S = "${WORKDIR}/nuttx"
#S += "${WORKDIR}/nuttx-apps"

SRC_URI = "file://nuttx"
SRC_URI += "file://nuttx-apps"

FILES_${PN} += "/"

PACKAGES = "${PN}"
CFLAGS = " "
LDFLAGS = " "

do_compile(){
   make distclean
   sh ./tools/configure.sh -l qtif427:nsh
   /usr/bin/make
}


do_install() {
    dest=/data/misc/mcb/
    install -d ${D}${dest}
    install -m 755 ${WORKDIR}/nuttx/nuttx.bin -D ${D}${dest}
}
