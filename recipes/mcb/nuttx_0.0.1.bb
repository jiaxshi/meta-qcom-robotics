DESCRIPTION = "motor control board FW "

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

# SRC_URI +=  "git://git.codelinaro.org/clo/le/platform/external/nuttx.git;protocol=https;rev=e50bbb6eb542d3950481e1d464cd26ddf0208c08;branch=robotics.qclinux.1.0.r1-rel"

SRCPROJECT = "git://git.codelinaro.org/clo/le/platform/external/nuttx.git;protocol=https"
SRCBRANCH  = "robotics.qclinux.1.0.r1-rel"
SRCREV     = "e50bbb6eb542d3950481e1d464cd26ddf0208c08"

SRC_URI +=   "${SRCPROJECT};branch=${SRCBRANCH}"

S =  "${WORKDIR}/git/nuttx/"

FILES_${PN} += "/"

PACKAGES = "${PN}"
CFLAGS = " "
LDFLAGS = " "

TOOLCHAIN_PATH_ADD = "/usr/bin:"
PATH =. "${TOOLCHAIN_PATH_ADD}"
OECMAKE_EXTRA_ROOT_PATH += "/usr/bin"

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

INSANE_SKIP:${PN} += "installed-vs-shipped"

PACKAGES = "${PN}"

FILES:${PN} = "*"

inherit robotics-package
