pkg_dest = "/opt/qcom/qirf-sdk"

do_install() {
   cp -r ${WORKDIR}/opt ${D}/
}

PACKAGES = "qirf-${PN}"
FILES:qirf-${PN} = "${pkg_dest}"

PROVIDES += "qirf-${PN}"
RPROVIDES:qirf-${PN} += "${PN}"
do_package_qa[noexec] = "1"
