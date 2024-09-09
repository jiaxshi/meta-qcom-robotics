inherit robotics-qprebuilt-package

DESCRIPTION = "Ocr ros2 node"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "rclcpp sensor-msgs qirf-ocr-msg ament-cmake-native python-cmake-module-native rclpy"

RDEPENDS:qirf-${PN} = "\
    rclpy \
    rpyutils \
    sensor-msgs \
    python3-pytesseract \
    python3-numpy \
    tesseract \
    tesseract-lang \
    qirf-ocr-msg \
"

PV = "1.0"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "b31959cf4e835d97714430006576193fdbe07dce86e3f699fcde0f4897588269"
