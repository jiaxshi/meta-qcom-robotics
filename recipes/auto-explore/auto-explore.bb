inherit robotics-qprebuilt-package

LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DESCRIPTION = "Auto explore"

DEPENDS += "opencv curl ${GL_PROVIDER} qcom-fastcv-binaries jpeg"
DEPENDS += "ament-cmake-auto-native ament-cmake-auto rclcpp sensor-msgs nav-msgs"
DEPENDS += "std-msgs geometry-msgs tf2 tf2-ros tf2-geometry-msgs"

PV = "1.0"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "8723e33099dc7b949d43bd7b52e7674c1ad8cb8b9d11f1ec5305078ae4467c44"

