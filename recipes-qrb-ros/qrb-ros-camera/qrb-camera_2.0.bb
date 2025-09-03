inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit ros_insane_dev_so

DESCRIPTION = "QRB Camera library"
AUTHOR = "Zhanye Lin <zhanlin@qti.qualcomm.com>"
ROS_AUTHOR = "Zhanye Lin"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

ROS_CN = "qrb_camera"
ROS_BPN = "qrb_camera"

ROS_BUILD_DEPENDS = " \
    qcom-camera-server \
    glib-2.0 \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_camera.git;protocol=https;branch=main;subpath=qrb_camera"
SRCREV = "cdc4908b348f8eecfb0e3cb8c1bba786d2fc0c98"
S = "${WORKDIR}/qrb_camera"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

# for qirf
inherit robotics-package
