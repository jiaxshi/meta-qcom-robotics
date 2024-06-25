inherit robotics-qprebuilt-package

DESCRIPTION = "Ocr service msg type"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "rclcpp sensor-msgs std-msgs ament-cmake-native rosidl-default-generators-native"

RDEPENDS:qirf-${PN}  = "rosidl-default-runtime rclpy sensor-msgs"

SRC_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_00039.2/le-qcrobotics-1-0-r1/apps_proc/prebuilt_HY22/ocr-msg_1.0_armv8-2a.tar.gz"
SRC_URI[sha256sum] = "d9aec03ffcec6079559efbc28fe663b9f119e1d4272e091d794bbe16aabc45ad"
