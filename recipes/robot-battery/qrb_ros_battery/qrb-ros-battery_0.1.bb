inherit ros_distro_${ROS_DISTRO} pkgconfig
inherit ros_component robotics-package

DESCRIPTION = "qrb ros battery"

HOMEPAGE         = "http://support.cdmatech.com"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_battery.git;protocol=https;branch=main"
SRCREV = "11833cc3d7253fde29c07360ccd3fe6f703a7c9b"
S = "${WORKDIR}/git/qrb_ros_battery"

ROS_CN = "qrb_ros_battery"
ROS_BPN = "qrb_ros_battery"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    battery-client \
    rclcpp-components \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
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
    ament-cmake-copyright \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-flake8 \
    ament-cmake-lint-cmake \
    ament-cmake-pep257 \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
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