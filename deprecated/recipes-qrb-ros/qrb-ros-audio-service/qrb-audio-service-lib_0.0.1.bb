inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "QRB Audio Seervice library"

SECTION = "devel"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=68c28a8a26024c85c589d0de638520b6"

ROS_CN = "qrb_audio_service_lib"
ROS_BPN = "qrb_audio_service_lib"

ROS_BUILD_DEPENDS = ""

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_audio_service.git;protocol=https;branch=main"
SRCREV = "7ce0992ab496e63eca30a0af7b30ad96160e2320"
SRC_URI[sha256sum] = "fc15dd8cb58d75b392c5da532ec6d76389466d615d5368ecc522a85ac5ac9c2d"

S = "${WORKDIR}/git/qrb_audio_manager"

DEPENDS += " \
    qrb-audio-common-lib \
"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

EXTRA_OECMAKE:append = " -DBUILD_TESTING=OFF"

inherit robotics-package
