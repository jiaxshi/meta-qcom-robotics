inherit cmake pkgconfig python3native

SUMMARY  = "QTI open-source ROS2 node based on Gstreamer"
iSECTION = "multimedia"
LICENSE  = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

def get_ros_version(d):
    if bb.utils.contains('DISTRO_FEATURES', 'ros2-foxy', '1', '0', d) == "1":
        return "foxy"
    if bb.utils.contains('DISTRO_FEATURES', 'ros2-foxy-sdk', '1', '0', d) == "1":
        return "foxy"
    if bb.utils.contains('DISTRO_FEATURES', 'ros2-dashing', '1', '0', d) == "1":
        return "dashing"
    return "unknown"

def get_ros_package(d):
    if get_ros_version(d) == "foxy":
        return "ros2-foxy"
    if get_ros_version(d) == "dashing":
        return "ros2-dashing"
    return "unknown"

ROS_VERSION = "${@get_ros_version(d)}"
ROS_PACKAGE = "${@get_ros_package(d)}"

def config_target_sys(d):
    if d.getVar('PRODUCT', True) == 'ubuntu':
        return "aarch64-linux-gnu"
    else:
        return "${TARGET_ARCH}${TARGET_VENDOR}${@['-' + d.getVar('TARGET_OS'), ''][d.getVar('TARGET_OS') == ('' or 'custom')]}"

TARGET_SYS = "${@config_target_sys(d)}"

APPEND_FLAGS += '${@bb.utils.contains("PRODUCT", "ubuntu", \
                "-target ${TARGET_SYS} -I ${STAGING_INCDIR}/c++ ", "", d)}'
OECMAKE_C_FLAGS:append   = "${APPEND_FLAGS}"
OECMAKE_CXX_FLAGS:append = "${APPEND_FLAGS}"

# Dependencies.
DEPENDS += '${@bb.utils.contains("WITHIN_EXT_SDK", "1", "", "virtual/kernel", d)}'
DEPENDS += "system-core-headers"
DEPENDS += "llvm-arm-toolchain-native"
DEPENDS += "glib-2.0"
DEPENDS += "${@bb.utils.contains('WITHIN_EXT_SDK', '1', '', '\
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    ', d)}"

DEPENDS += "python3-pyparsing"
DEPENDS += "liblog"

DEPENDS += '${@bb.utils.contains("ROS_VERSION", "dashing",\
   "ros2-dashing",\
   "ament-cmake-native \
    rclcpp \
    ament-cmake \
    poco \
    sensor-msgs \
    geometry-msgs \
    rosidl-adapter \
    rcl-logging-noop \
    message-filters \
    ament-index-cpp \
    class-loader \
    rosidl-generator-c \
    console-bridge-vendor \
    image-transport", d)} \
'

RDEPENDS:${PN} += "gst-ros2sink"

SOURCEPATH = "${@bb.utils.contains('WITHIN_EXT_SDK', '1', '${WORKSPACE}', '${WORKSPACEROOT}/layers/src', d)}"
FILESPATH =+ "${SOURCEPATH}/vendor/qcom/opensource/robotics-oss:"
SRC_URI   =  "file://gst-ros2node/"
S         =  "${WORKDIR}/gst-ros2node/"

ROS_DIR    := '${@bb.utils.contains("PRODUCT", "ubuntu", \
    "/opt/ros/${ROS_VERSION}", "/usr/", d)}'
INSTALL_LIBDIR := '${@bb.utils.contains("PRODUCT", "ubuntu", \
    "/opt/ros/${ROS_VERSION}/lib", "/usr/lib", d)}'

EXTRA_OECMAKE  += "-DROS_VERSION=${ROS_VERSION}"
EXTRA_OECMAKE  += "-DROS_DIR=${RECIPE_SYSROOT}/${ROS_DIR}"
EXTRA_OECMAKE  += "${@bb.utils.contains('WITHIN_EXT_SDK', '1', \
    '-DKERNEL_INCDIR=${STAGING_DIR}/${MACHINE}/usr/include/linux-msm', \
    '-DKERNEL_INCDIR=${STAGING_KERNEL_BUILDDIR}', \
    d)}"
EXTRA_OECMAKE  += "-DGST_VERSION_REQUIRED=1.14.4"
EXTRA_OECMAKE  += "-DSYSROOT_INCDIR=${STAGING_INCDIR}"
EXTRA_OECMAKE  += "-DSYSROOT_LIBDIR=${STAGING_LIBDIR}"
EXTRA_OECMAKE  += "-DDASHING_DIR=${RECIPE_SYSROOT}/${DASHING_DIR}"
EXTRA_OECMAKE  += "-DINSTALL_LIBDIR=${INSTALL_LIBDIR}"
EXTRA_OECMAKE  += "-DPLATFORM:STRING=linux"
EXTRA_OECMAKE  += "-DCPU:STRING=64"
EXTRA_OECMAKE  += "-DENABLE_LIBLOG:BOOL=True"
EXTRA_OECMAKE  += "-DCMAKE_CROSSCOMPILING:BOOL=True"
EXTRA_OECMAKE  += "-DCMAKE_C_COMPILER:STRING=${OECMAKE_C_COMPILER}"
EXTRA_OECMAKE  += '${@bb.utils.contains("PRODUCT", "ubuntu", \
                  "-DROS_FOXY:BOOL=False", "-DROS_FOXY:BOOL=True", d)}'
EXTRA_OECMAKE  += '${@bb.utils.contains("PRODUCT", "ubuntu", \
                  "-DGNU:BOOL=True", "-DGNU:BOOL=False", d)}'

EXTRA_OECMAKE  += '${@bb.utils.contains("PRODUCT", "ubuntu", \
    "-DROS_NATIVE_DIR=${RECIPE_SYSROOT}/${ROS_DIR}", \
    "-DROS_NATIVE_DIR=${RECIPE_SYSROOT_NATIVE}/${ROS_DIR}", d)}'

export PYTHONPATH = "${RECIPE_SYSROOT}${PYTHON_SITEPACKAGES_DIR}:${RECIPE_SYSROOT}/opt/ros/${ROS_VERSION}/lib/python3.8/site-packages"

do_configure[depends] += "${@bb.utils.contains('WITHIN_EXT_SDK', '1', '', 'virtual/kernel:do_shared_workdir', d)}"
do_configure:prepend() {
    echo "PYTHONPATH=${PYTHONPATH}"
}

do_install:append() {
    install -d ${D}/data/misc/ros2/
    install -d ${D}/${INSTALL_LIBDIR}/

    if [ -d "${WORKDIR}/gst-ros2node/config/" ];then
        cp -rf ${WORKDIR}/gst-ros2node/config/*.xml ${D}/data/misc/ros2/
    fi

    if [ ${@bb.utils.contains("PRODUCT", "ubuntu", "1", "0", d)} == "1" ]; then
        if [ -d "${D}/usr/share/" ];then
            cp  -rf ${D}/usr/share/ ${D}/${ROS_DIR}/
            rm -rf ${D}/usr
        fi
    fi
}

FILES:${PN} += "\
    ${ROS_DIR}/* \
    /data/* "

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
do_package_qa[noexec] = "1"
#RM_WORK_EXCLUDE += "${PN}"
