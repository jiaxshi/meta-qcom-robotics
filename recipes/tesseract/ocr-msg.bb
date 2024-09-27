inherit robotics-qprebuilt-package

DESCRIPTION = "Ocr service msg type"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "rclcpp sensor-msgs std-msgs ament-cmake-native rosidl-default-generators-native"

RDEPENDS:qirf-${PN}  = "rosidl-default-runtime rclpy sensor-msgs"

PV = "1.0"

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "151eacc324e82d52d1feb2cbdcdd0f094e8196bda8e2f53c0aab2fffb1cfee0e"
