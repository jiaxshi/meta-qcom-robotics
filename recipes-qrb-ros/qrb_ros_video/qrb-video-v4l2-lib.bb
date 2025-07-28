inherit pkgconfig cmake

DESCRIPTION = "A hardware accelerated library implementing video encoding and decoding based on V4L2."
AUTHOR = "Jean Xiao <quic_jianxiao@quicinc.com>"
ROS_AUTHOR = "Jean Xiao"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=86fcc2294062130b497ba0ffff9f82fc"

PV = "0.1"

DEPENDS = "glog gflags"

SRC_URI = "git://github.com/quic-qrb-ros/qrb_ros_video.git;protocol=https;branch=main"
SRCREV = "d239b0de931c280b3ff3d6235f14f1230bd6a9cd"
S = "${WORKDIR}/git/qrb_video_v4l2_lib"

EXTRA_OECMAKE:append = " -DBUILD_TESTING=OFF"

FILES:${PN}-dev += "${datadir}"
