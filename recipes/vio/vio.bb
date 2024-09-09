inherit robotics-qprebuilt-package

DESCRIPTION = "VIO"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "opencv curl ${GL_PROVIDER} qcom-fastcv-binaries jpeg qrb-ros-camera qrb-ros-imu"

DEPENDS += "ament-cmake-auto-native ament-cmake-auto rclcpp sensor-msgs nav-msgs std-msgs"
DEPENDS += "geometry-msgs cv-bridge image-transport rclcpp-components rosidl-adapter rcutils"

PV = "1.0"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "c019535e3474f6ada15995eeaf2806ad1684ceaf401bb570a67f81028f1e37a3"
