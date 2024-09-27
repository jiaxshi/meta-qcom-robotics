inherit robotics-qprebuilt-package

DESCRIPTION = "Follow me"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "opencv jpeg tiff jsoncpp librealsense2 ncnn"
DEPENDS += "ament-cmake-auto-native ament-cmake-auto rclcpp rosidl-adapter rclcpp-components geometry-msgs sensor-msgs"
DEPENDS += "nav-msgs std-msgs tf2 tf2-ros image-transport cv-bridge rcl-logging-noop"

PV = "1.0"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "84166e9a0993f1ac6ea1852eb7f545c97ce1a93189119bf92102e984d4c7186f"
