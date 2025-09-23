inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit pkgconfig

DESCRIPTION = "Orbbec Camera package"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

ROS_CN = "orbbec_camera"
ROS_BPN = "orbbec_camera"

SRC_URI = "git://github.com/orbbec/OrbbecSDK_ROS2.git;protocol=https;branch=v2-main \
           file://0001-Fix-orbbec-camera-compilation-error.patch \
"

SRCREV = "0a22657f77d783650bffa446b4a1a6395b04bf76"
S = "${WORKDIR}/git/orbbec_camera"

PATCH_DIR = "${WORKDIR}/git/"

do_patch() {
    cd ${PATCH_DIR}
    patch -p1 < ${WORKDIR}/0001-Fix-orbbec-camera-compilation-error.patch
}

ROS_BUILD_DEPENDS = " \
    rosidl-default-generators-native \
    rosidl-default-runtime \
    ament-index-cpp \
    image-transport \
    image-publisher \
    rclcpp-components \
    cv-bridge \
    camera-info-manager \
    orbbec-camera-msgs \
    builtin-interfaces \
    rclcpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-ros \
    tf2-sensor-msgs \
    tf2-eigen \
    tf2-msgs \
    diagnostic-updater \
    diagnostic-msgs \
    backward-ros \
    eigen3-cmake-module-native \
    nlohmann-json \
    gflags \
    glog \
    opencv \
    libeigen \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

ROS_EXEC_DEPENDS = " \
    rosidl-default-runtime \
    ament-index-cpp \
    image-transport \
    image-publisher \
    rclcpp-components \
    cv-bridge \
    camera-info-manager \
    orbbec-camera-msgs \
    builtin-interfaces \
    rclcpp \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-ros \
    tf2-sensor-msgs \
    tf2-eigen \
    tf2-msgs \
    diagnostic-updater \
    diagnostic-msgs \
    nlohmann-json \
    backward-ros \
"

NON_ROS_EXEC_DEPENDS = " \
    gflags \
    glog \
    opencv \
    libeigen \
    nlohmann-json \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS} ${NON_ROS_EXEC_DEPENDS}"

FILES:${PN}:prepend = "${datadir}/orbbec_camera"
FILES:${PN} += "${libdir}/*"

ROS_BUILD_TYPE = "ament_cmake"

INSANE_SKIP:${PN} += "already-stripped"

inherit ros_${ROS_BUILD_TYPE} robotics-package
INSANE_SKIP:${PN} += "ldflags rpaths file-rdeps"
