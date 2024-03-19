inherit qprebuilt robotics-package

DESCRIPTION = "Mono vslam"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += " librealsense2 opencv curl adreno fastcv-binaries jpeg sensor-client"

DEPENDS += "ament-cmake-native ament-cmake rclcpp sensor-msgs nav-msgs std-msgs"
DEPENDS += "geometry-msgs tf2 tf2-ros tf2-geometry-msgs cv-bridge image-transport rosidl-adapter"

SRCREV = "0c22da8226ba064d657e44cc868f06bce274c948"

SRC_URI = "git://qpm-git.qualcomm.com/home2/git/qualcomm/qualcomm-linux-spf-1-0_test_device_roboapilnx.git;protocol=https;branch=master"

PREBUILT_TARBALL = "mono-vslam_1.0_armv8-2a.tar.gz"

S = "${WORKDIR}/git/LE.QCROBOTICS.1.0.r1/apps_proc/prebuilt_HY22"

PACKAGES = "qirf-${PN}"
