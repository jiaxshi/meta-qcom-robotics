inherit robotics-qprebuilt-package

DESCRIPTION = "Depth vslam"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += " librealsense2 opencv curl adreno fastcv-binaries jpeg sensor-client"

DEPENDS += "ament-cmake-auto-native ament-cmake-auto rclcpp sensor-msgs nav-msgs std-msgs"
DEPENDS += "geometry-msgs tf2 tf2-ros tf2-geometry-msgs cv-bridge image-transport rosidl-adapter"

SRC_URI = "https://artifacts.codelinaro.org/artifactory/qli-ci/software/chip/qualcomm_linux-spf-1-0/qualcomm-linux-spf-1-0_test_device_public/r1.0_00037.0/le-qcrobotics-1-0-r1/apps_proc/prebuilt_HY22/depth-vslam_1.0_armv8-2a.tar.gz"
SRC_URI[sha256sum] = "673dae43e15e98b0fca96b427d91ce09f3cdfbd9a6544912a4dde59ad2f1901d"

