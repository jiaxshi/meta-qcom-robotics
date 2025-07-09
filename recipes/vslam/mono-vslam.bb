inherit robotics-qprebuilt-package

DESCRIPTION = "Mono vslam"
LICENSE          = "Qualcomm-Technologies-Inc.-Proprietary"
LIC_FILES_CHKSUM = "file://${QCOM_COMMON_LICENSE_DIR}/${LICENSE};md5=58d50a3d36f27f1a1e6089308a49b403"

DEPENDS += " librealsense2 opencv curl ${GL_PROVIDER} qcom-fastcv-binaries jpeg sensor-client"

DEPENDS = " \
    rclcpp \
    sensor-msgs \
    nav-msgs \
    std-msgs \
    geometry-msgs \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    cv-bridge \
    image-transport \
    rosidl-adapter \
"

PV = "1.0"

QCM6490_SHA256SUM = "7d978f6890256eb46edb24154cfa09686b727ef46b963983f6dd939fbe31d8b7"

SRC_URI[qcm6490.sha256sum] = "${QCM6490_SHA256SUM}"

SRC_URI = "${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}_${PV}_${PBT_ARCH}.tar.gz;name=${PBT_ARCH}"

do_install:append() {
    rm -rf ${D}/usr/lib/*.so
    rm -rf ${D}/usr/include/*
}

INSANE_SKIP:${PN} += "already-stripped"

