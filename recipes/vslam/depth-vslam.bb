inherit robotics-qprebuilt-package

DESCRIPTION = "Depth vslam"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += " librealsense2 opencv curl ${GL_PROVIDER} qcom-fastcv-binaries jpeg sensor-client"

DEPENDS += "ament-cmake-auto-native ament-cmake-auto rclcpp sensor-msgs nav-msgs std-msgs"
DEPENDS += "geometry-msgs tf2 tf2-ros tf2-geometry-msgs cv-bridge image-transport rosidl-adapter"

PV = "1.0"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "0547fe37aba397d0550c8c64730afd2a9e71cd2ddfa9b1cb3621a996ab1efc37"

