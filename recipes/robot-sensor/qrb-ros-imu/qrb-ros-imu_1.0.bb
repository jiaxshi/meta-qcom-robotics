inherit ros_distro_${ROS_DISTRO} pkgconfig
inherit ros_component robotics-package

DESCRIPTION = "QRB ROS IMU Node"

HOMEPAGE         = "http://support.cdmatech.com"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRC_URI   +=  "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robot-sensor.git;protocol=https;rev=cc6df61ef46b9dc9c6169714ea0e7b69664f1fa8;branch=robotics.qclinux.1.0.r1-rel"
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
    ament-cmake-copyright \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-flake8 \
    ament-cmake-lint-cmake \
    ament-cmake-pep257 \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
