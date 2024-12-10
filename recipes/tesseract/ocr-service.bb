inherit ros_distro_${ROS_DISTRO}
inherit ros_component robotics-package

DESCRIPTION = "ocr ros2 node"

HOMEPAGE         = "https://git.codelinaro.org/"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRC_URI   +=  "git://git.codelinaro.org/clo/le/qirp-oss.git;protocol=https;rev=750510465193ab62513e3d8e4121c74fdda159f5;branch=robotics-sdk.qclinux.1.0.r1-rel"
S         =  "${WORKDIR}/git/samples/ai_nodes/ocr_service/ocr_ros2node/"

ROS_CN = "ocr_service"
ROS_BPN = "ocr_service"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    ocr-msg \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    python-cmake-module-native \
"

ROS_EXPORT_DEPENDS = " \
    rclpy \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclpy \
    rpyutils \
    sensor-msgs \
    python3-pytesseract \
    python3-numpy \
    tesseract \
"
# temp change for qirf sdk
ROS_EXEC_DEPENDS += " ocr-msg "

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
    ament-cmake-pytest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_python"
inherit ros_${ROS_BUILD_TYPE}
