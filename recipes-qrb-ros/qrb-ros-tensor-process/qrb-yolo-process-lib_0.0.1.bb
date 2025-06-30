inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "QRB ROS Yolo process library"

LICENSE          = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=65b8cd575e75211d9d4ca8603167da1c"

SRC_URI  = "git://github.com/qualcomm-qrb-ros/qrb_ros_tensor_process.git;protocol=https;branch=main"
SRCREV   = "c73805471ca854dc227fb744e0f93962de58ef9a"
S        = "${WORKDIR}/git/cv_tensor_process/yolo_v8_process/qrb_yolo_process_lib"

ROS_BUILD_DEPENDS = " \
    yaml-cpp \
    opencv \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXEC_DEPENDS = " \
    yaml-cpp \
    opencv \
"

ROS_EXPORT_DEPENDS = " \
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
"
