#License applicable to the recipe file only,  not to the packages installed by this recipe.
LICENSE = "BSD-3-Clause-Clear"

inherit fsdk-base fsdk-package packagegroup

TARGET_SDK = "robotics"

SDK_PN = "${TARGET_SDK}-sdk"
PV = "2.0.0"

S = "${WORKDIR}"

# ROBOTICS_ARCH default with PACKAGE_ARCH, debain : aarch64 -> arm64
# IMAGE_PKGTYPE : debian : deb , yocto default : ipk
# Add the packages into robotics sdk

FUNCTION = " "
BASIC_DEPENDENCY = " "

FUNCTION:append:qcm6490:qcom-custom-bsp = " \
${@bb.utils.contains('DISTRO_FEATURES', 'ros2-humble', ' \
    librealsense2 \
    rplidar-ros2 \
    realsense2-camera \
    realsense2-camera-msgs \
    qrb-ros-imu \
    qrb-ros-camera \
    libqrc-udriver \
    ocr-service \
    ocr-msg \
    nav2-bringup \
    qrb-ros-battery \
    qti-robot-urdf \
    qti-robot-keyboard \
    qti-robot-amr-ctrl \
    orbbec-description \
    orbbec-camera-msgs \
    orbbec-camera \
    auto-explore \
    mono-vslam \
    depth-vslam \
    voxel-map \
    follow-me \
    vio \
    ', '', d)} \
"
BASIC_DEPENDENCY:append:qcm6490:qcom-custom-bsp = " \
    camxapi-kt-dev \
    camxapi-kt \
    sensor-client \
    battery-client \
    battery-service \
    syslog-plumber \
    qcom-camera-server \
    ${GL_PROVIDER} \
    qcom-fastcv-binaries \
"

FUNCTION:append:qcs9100:qcom-custom-bsp = " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'ros2-humble', ' \
    orbbec-description \
    orbbec-camera-msgs \
    orbbec-camera \
    rplidar-ros2 \
    ', '', d)} \
"
FUNCTION:append:qcs9100 = " \
    lib-mem-dmabuf \
    qrb-sensor-client \
    qrb-ros-transport-image-type \
    qrb-ros-transport-imu-type \
    dmabuf-transport \
    qrb-ros-system-monitor \
    qrb-ros-system-monitor-interfaces \
"

#basic dependnecy for sdk buildtime and runtime
BASIC_DEPENDENCY += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'ros2-humble', ' \
    ament-cmake \
    ament-cmake-auto \
    ament-cmake-core \
    ament-cmake-export-definitions \
    ament-cmake-export-dependencies \
    ament-cmake-export-include-directories \
    ament-cmake-export-interfaces \
    ament-cmake-export-libraries \
    ament-cmake-export-link-flags \
    ament-cmake-export-targets \
    ament-cmake-gen-version-h \
    ament-cmake-gmock \
    ament-cmake-google-benchmark \
    ament-cmake-gtest \
    ament-cmake-include-directories \
    ament-cmake-libraries \
    ament-cmake-nose \
    ament-cmake-pytest \
    ament-cmake-python \
    ament-cmake-ros \
    ament-cmake-target-dependencies \
    ament-cmake-test \
    ament-cmake-version \
    ament-lint-auto \
    foonathan-memory \
    foonathan-memory-dev \
    foonathan-memory-staticdev \
    opencv \
    opencv-staticdev \
    image-transport \
    yaml-cpp \
    camera-info-manager \
    rclcpp \
    sensor-msgs \
    nav-msgs \
    std-msgs \
    geometry-msgs \
    tf2 \
    tf2-ros \
    tf2-geometry-msgs \
    cv-bridge \
    rosidl-adapter \
    ncnn \
    rclcpp-components \
    rcutils \
    libgpiod \
    xacro \
    robot-state-publisher \
    urdf-parser-plugin \
    vision-msgs \
    ', '', d)} \
"

RDEPENDS:${PN} = "${FUNCTION} ${BASIC_DEPENDENCY}"

do_package_qa[noexec] = "1"
