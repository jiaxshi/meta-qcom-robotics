inherit ros_distro_${ROS_DISTRO}
inherit ros_component

DESCRIPTION = "The library to convert color space base on opengles"
AUTHOR = "Vito Wang <quic_wantao@quicinc.com>"
ROS_AUTHOR = "Vito Wang"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86fcc2294062130b497ba0ffff9f82fc"

ROS_CN = "qrb_colorspace_convert_lib"
ROS_BPN = "qrb_colorspace_convert_lib"

ROS_BUILD_DEPENDS = " \
    virtual/egl \
    virtual/libgles2 \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-auto-native \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = ""

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_samples.git;protocol=https;branch=main;subpath=platform/sample_colorspace_convert"
SRCREV = "c09688ac8283dedf9c47636d71cfb06742b995e5"
S = "${WORKDIR}/sample_colorspace_convert/qrb_colorspace_convert_lib"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

EXTRA_OECMAKE:append = " -DBUILD_TESTING=OFF"

inherit robotics-package
