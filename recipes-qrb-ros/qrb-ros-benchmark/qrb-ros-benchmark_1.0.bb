inherit ros_distro_${ROS_DISTRO}
inherit ros_component
inherit ros_insane_dev_so

DESCRIPTION = "QRB ROS benchmark"
LICENSE  = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=550794465ba0ec5312d6919e203a55f9"

ROS_CN = "qrb_ros_benchmark"
ROS_BPN = "qrb_ros_benchmark"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    ros2-benchmark \
    ros2-benchmark-interfaces \
    rclcpp-components \
    sensor-msgs \
    qrb-ros-transport-image-type\
    qrb-ros-transport-imu-type\
    qrb-ros-transport-point-cloud2-type\
    dmabuf-transport \
    qrb-ros-tensor-list-msgs \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-lint-auto \
"

ROS_EXPORT_DEPENDS = ""

ROS_BUILDTOOL_EXPORT_DEPENDS = ""

ROS_EXEC_DEPENDS = " \
    rosidl-default-runtime \
    ament-cmake-auto \
"

ROS_TEST_DEPENDS = " \
    ament-lint-auto \
    ament-lint-common \
"

DEPENDS = "${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"
DEPENDS += "${ROS_EXPORT_DEPENDS} ${ROS_BUILDTOOL_EXPORT_DEPENDS}"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"
RDEPENDS:${PN} += " \
    qrb-ros-transport-image-type\
    qrb-ros-transport-imu-type\
    qrb-ros-transport-point-cloud2-type\
"
RDEPENDS:${PN} += "dmabuf-transport"


SRC_URI = "git://github.com/quic-qrb-ros/qrb_ros_transport.git;protocol=https;branch=main"
SRCREV = "0cac37f4c8339fa5cc69e732adb4774b44ce51c2"
S = "${WORKDIR}/qrb_ros_benchmark/"


ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

inherit robotics-package
