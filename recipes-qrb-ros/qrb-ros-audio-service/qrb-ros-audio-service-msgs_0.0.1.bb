inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit ros_insane_dev_so

DESCRIPTION = "QRB ROS Audio Service msgs"

SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=86fcc2294062130b497ba0ffff9f82fc"

ROS_CN = "qrb_ros_audio_service_msgs"
ROS_BPN = "qrb_ros_audio_service_msgs"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_interfaces.git;protocol=https;branch=main"
SRCREV = "1b6adcdd69302c2c55f5c434f7c010fae768ed1a"
S = "${WORKDIR}/git/qrb_ros_audio_service_msgs/qrb_ros_audio_service_msgs"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    builtin-interfaces \
    rcl-interfaces \
    std-msgs \
    action-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    builtin-interfaces \
    rosidl-default-runtime \
    std-msgs \
    rcl-interfaces \
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
