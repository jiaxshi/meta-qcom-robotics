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

FUNCTION:append = " \
    lib-mem-dmabuf \
    qrb-sensor-client \
    qrb-ros-transport-image-type \
    qrb-ros-transport-imu-type \
    qrb-ros-transport-point-cloud2-type \
    qrb-colorspace-convert-lib \
    qrb-ros-colorspace-convert \
    dmabuf-transport \
    qrb-ros-system-monitor \
    qrb-ros-system-monitor-interfaces \
    rplidar-ros2 \
"
FUNCTION:append:qcom-custom-bsp = " \
    ocr-service \
    ocr-msg \
    libqrc-udriver \
    qrb-ros-battery \
    orbbec-description \
    orbbec-camera-msgs \
    orbbec-camera \
    qti-robot-urdf \
    qti-robot-keyboard \
    qti-robot-amr-ctrl \
    qrb-ros-camera \
"
FUNCTION:remove:qcom-custom-bsp = " nav2-bringup qrb-ros-camera realsense2-camera realsense2-camera-msgs librealsense2 "
FUNCTION:append:qcom-custom-bsp:qcm6490 = "qrb-ros-imu"

#basic dependnecy for sdk buildtime and runtime
BASIC_DEPENDENCY += " \
    foonathan-memory \
    foonathan-memory-dev \
    foonathan-memory-staticdev \
    opencv \
    opencv-staticdev \
    yaml-cpp \
    zbar \
    ncnn \
    libgpiod \
    graphviz \
    ceres-solver \
"
BASIC_DEPENDENCY:append:qcom-custom-bsp = " \
    sensor-client \
    battery-client \
    battery-service \
    syslog-plumber \
    qcom-camera-server \
    ${GL_PROVIDER} \
    qcom-fastcv-binaries \
"

RDEPENDS:${PN} = "${FUNCTION} ${BASIC_DEPENDENCY}"

do_package_qa[noexec] = "1"
