inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit ros_insane_dev_so

DESCRIPTION = "QRB Follow Path Library"
AUTHOR           = "Xiaowei Zhang <quic_xiaowz@quicinc.com>"
ROS_AUTHOR       = "Xiaowei Zhang"
SECTION          = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86fcc2294062130b497ba0ffff9f82fc"

ROS_CN = "qrb_follow_path_manager"
ROS_BPN = "qrb_follow_path_manager"

ROS_BUILD_DEPENDS = " \
    libeigen \
    libtinyxml2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXEC_DEPENDS = " \
    libeigen \
    libtinyxml2 \
"

ROS_EXPORT_DEPENDS = " \
    libeigen \
    libtinyxml2 \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

NON_ROS_EXEC_DEPENDS = " \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS} ${NON_ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_follow_path_service.git;protocol=https;branch=main"
SRCREV = "b9d051fe009426134b7663e443f704847dfaafd8"
S = "${WORKDIR}/git/qrb_follow_path_manager"

ROS_BUILD_TYPE = "ament_cmake"
do_package_qa[noexec] = "1"
inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package
