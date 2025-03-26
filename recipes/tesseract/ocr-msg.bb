inherit ros_distro_${ROS_DISTRO}
inherit ros_component robotics-package

DESCRIPTION = "ocr service msg type"

HOMEPAGE         = "https://git.codelinaro.org/"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRC_URI   +=  "git://git.codelinaro.org/clo/le/qirp-oss.git;protocol=https;rev=980029e2679ec94bc69e1e2a6e63e3a86c13e9e5;branch=robotics-sdk.qclinux.1.0.r1-rel"
S         =  "${WORKDIR}/git/samples/ai_nodes/ocr_service/ocr_msg/"

ROS_CN = "ocr_msg"
ROS_BPN = "ocr_msg"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    std-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rosidl-default-runtime \
    rclcpp \
    sensor-msgs \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
