inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit ros_insane_dev_so
inherit pkgconfig

DESCRIPTION = "A ROS package which provides video hardware acceleration capabilities on Qualcomm platform"
AUTHOR = "Jean Xiao <quic_jianxiao@quicinc.com>"
ROS_AUTHOR = "Jean Xiao"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86fcc2294062130b497ba0ffff9f82fc"

ROS_CN = "qrb_ros_video"
ROS_BPN = "qrb_ros_video"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    lib-mem-dmabuf \
    qrb-ros-transport-image-type \
    qrb-video-v4l2-lib \
    gstreamer1.0-plugins-base \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = " \
    rclcpp \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    lib-mem-dmabuf \
    qrb-ros-transport-image-type \
    qrb-video-v4l2-lib \
    gstreamer1.0-plugins-base \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
    ament-cmake-copyright \
    ament-cmake-cpplint \
    ament-cmake-lint-cmake \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
    ament-cmake-cppcheck-native \
    ament-cmake-flake8-native \
    ament-cmake-pep257-native \
    ament-lint-cmake-native \
    ament-uncrustify-native \
    ament-xmllint-native \
    rclcpp-components \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/quic-qrb-ros/qrb_ros_video.git;protocol=https;branch=main"
SRCREV = "53d766df5319ee53a6579a6228f5ff1c2a30a962"
S = "${WORKDIR}/git/qrb_ros_video"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

EXTRA_OECMAKE:append = " -DBUILD_TESTING=OFF"

inherit robotics-package
