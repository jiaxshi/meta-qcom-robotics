#License applicable to the recipe file only,  not to the packages installed by this recipe.
LICENSE = "BSD-3-Clause-Clear"

inherit fsdk-base fsdk-package

# The path infos of qirf content
TOOLCHAIN_PATH = "${TOPDIR}/SDK"
SETUP_PATH = "${FILE_DIRNAME}/files/setup.sh \
              ${FILE_DIRNAME}/files/*install.sh"

PKG_LISTS = " \
  qirf-librealsense2_2.54.2-r0_armv8-2a.ipk \
  ${@bb.utils.contains('DISTRO_FEATURES', 'ros2-humble', ' \
  qirf-rplidar-ros2_2.1.2-1-r0_armv8-2a.ipk \
  qirf-realsense2-camera_4.51.1-1-r0_armv8-2a.ipk \
  qirf-realsense2-camera-msgs_4.51.1-1-r0_armv8-2a.ipk \
  qirf-nav2-bringup_1.1.5-1-r0_armv8-2a.ipk \
  qirf-qrb-ros-imu_1.0-r0_armv8-2a.ipk \
  ', '', d)} \
"

# The name and version of qirf SDK artifact
SDK_PN = "qirf-sdk"
PV = "2.0.0"

