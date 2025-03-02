inherit ros_distro_${ROS_DISTRO}
inherit ros_component ros_insane_dev_so

DESCRIPTION = "Ranger mini3  ros2 node"
HOMEPAGE = "https://github.com/agilexrobotics/ranger_ros2.git"



LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

ROS_CN = "ranger-mini-base"
ROS_BPN = "ranger-mini-base"

ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    rosidl-default-generators \
    geometry-msgs \
    rosidl-adapter \
    rclcpp-components \
    geometry-msgs \
    rclcpp \
    rclcpp-action \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    rclpy \
    joint-state-publisher \
    nav2-msgs \
    nav-msgs \
    ugv-sdk \
    ranger-mini-msg \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-pytest \
    ament-cmake-ros \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    ugv-sdk \
    ranger-mini-msg \
"

ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BRANCH ?= "master"
SRC_URI = "git://github.com/agilexrobotics/ranger_ros2.git;branch=${ROS_BRANCH};protocol=https"
SRCREV = "35c3620ced04960dd8ee3e56bc6f4d2eb009aeda"
S = "${WORKDIR}/git/ranger_base"

ROS_BUILD_TYPE = "ament_cmake"

PACKAGES = "${PN}"

FILES:${PN} = "*"

do_package_qa[noexec] = "1"

inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package

