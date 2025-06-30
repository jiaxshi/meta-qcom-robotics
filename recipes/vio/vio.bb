inherit robotics-qprebuilt-package

DESCRIPTION = "VIO"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += "opencv curl ${GL_PROVIDER} qcom-fastcv-binaries jpeg qrb-ros-camera qrb-ros-imu"

DEPENDS += " \
    rclcpp \
    sensor-msgs \
    std-msgs \
    nav-msgs \
    geometry-msgs \
    cv-bridge \
    image-transport \
    rosidl-adapter \
    rclcpp-components \
    rcutils \
"

PV = "1.0"

QCM6490_SHA256SUM = "0bfd2913576215b186fb5e3b48def627019d3f7c13829d1ebeb4165ae24cca74"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"

SRC_URI = "${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
