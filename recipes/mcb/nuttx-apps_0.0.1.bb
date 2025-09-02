DESCRIPTION = "motor control board FW "

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

SRCPROJECT = "git://git.codelinaro.org/clo/le/platform/external/nuttx-apps.git;protocol=https"
SRCBRANCH  = "robotics.qclinux.1.0.r1-rel"
SRCREV     = "e84c9db9d61319a3d0e572c25bb2ed398f611a14"

SRC_URI +=   "${SRCPROJECT};branch=${SRCBRANCH}"

S =  "${WORKDIR}/git/nuttx-apps/"

FILES_${PN} += "/"

PACKAGES = "${PN}"
CFLAGS = " "
LDFLAGS = " "

do_compile(){
}

do_install() {
}

INSANE_SKIP:${PN} += "installed-vs-shipped"

inherit robotics-package
