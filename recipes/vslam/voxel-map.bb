inherit robotics-qprebuilt-package

DESCRIPTION = "Voxel map"
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
SRC_URI[sha256sum] = "17cedca79170da30eef267d22d3aa3ad271535681dbb1d591f67bd9cf1dd98c3"

INSANE_SKIP:${PN} += "already-stripped"