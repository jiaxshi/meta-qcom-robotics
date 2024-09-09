inherit ros_distro_humble
inherit ros_component robotics-package

LICENSE  = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRC_URI   +=  "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robot-camera.git;protocol=https;rev=54f600a227b42ee9bda0cae9d97c72dff4f6d59f;branch=robotics.qclinux.1.0.r1-rel"
S         =  "${WORKDIR}/git/qrb_ros_camera/"

# Dependencies
CAMERA_ROS2_NODE_DEPENDS = " \
    qcom-camera-server \
    dmabuf-transport \
"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    rclcpp-components \
    cv-bridge \
    yaml-cpp \
    glib-2.0 \
    image-transport \
    camera-info-manager \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    qcom-camera-server \
    dmabuf-transport \
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

PACKAGES = "qirf-${PN}"

ROS_BUILD_TYPE = "ament_cmake"
inherit ros_${ROS_BUILD_TYPE}
