inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "The AMR bringup ROS2 package"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

DEPENDS += " \
    ament-cmake-native \
    ament-cmake \
    std-msgs \
    rosidl-default-generators \
    geometry-msgs \
    rclcpp \
    rclcpp-action \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    rclpy \
    joint-state-publisher \
    nav2-msgs \
    nav-msgs \
    libqrc-udriver \
    rosidl-core-generators \
"

RDEPENDS:${PN} += " \
    ament-cmake \
    std-msgs \
    rosidl-default-generators \
    geometry-msgs \
    rclcpp \
    rclcpp-action \
    sensor-msgs \
    std-msgs \
    std-srvs \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    rclpy \
    joint-state-publisher \
    nav2-msgs \
    nav-msgs \
    libqrc-udriver \
    rosidl-core-generators \
"

SRCPROJECT = "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robotics-oss.git;protocol=https"
SRCBRANCH  = "robotics.qclinux.1.0.r1-rel"
SRCREV     = "ce63524de87702fc12c6bcbad68e47daccdcc146"

SRC_URI +=   "${SRCPROJECT};branch=${SRCBRANCH}"

# SRC_URI +=  "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robotics-oss.git;protocol=https;rev=ce63524de87702fc12c6bcbad68e47daccdcc146;branch=robotics.qclinux.1.0.r1-rel"
S =  "${WORKDIR}/git/robot-control/qti_robot_amr_ctrl/"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE} robotics-package

FILES:${PN}:prepend = "${datadir}/qti_robot_amr_ctrl"
FILES:${PN} += "${libdir}/*"
FILES:${PN} += "${bindir}/*"

INSANE_SKIP:${PN} += "installed-vs-shipped"
