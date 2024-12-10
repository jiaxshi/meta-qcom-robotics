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

SRC_URI = "https://${ROBOT_PBT_ARTIFACTORY}/${ROBOT_PBT_BUILD_ID}/${ROBOT_PBT_BIN_PATH}/${BPN}/${BPN}_${PV}_${ROBOT_PBT_ARCH}.tar.gz"
SRC_URI[sha256sum] = "53dd0171361b621c302e98d5ec529a421a7748f8fccc7d312cab51fd3facd5fc"

do_install:append() {
    rm -rf ${D}/usr/lib/*.so
    rm -rf ${D}/usr/include/*
}

INSANE_SKIP:${PN} += "already-stripped"

