# Copyright (c) 2024 Qualcomm Innovation Center, Inc. All rights reserved.
# SPDX-License-Identifier: BSD-3-Clause-Clear
SDK_NAME = "qirf"

pkg_dest ?= "/opt/qcom/${SDK_NAME}-sdk"

do_move_opt() {
    install -d ${D}/${pkg_dest}

    for item in ${D}/*; do
        if [ -d "$item" ] && [ "$item" != "${D}/opt" ]; then
            cp -r "$item" "${D}/${pkg_dest}"
        fi
    done
}

do_install[postfuncs] += "do_move_opt"

FILES:${SDK_NAME}-${PN} = "${pkg_dest}"
PROVIDES += "${SDK_NAME}-${PN}"
RPROVIDES:${SDK_NAME}-${PN} += "${PN}"
RDEPENDS:${SDK_NAME}-${PN} = "${@get_runtime_depends('${PN}',d)}"

FILES:${SDK_NAME}-${PN}-dbg = "${pkg_dest}${libdir}/debug"

ROS_EXEC_DEPENDS ?= " "

RDEPENDS:${SDK_NAME}-${PN}:remove = "${@remove_rdepends(d)}"

INSANE_SKIP:${PN} += "installed-vs-shipped"
INSANE_SKIP:${PN} += "dev-so"

#INSANE_SKIP:${SDK_NAME}-${PN} += "already-stripped"
INSANE_SKIP:${SDK_NAME}-${PN} += "staticdev"
INSANE_SKIP:${SDK_NAME}-${PN} += "installed-vs-shipped"
INSANE_SKIP:${SDK_NAME}-${PN} += "dev-so"

# while enable ubuntu target compilation ,stop the shlibs
PACKAGEFUNCS:remove = "${@packages_funcs(d)}"

def packages_funcs(d):
    # Your code here
    ros_exec_depends = d.getVar("ROS_EXEC_DEPENDS") or ""
    ubuntu_version = d.getVar("UBUNTU_VERSION") or ""
    if len(ros_exec_depends.strip()) != 0 and len(ubuntu_version.strip()) != 0:
        return "package_do_shlibs"
    return ""
def remove_rdepends(d):
    ros_exec_depends = d.getVar("ROS_EXEC_DEPENDS") or ""
    ubuntu_version = d.getVar("UBUNTU_VERSION") or ""
    # if set ROS_EXEC_DEPENDS in Ubuntu build , return the ros_exec_deepends
    if len(ros_exec_depends.strip()) != 0 and len(ubuntu_version.strip()) != 0:
        return ros_exec_depends
    return ""
def get_runtime_depends(PN,d):
    runtime_depends = d.getVar('RDEPENDS:{}'.format(PN), True)
    if runtime_depends :
        return runtime_depends
    return " "


# define the ${SDK_NAME}-${PN} package to replace ${PN}
# package all the file to ${SDK_NAME}-${PN}
# add provide for ${SDK_NAME}-${PN} , keep ${PN} as provider too
# add Rprovider ${SDK_NAME}-${PN} , keep ${PN} as provider too

python __anonymous(){
    package_name = d.getVar("PN")
    sdk_name = d.getVar("SDK_NAME")
    target_package_name = "{}-{} {}-{}-dbg".format(sdk_name,package_name,sdk_name,package_name)
    d.setVar("PACKAGES",target_package_name)

    target_arch = d.getVar("TARGET_ARCH")
    d.setVar('PACKAGE_ARCH',target_arch)

    ros_exec_depends = d.getVar("ROS_EXEC_DEPENDS") or ""
    ubuntu_version = d.getVar("UBUNTU_VERSION") or ""
    if len(ros_exec_depends.strip()) != 0 and len(ubuntu_version.strip()) != 0:
        d.setVarFlag('do_package_qa', 'noexec', '1')
}

do_package_qa[noexec] = "1"
