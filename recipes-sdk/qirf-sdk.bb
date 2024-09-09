#License applicable to the recipe file only,  not to the packages installed by this recipe.
LICENSE = "BSD-3-Clause-Clear"

inherit fsdk-base fsdk-package

# The name and version of qirf SDK artifact
SDK_PN = "qirf-sdk"
PV = "2.1.1"

# The path infos of qirf content
SETUP_PATH = "${FILE_DIRNAME}/files/qirf-setup.sh \
              ${FILE_DIRNAME}/files/*install.sh"

SRC_URI += "file://qirf-setup.sh"
FILES:${PN}  = "/opt/qcom/usr/share/*"
S = "${WORKDIR}"
FUNCTION = ""

do_install(){
    install -d ${D}/opt/qcom/usr/share/
    cp ${S}/qirf-setup.sh ${D}/opt/qcom/usr/share/
}

# ROBOTICS_ARCH default with PACKAGE_ARCH, debain : aarch64 -> arm64
# IMAGE_PKGTYPE : debian : deb , yocto default : ipk
# Add the packages into qirf sdk
FUNCTION:append:qcm6490:qcom-custom-bsp = " \
    qirf-librealsense2 \
    qirf-rplidar-ros2 \
    qirf-realsense2-camera \
    qirf-realsense2-camera-msgs \
    qirf-qrb-ros-imu \
    qirf-qrb-ros-camera \
    qirf-libqrc-udriver \
    qirf-nav2-bringup \
    qirf-qrb-ros-battery \
    qirf-qti-robot-urdf \
    qirf-qti-robot-keyboard \
    qirf-qti-robot-amr-ctrl \
    qirf-auto-explore \
    qirf-follow-me \
    qirf-mono-vslam \
    qirf-depth-vslam \
    qirf-voxel-map \
    qirf-ocr-service \
    qirf-ocr-msg \
    qirf-vio \
"

RDEPENDS:qirf-sdk = "${FUNCTION}"
