pkg_dest = "/usr"

do_install() {
    cp -r ${WORKDIR}/usr ${D}/
}

PACKAGES = "${PN}"
FILES:${PN} = "${pkg_dest} \
    "

PROVIDES += "${PN}"
RPROVIDES:${PN} += "${PN}"

python __anonymous(){
    soc_arch = d.getVar("SOC_ARCH")
    d.setVar('PACKAGE_ARCH',soc_arch)
}

do_package_qa[noexec] = "1"
