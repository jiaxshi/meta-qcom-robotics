inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "The QCOM AMR Keyboard control"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

RDEPENDS:{PN} += " \
    geometry-msgs \
    rclpy \
"

SRC_URI +=  "git://git.codelinaro.org/clo/le/platform/vendor/qcom-opensource/robotics-oss.git;protocol=https;rev=a5b0e54e888928a3b410bbddb9cd446023e4ab7e;branch=robotics.qclinux.1.0.r1-rel"
S =  "${WORKDIR}/git/robot-control/qti_robot_keyboard/"

ROS_BUILD_TYPE = "ament_python"

inherit ros_${ROS_BUILD_TYPE} robotics-package

FILES:${PN}:prepend = "${datadir}/qti_robot_keyboard"
FILES:${PN} += "${libdir}/*"
FILES:${PN} += "${bindir}/*"

INSANE_SKIP:${PN} += "installed-vs-shipped"
