inherit ros_distro_${ROS_DISTRO}
inherit ros_component robotics-package

DESCRIPTION = "qrb ros battery"

HOMEPAGE         = "http://support.cdmatech.com"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRC_URI += "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robot-battery.git;protocol=https;rev=cb5e2cea40f53509ffa15dbf65f19727ad2da804;branch=robotics.qclinux.1.0.r1-rel"
S =  "${WORKDIR}/git/qrb_ros_battery/"

ROS_CN = "qrb_ros_battery"
ROS_BPN = "qrb_ros_battery"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    battery-client \
    rclcpp-components \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    battery-client \
    battery-service \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

EXTRA_OECMAKE  += "-DSYSROOT_INCDIR=${RECIPE_SYSROOT}/usr/include"
EXTRA_OECMAKE  += "-DSYSROOT_LIBDIR=${RECIPE_SYSROOT}/usr/lib"

DEPENDS += "dbus"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"
RDEPENDS:${PN} += "dbus"


ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

