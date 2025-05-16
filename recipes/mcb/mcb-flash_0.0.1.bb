
DESCRIPTION = "MCB flash tool"

LICENSE  = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

inherit cmake

DEPENDS = "libqrc-udriver"

#PR = "r0"
#PV = "1.0"

SRC_URI +=  "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robotics-oss.git;protocol=https;rev=f7e7b5a67d04bd2c22b5ca4c04b616ae797a31d4;branch=robotics.qclinux.1.0.r1-rel"

S =  "${WORKDIR}/git/mcb-flash/"

FILES_${PN} += "/"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/../build/mcbflash ${D}${bindir}
}
do_package_qa[noexec] = "1"

INSANE_SKIP:${PN} += "installed-vs-shipped"

inherit robotics-package
