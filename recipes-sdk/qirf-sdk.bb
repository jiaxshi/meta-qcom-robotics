#License applicable to the recipe file only,  not to the packages installed by this recipe.
LICENSE = "BSD-3-Clause-Clear"

inherit fsdk-base fsdk-package

# The name and version of qirf SDK artifact
SDK_PN = "qirf-sdk"
PV = "2.1.0"

# The path infos of qirf content
TOOLCHAIN_PATH = "${TOPDIR}/SDK"
SETUP_PATH = "${FILE_DIRNAME}/files/qirf-setup.sh \
              ${FILE_DIRNAME}/files/*install.sh"

PKG_LISTS = " \
  qirf-librealsense2_2.54.2-r0_armv8-2a.ipk \
  ${@bb.utils.contains('DISTRO_FEATURES', 'ros2-humble', ' \
  qirf-rplidar-ros2_2.1.2-1-r0_armv8-2a.ipk \
  qirf-realsense2-camera_4.51.1-1-r0_armv8-2a.ipk \
  qirf-realsense2-camera-msgs_4.51.1-1-r0_armv8-2a.ipk \
  qirf-nav2-bringup_1.1.5-1-r0_armv8-2a.ipk \
  qirf-qrb-ros-imu_1.0-r0_armv8-2a.ipk \
  qirf-qrb-ros-camera_0.1-r0_armv8-2a.ipk \
  qirf-qrb-ros-battery_0.1-r0_armv8-2a.ipk \
  qirf-auto-explore_1.0-r0_armv8-2a.ipk \
  qirf-mono-vslam_1.0-r0_armv8-2a.ipk \
  qirf-depth-vslam_1.0-r0_armv8-2a.ipk \
  qirf-voxel-map_1.0-r0_armv8-2a.ipk \
  qirf-follow-me_1.0-r0_armv8-2a.ipk \
  qirf-ocr-msg_1.0-r0_armv8-2a.ipk \
  qirf-ocr-service_1.0-r0_armv8-2a.ipk \
  qirf-vio_1.0-r0_armv8-2a.ipk \
  ', '', d)} \
"

# Add the runtime dependence for qirf sdk
RDEPENDS:qirf-sdk = " \
    qirf-librealsense2 \
    qirf-rplidar-ros2 \
    qirf-realsense2-camera \
    qirf-realsense2-camera-msgs \
    qirf-nav2-bringup \
    qirf-qrb-ros-imu \
    qirf-qrb-ros-camera \
    qirf-qrb-ros-battery \
    qirf-auto-explore \
    qirf-follow-me \
    qirf-mono-vslam \
    qirf-depth-vslam \
    qirf-voxel-map \
    qirf-ocr-service \
    qirf-vio \
"

# Add the dependence for generate sdk
do_generate_robotics_sdk[depends] += "librealsense2:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "rplidar-ros2:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "realsense2-camera:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "realsense2-camera-msgs:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "nav2-bringup:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "qrb-ros-imu:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "qrb-ros-camera:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "qrb-ros-battery:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "auto-explore:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "mono-vslam:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "depth-vslam:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "voxel-map:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "follow-me:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "ocr-msg:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "ocr-service:do_package_write_ipk"
do_generate_robotics_sdk[depends] += "vio:do_package_write_ipk"
