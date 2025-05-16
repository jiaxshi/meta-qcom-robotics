inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit ros_insane_dev_so

DESCRIPTION = "Type Adaption with Linux dma-buf"
AUTHOR = "Peng Wang <quic_penwang@quicinc.com>"
ROS_AUTHOR = "Peng Wang"
SECTION = "devel"
LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://LICENSE;md5=65b8cd575e75211d9d4ca8603167da1c"

ROS_CN = "dmabuf_transport"
ROS_BPN = "dmabuf_transport"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    lib-mem-dmabuf \
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
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
    ament-cmake-gtest \
    ament-cmake-copyright \
    ament-cmake-cppcheck \
    ament-cmake-cpplint \
    ament-cmake-flake8 \
    ament-cmake-lint-cmake \
    ament-cmake-pep257 \
    ament-cmake-uncrustify \
    ament-cmake-xmllint \
    ament-cmake-cppcheck-native \
    ament-cmake-flake8-native \
    ament-cmake-pep257-native \
    ament-lint-cmake-native \
    ament-uncrustify-native \
    ament-xmllint-native \
    rclcpp-components \
    pcl-conversions \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/quic-qrb-ros/dmabuf_transport.git;protocol=https;branch=main"
SRCREV = "94016354991c16e75e1311e9ad4b698724886773"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

EXTRA_OECMAKE:append = " -DBUILD_TESTING=ON"

# for qirf
inherit robotics-package
