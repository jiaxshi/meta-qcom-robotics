PACKAGES = "${PN}"
FILES:${PN} = "/${SDK_PN}/"
DEPENDS:remove += "${BASEDEPENDS}"

# We only need the packaging tasks - disable the rest
do_configure[noexec] = "1"
do_compile[noexec] = "1"
do_populate_lic[noexec] = "1"
do_package_qa[noexec] = "1"
do_generate_robotics_sdk[nostamp] = "1"
INSANE_SKIP:${PN} += "already-stripped"
ALLOW_EMPTY:${PN} = "1"
