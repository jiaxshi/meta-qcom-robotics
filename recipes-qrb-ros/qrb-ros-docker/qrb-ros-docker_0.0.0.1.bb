inherit ros_distro_${ROS_DISTRO} pkgconfig
inherit robotics-package

DESCRIPTION = "Provide the docker image for running and developing QRB ROS Jazzy packages"
AUTHOR = "Na Song <quic_nasong@quicinc.com>"
ROS_AUTHOR = "Na Song"
SECTION = "devel"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

ROS_CN = "qrb_ros_docker"
ROS_BPN = "qrb_ros_docker"

SRC_URI = "git://github.com/qualcomm-qrb-ros/qrb_ros_docker.git;protocol=https;branch=main"
SRCREV = "2af941b7b17feabc5d200c73cfa7c05569e24a6e"
S = "${WORKDIR}/git/"

do_install() {
    install -d ${D}${datadir}/qrb_ros_docker/dockerfile
    install -d ${D}${datadir}/qrb_ros_docker/scripts

    cp -r ${S}/dockerfile/* ${D}${datadir}/qrb_ros_docker/dockerfile/
    cp -r ${S}/scripts/* ${D}${datadir}/qrb_ros_docker/scripts/
}

FILES_${PN} += "${datadir}/qrb_ros_docker/dockerfile \
                ${datadir}/qrb_ros_docker/scripts"

inherit robotics-package
