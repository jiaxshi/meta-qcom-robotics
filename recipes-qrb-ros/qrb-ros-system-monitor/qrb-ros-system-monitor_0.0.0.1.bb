inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit ros_insane_dev_so

DESCRIPTION = "Type Adaption implementation on Qualcomm robotics platforms"
AUTHOR = "Peng Wang <quic_penwang@quicinc.com>"
ROS_AUTHOR = "Peng Wang"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86fcc2294062130b497ba0ffff9f82fc"

ROS_CN = "qrb_ros_system_monitor"
ROS_BPN = "qrb_ros_system_monitor"

ROS_BUILD_DEPENDS = " \
    std-msgs \
    rclcpp \
    rclcpp-components \
    qrb-ros-system-monitor-interfaces \
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
    rclcpp-components \
    qrb-ros-system-monitor-interfaces \
"

ROS_TEST_DEPENDS = " \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/quic-qrb-ros/qrb_ros_system_monitor.git;protocol=https;branch=main"
SRCREV = "8680cbe57fc62a68f3e2d98f4e9b726bb8bce726"
S = "${WORKDIR}/git/qrb_ros_system_monitor"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

# for qirf
inherit robotics-package
