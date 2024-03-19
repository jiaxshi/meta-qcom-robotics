inherit ros_distro_humble
inherit ros_component robotics-package

DESCRIPTION = "QRB ROS IMU Node"

HOMEPAGE         = "http://support.cdmatech.com"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRC_URI   +=  "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robot-sensor.git;protocol=https;rev=eaffe1ec0f2840f9af5a9c17dcfcbccc0f8a7a2b;branch=robotics.qclinux.1.0.r1-rel"
S         =  "${WORKDIR}/git/qrb_ros_imu/"

ROS_CN = "qrb_ros_imu"
ROS_BPN = "qrb_ros_imu"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    sensor-client \
    rclcpp-components \
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
    sensor-msgs \
    sensor-client \
    sensor-service \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
    ament-cmake-gtest \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

PACKAGES = "qirf-${PN}"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
