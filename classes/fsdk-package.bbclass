SSTATETASKS += "do_generate_robotics_sdk "
SSTATE_OUT_DIR = "${DEPLOY_DIR}/qirfsdk_artifacts/"
SSTATE_IN_DIR = "${TOPDIR}/${SDK_PN}"
TMP_SSTATE_IN_DIR = "${TOPDIR}/${SDK_PN}_tmp"
SAMPLES_PATH ?= "NULL"
TOOLCHAIN_PATH ?= "NULL"
TOOLS_PATH ?= "NULL"
README_PATH ?= "NULL"
SETUP_PATH ?= "NULL"

python __anonymous () {
    package_type = d.getVar("IMAGE_PKGTYPE", True)
    if package_type == "ipk":
        bb.build.addtask('do_package_write_ipk', 'do_populate_sysroot', 'do_packagedata', d)
        bb.build.addtask('do_generate_robotics_sdk', 'do_populate_sysroot', 'do_package_write_ipk', d)
        d.appendVarFlag('do_package_write_ipk', 'prefuncs', ' do_reorganize_pkg_dir')
    elif package_type == "deb":
        bb.build.addtask('do_package_write_deb', 'do_populate_sysroot', 'do_packagedata', d)
        bb.build.addtask('do_generate_robotics_sdk', 'do_populate_sysroot', 'do_package_write_deb', d)
        d.appendVarFlag('do_package_write_deb', 'prefuncs', ' do_reorganize_pkg_dir')
}

addtask do_generate_robotics_sdk_setscene
do_generate_robotics_sdk[postfuncs] += "organize_sdk_file"
do_generate_robotics_sdk[sstate-inputdirs] = "${SSTATE_IN_DIR}"
do_generate_robotics_sdk[sstate-outputdirs] = "${SSTATE_OUT_DIR}"
do_generate_robotics_sdk[dirs] = "${SSTATE_IN_DIR} ${SSTATE_OUT_DIR} ${TMP_SSTATE_IN_DIR}"
do_generate_robotics_sdk[cleandirs] = "${SSTATE_IN_DIR} ${SSTATE_OUT_DIR} ${TMP_SSTATE_IN_DIR}"
do_generate_robotics_sdk[stamp-extra-info] = "${MACHINE_ARCH}"

# Add a task to generate robotics sdk
do_generate_robotics_sdk () {
    # generate Robotics SDK package
    if [ ! -d ${TMP_SSTATE_IN_DIR}/${SDK_PN} ]; then
        mkdir -p ${TMP_SSTATE_IN_DIR}/${SDK_PN}/
    fi
    cp -r ${SETUP_PATH} ${TMP_SSTATE_IN_DIR}/${SDK_PN}/
    for pkg in ${PKG_LISTS}
    do
        cp ${DEPLOY_DIR}/${IMAGE_PKGTYPE}/${PACKAGE_ARCH}/${pkg} ${TMP_SSTATE_IN_DIR}/${SDK_PN}/
    done
    cd ${TMP_SSTATE_IN_DIR}
    tar -zcf ${SSTATE_IN_DIR}/${SDK_PN}.tar.gz ./${SDK_PN}/*
}

# Add a task to copy sample code/toolchain/setup scripts,
# and orgnanize as finial sdk artifact
organize_sdk_file () {
    # orgnanize runtime packages
    if ls ${SSTATE_IN_DIR}/${SDK_PN}* >/dev/null 2>&1; then
        install -d ${SSTATE_IN_DIR}/${SDK_PN}/runtime
        mv ${SSTATE_IN_DIR}/${SDK_PN}*.tar.gz ${SSTATE_IN_DIR}/${SDK_PN}/runtime/
    else
        bbfatal "No ${SDK_PN} packages generated, will miss base function! Please check it!"
    fi

    # orgnanize README docs
    if ls ${README_PATH} >/dev/null 2>&1; then
        cp -r ${README_PATH} ${SSTATE_IN_DIR}/${SDK_PN}/
    else
        bbwarn "No README docs find in ${README_PATH}, Please Note it!"
    fi

    # organize all files as finial sdk
    cd ${SSTATE_IN_DIR}
    tar -zcf ${SSTATE_IN_DIR}/${SDK_PN}_${PV}.tar.gz ./${SDK_PN}/*
    rm -r ${SSTATE_IN_DIR}/${SDK_PN}
}

python do_generate_robotics_sdk_setscene() {
    sstate_setscene(d)
}
