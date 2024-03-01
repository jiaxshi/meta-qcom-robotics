inherit robotics-package
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Modify-realsense2-camera-CMakeLists.txt.patch"
