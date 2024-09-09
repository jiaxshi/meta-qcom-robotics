inherit robotics-package

DEPENDS += "sensor-msgs"

ROS_BRANCH = "branch=ros2-master"
SRC_URI = "git://github.com/IntelRealSense/realsense-ros.git;${ROS_BRANCH};protocol=https"
SRCREV = "8a86cb88a428bdefa204759c899b84adc81606ae"
S = "${WORKDIR}/git/realsense2_camera_msgs"
