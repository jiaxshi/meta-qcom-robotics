inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "QRB ROS Yolo Pre/Post process node"

LICENSE          = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=65b8cd575e75211d9d4ca8603167da1c"

SRC_URI  = "git://github.com/qualcomm-qrb-ros/qrb_ros_tensor_process.git;protocol=https;branch=main"
SRCREV   = "2aaec03cb10f2ea47fd5c03f23b7c0dc5b7f676b"
S        = "${WORKDIR}/git/cv_tensor_process/yolo_v8_process/qrb_ros_yolo_process"

ROS_BUILD_DEPENDS = " \
    ament-index-cpp \
    cv-bridge \
    rclcpp \
    rclcpp-components \
    qrb-yolo-process-lib \
    message-filters \
    std-msgs \
    sensor-msgs \
    vision-msgs \
    qrb-ros-vision-msgs \
    qrb-ros-tensor-list-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    ament-cmake-ros-native \
"

ROS_EXEC_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    vision-msgs \
    message-filters \
    cv-bridge \
    rclcpp-components \
    qrb-ros-vision-msgs \
    qrb-ros-tensor-list-msgs \
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
    qrb-ros-tensor-list-msgs \
    qrb-yolo-process-lib \
"
