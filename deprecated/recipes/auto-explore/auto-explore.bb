inherit robotics-qprebuilt-package

LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DESCRIPTION = "Auto explore"

DEPENDS += "opencv curl ${GL_PROVIDER} qcom-fastcv-binaries jpeg"

DEPENDS += " \
    rclcpp \
    sensor-msgs \
    nav-msgs \
    std-msgs \
    geometry-msgs \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
"

PV = "1.0"

QCM6490_SHA256SUM = "3838e9d25e08fb40d32feb9be67b682b1035ea0bf7fcd8f980e6d764db610ea2"
QCS9100_SHA256SUM = "3838e9d25e08fb40d32feb9be67b682b1035ea0bf7fcd8f980e6d764db610ea2"
QCS8300_SHA256SUM = "3838e9d25e08fb40d32feb9be67b682b1035ea0bf7fcd8f980e6d764db610ea2"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"
SRC_URI[qcs9100.sha256sum] = "${QCS9100_SHA256SUM}"
SRC_URI[qcs8300.sha256sum] = "${QCS8300_SHA256SUM}"

SRC_URI = "${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

