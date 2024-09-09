pkg_dest = "/opt/qcom/qirf-sdk"

do_install() {
   cp -r ${WORKDIR}/opt ${D}/
}

PACKAGES = "qirf-${PN}"
FILES:qirf-${PN} = "${pkg_dest}"

PROVIDES += "qirf-${PN}"
RPROVIDES:qirf-${PN} += "${PN}"

python __anonymous(){
    target_arch = d.getVar("TARGET_ARCH")
    d.setVar('PACKAGE_ARCH',target_arch)
}

do_package_qa[noexec] = "1"
