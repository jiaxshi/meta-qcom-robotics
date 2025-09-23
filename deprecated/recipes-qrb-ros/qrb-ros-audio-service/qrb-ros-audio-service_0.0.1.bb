inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "QRB ROS Audio Service"

SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=68c28a8a26024c85c589d0de638520b6"

ROS_CN = "qrb_ros_audio_service"
ROS_BPN = "qrb_ros_audio_service"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    rclcpp-action \
    qrb-audio-service-lib \
    qrb-ros-audio-service-msgs \
    qrb-ros-audio-common \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    qrb-audio-service-lib \
    qrb-ros-audio-service-msgs \
    qrb-ros-audio-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_audio_service.git;protocol=https;branch=main"
SRCREV = "7ce0992ab496e63eca30a0af7b30ad96160e2320"
S = "${WORKDIR}/git/qrb_ros_audio_service"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package
