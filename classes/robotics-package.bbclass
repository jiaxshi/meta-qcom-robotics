# Copyright (c) 2024 Qualcomm Innovation Center, Inc. All rights reserved.
# SPDX-License-Identifier: BSD-3-Clause-Clear

pkg_dest ?= "/opt/qcom/qirf-sdk"

do_move_opt() {
    install -d ${D}/${pkg_dest}

    for item in ${D}/*; do
        if [ -d "$item" ] && [ "$item" != "${D}/opt" ]; then
            cp -r "$item" "${D}/${pkg_dest}"
        fi
    done
}

do_install[postfuncs] += "do_move_opt"

PACKAGES += "qirf-${PN}"

FILES:qirf-${PN} = "${pkg_dest}"

PROVIDES += "qirf-${PN}"

RPROVIDES:qirf-${PN} += "${PN}"
ROS_EXEC_DEPENDS ?= " "

RDEPENDS:qirf-${PN} += " ${ROS_EXEC_DEPENDS}"

do_package_qa[noexec] = "1"

INSANE_SKIP:${PN} += "installed-vs-shipped"
