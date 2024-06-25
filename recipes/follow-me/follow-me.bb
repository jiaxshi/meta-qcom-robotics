inherit robotics-qprebuilt-package

DESCRIPTION = "Follow me"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "opencv jpeg tiff jsoncpp librealsense2 ncnn"
DEPENDS += "ament-cmake-auto-native ament-cmake-auto rclcpp rosidl-adapter rclcpp-components geometry-msgs sensor-msgs"
DEPENDS += "nav-msgs std-msgs tf2 tf2-ros image-transport cv-bridge rcl-logging-noop"

SRC_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_00039.2/le-qcrobotics-1-0-r1/apps_proc/prebuilt_HY22/follow-me_1.0_armv8-2a.tar.gz"
SRC_URI[sha256sum] = "a0098f0cb01b40236311d78a419a86639d8e0297365b45bcaac63b4bff176a8a"
