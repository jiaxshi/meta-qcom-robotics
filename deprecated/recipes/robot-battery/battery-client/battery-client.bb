inherit ros_distro_${ROS_DISTRO} pkgconfig
inherit ros_component
inherit ros_insane_dev_so

DESCRIPTION = "battery client"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

ROS_CN = "qrb_battery_client"
ROS_BPN = "qrb_battery_client"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_battery.git;protocol=https;branch=main"
SRCREV = "11833cc3d7253fde29c07360ccd3fe6f703a7c9b"
S = "${WORKDIR}/git/qrb_battery_client"

ROS_BUILD_DEPENDS = " \
    dbus \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package
