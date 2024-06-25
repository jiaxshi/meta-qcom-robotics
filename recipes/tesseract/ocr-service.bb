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

SRC_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_00039.2/le-qcrobotics-1-0-r1/apps_proc/prebuilt_HY22/ocr-service_1.0_armv8-2a.tar.gz"
SRC_URI[sha256sum] = "293776fe75771cef4126caae204ecc46fcf3a513267b931650fc0ac33c137766"
