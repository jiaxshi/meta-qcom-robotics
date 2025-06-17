inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "QRB ROS colorspace convert on Qualcomm robotics platforms"
AUTHOR = "Vito Wang <quic_wantao@quicinc.com>"
ROS_AUTHOR = "Vito Wang"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86fcc2294062130b497ba0ffff9f82fc"

ROS_CN = "qrb_ros_colorspace_convert"
ROS_BPN = "qrb_ros_colorspace_convert"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rclcpp-components \
    sensor-msgs \
    qrb-colorspace-convert-lib \
    qrb-ros-transport-image-type \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
    ament-cmake-ros-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rclcpp \
    sensor-msgs \
    qrb-colorspace-convert-lib \
    qrb-ros-transport-image-type \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_samples.git;protocol=https;branch=main;subpath=platform/sample_colorspace_convert"
SRCREV = "c09688ac8283dedf9c47636d71cfb06742b995e5"
S = "${WORKDIR}/sample_colorspace_convert/qrb_ros_colorspace_convert"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package
