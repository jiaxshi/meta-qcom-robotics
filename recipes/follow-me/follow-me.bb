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
SRC_URI[sha256sum] = "97236f3d6f5b8dcf2f82073f1f2870e379d0f26a9c05d33aff9caa9047728ab2"
