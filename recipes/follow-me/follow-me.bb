inherit robotics-qprebuilt-package

DESCRIPTION = "Follow me"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "opencv jpeg tiff jsoncpp librealsense2 ncnn"

DEPENDS += " \
    ament-cmake-auto-native \
    rclcpp \
    rosidl-adapter \
    rclcpp-components \
    geometry-msgs \
    sensor-msgs \
    nav-msgs \
    std-msgs \
    tf2 \
    tf2-ros \
    image-transport \
    cv-bridge \
    rcl-logging-noop \
"

PV = "1.0"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[qcm6490.sha256sum] = "8b3f1d4bb9539e0e881b77633b2f728b205551f5006f62893bf022ba03a6cd4f"
SRC_URI[qcs9100.sha256sum] = "5218fd970f31f1c7af6c46c67fe14205af46582883fa00f406ecc7f40a591b08"
SRC_URI[qcs8300.sha256sum] = "f94676fb54bd2724895f3091c12577218b1e5048c7fb20b51a82b6bd9aaeefbd"
