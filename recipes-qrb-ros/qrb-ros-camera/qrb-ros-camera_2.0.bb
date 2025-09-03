inherit ros_distro_${ROS_DISTRO}
inherit ros_component robotics-package pkgconfig

LICENSE  = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_camera.git;protocol=https;branch=main;subpath=qrb_ros_camera"
SRCREV = "8f9598e0da29fb02af91f841a25a2cc7c1018601"
S = "${WORKDIR}/qrb_ros_camera"

# Dependencies
CAMERA_ROS2_NODE_DEPENDS = " \
    qrb-ros-transport-image-type \
    qrb-camera \
"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    rclcpp-components \
    cv-bridge \
    yaml-cpp \
    image-transport \
    camera-info-manager \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

DEPENDS = "${CAMERA_ROS2_NODE_DEPENDS} ${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    qrb-ros-transport-image-type \
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
"
ROS_EXPORT_DEPENDS = " \
    rclcpp \
"
ROS_BUILDTOOL_EXPORT_DEPENDS = ""

DEPENDS = "${CAMERA_ROS2_NODE_DEPENDS} ${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS} ${ROS_TEST_DEPENDS}"

EXTRA_OECMAKE  += "-DSYSROOT_INCDIR=${RECIPE_SYSROOT}/usr/include"
EXTRA_OECMAKE  += "-DSYSROOT_LIBDIR=${RECIPE_SYSROOT}/usr/lib"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}

FILES:${PN} += " \
    ${pkg_dest}${includedir} "

EXTRA_OECMAKE:append = " -DBUILD_TESTING=ON"

