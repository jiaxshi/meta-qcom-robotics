inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "QRB ROS CV tensor common process node"

LICENSE          = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=65b8cd575e75211d9d4ca8603167da1c"

SRC_URI  = "git://github.com/qualcomm-qrb-ros/qrb_ros_tensor_process.git;protocol=https;branch=main"
SRCREV   = "d151cbe1ac3194b3c7acab699da2e7dcd53e36df"
S        = "${WORKDIR}/git/cv_tensor_process/cv_tensor_common_process"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    cv-bridge \
    rclcpp \
    rclcpp-components \
    std-msgs \
    sensor-msgs \
    qrb-ros-tensor-list-msgs \
    qrb-ros-transport-image-type \
    lib-mem-dmabuf \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    ament-cmake-ros-native \
"

ROS_EXEC_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    cv-bridge \
    rclcpp-components \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
    ament-index-cpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = " \
"

ROS_TEST_DEPENDS = " \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package

RDEPENDS:${PN} = "${ROS_EXEC_DEPENDS}"

RDEPENDS:${PN} += " \
    qrb-ros-transport-image-type \
    lib-mem-dmabuf \
"

