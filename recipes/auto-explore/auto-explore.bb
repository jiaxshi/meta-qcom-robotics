inherit robotics-qprebuilt-package

LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DESCRIPTION = "Auto explore"

DEPENDS += "opencv curl adreno fastcv-binaries jpeg"
DEPENDS += "ament-cmake-auto-native ament-cmake-auto rclcpp sensor-msgs nav-msgs"
DEPENDS += "std-msgs geometry-msgs tf2 tf2-ros tf2-geometry-msgs"

SRC_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_00039.2/le-qcrobotics-1-0-r1/apps_proc/prebuilt_HY22/auto-explore_1.0_armv8-2a.tar.gz"
SRC_URI[sha256sum] = "9def0e59401fa0a064852701eb856c085d62ff5f7b3239ca1f4d2c63013ac678"

