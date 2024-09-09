inherit robotics-package

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

ROS_BRANCH = "branch=ros2-master"
SRC_URI = "git://github.com/IntelRealSense/realsense-ros.git;${ROS_BRANCH};protocol=https"
SRCREV = "87522c66b95ffd869a14f4f263c0ab68bf7cb4f3"
S = "${WORKDIR}/git/realsense2_camera"
