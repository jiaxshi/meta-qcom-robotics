inherit ros_distro_${ROS_DISTRO}
inherit ros_component ros_insane_dev_so

SUMMARY = "Library ranger mini robot"
HOMEPAGE = "https://github.com/agilexrobotics/ugv_sdk"
SECTION = "libs"

LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/${LICENSE};md5=89aea4e17d99a7cacdbeed46a0096b10"

ROS_CN = "ugv_sdk"
ROS_BPN = "ugv_sdk"



ROS_BUILD_DEPENDS = " \
    builtin-interfaces \
    rosidl-default-generators \
    geometry-msgs \
    rosidl-adapter \
    rclcpp-components \
    rclcpp \
    rclcpp-action \
    asio-cmake-module \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-pytest \
    ament-cmake-ros \
    ament-cmake-auto-native \
    rosidl-default-generators-native \
"

ROS_EXPORT_DEPENDS = " \
"

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
"

ROS_TEST_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/agilexrobotics/ugv_sdk.git;protocol=https;branch=main;rev=012a9aa02436ffe2ef66f211dd193be7b69902ba"
S = "${WORKDIR}/git"

ROS_BUILD_TYPE = "ament_cmake"


#FILES:${PN}-dev +="/*"

inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package

PACKAGES = "${PN}"

FILES:${PN} = "*"

#lack of so version
do_package_qa[noexec] = "1"
