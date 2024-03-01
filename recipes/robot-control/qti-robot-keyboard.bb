inherit ros_distro_humble
inherit ros_component

DESCRIPTION = "The QCOM AMR Keyboard control"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

RDEPENDS:{PN} += " \
    geometry-msgs \
    rclpy \
"

FILESPATH =+ "${WORKSPACE}/robotics/robotics-oss:"
SRC_URI = "file://robot-control/qti_robot_keyboard"
S = "${WORKDIR}/robot-control/qti_robot_keyboard"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE}

FILES:${PN}:prepend = "${datadir}/qti_robot_keyboard"
FILES:${PN} += "${libdir}/*"
FILES:${PN} += "${bindir}/*"

INSANE_SKIP:${PN} += "installed-vs-shipped"
