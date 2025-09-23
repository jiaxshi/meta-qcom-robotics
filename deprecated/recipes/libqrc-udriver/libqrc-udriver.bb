inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "Library for the qcom-robotic-controller user driver"
SECTION = "libs"
LICENSE          = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/BSD-3-Clause-Clear;md5=7a434440b651f4a472ca93716d01033a"

# ros build time dependency start
ROS_BUILD_DEPENDS = " \
    libgpiod \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""
ROS_BUILDTOOL_EXPORT_DEPENDS = ""
# build time dependency end

# ros runtime dependency start
ROS_EXEC_DEPENDS = " \
    libgpiod \
"
# ros runtime dependency end

ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/qualcomm-qrb-ros/libqrc.git;protocol=https;branch=main"
S = "${WORKDIR}/git/libqrc-udriver"

SRCREV = "4a705a493009b22ff1d524b7706c122d4e9f9f97"

# define the build type : ament_cmake, ament_python, cmake etc...
ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
inherit robotics-package

def config_hardware_flag(d):
    QRC_HARDWARE = d.getVar('MACHINE')
    if QRC_HARDWARE == 'qcs6490-rb3gen2-vision-kit':
        return "-DQRC_RB3=1"
    elif QRC_HARDWARE == 'qcs9075-rb8-core-kit' or QRC_HARDWARE == 'qcs9075-iq-9075-evk':
        return "-DQRC_RB8=1"
    else :
        return "-DQRC_RB5=1"
EXTRA_OECMAKE += "${@config_hardware_flag(d)}"
