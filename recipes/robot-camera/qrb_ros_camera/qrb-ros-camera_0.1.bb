inherit ros_distro_humble
inherit ros_component

SUMMARY  = "QTI open-source ROS2 node based on qmmf"
iSECTION = "multimedia"
LICENSE  = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

def get_ros_version(d):
    if bb.utils.contains('DISTRO_FEATURES', 'ros2-humble', '1', '0', d) == "1":
        return "humble"
    return "unknown"

def get_ros_package(d):
    if get_ros_version(d) == "humble":
        return "ros2-humble"
    return "unknown"
ROS_VERSION = "${@get_ros_version(d)}"
ROS_PACKAGE = "${@get_ros_package(d)}"

def config_target_sys(d):
    if d.getVar('PRODUCT', True) == 'ubuntu':
        return "aarch64-linux-gnu"
    else:
        return "${TARGET_ARCH}${TARGET_VENDOR}${@['-' + d.getVar('TARGET_OS'), ''][d.getVar('TARGET_OS') == ('' or 'custom')]}"

TARGET_SYS = "${@config_target_sys(d)}"

APPEND_FLAGS += '${@bb.utils.contains("PRODUCT", "ubuntu", \
                "-target ${TARGET_SYS} -I ${STAGING_INCDIR}/c++ ", "", d)}'
OECMAKE_C_FLAGS:append   = "${APPEND_FLAGS}"
OECMAKE_CXX_FLAGS:append = "${APPEND_FLAGS}"

# Dependencies
CAMERA_ROS2_NODE_DEPENDS = " \
    camera-server \
    dmabuf-transport \
    image-transport \
"

ROS_BUILD_DEPENDS = " \
    rclcpp \
    rcl \
    rclcpp-components \
    rcutils \
    sensor-msgs \ 
    rmw \
    dmabuf-transport \
    rmw-implementation-cmake \
    std-msgs \
    cv-bridge \
    yaml-cpp \
    camera-info-manager \
"

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
"

DEPENDS = "${CAMERA_ROS2_NODE_DEPENDS} ${ROS_BUILD_DEPENDS} ${ROS_BUILDTOOL_DEPENDS}"

ROS_EXEC_DEPENDS = " \
    rclcpp \
    rcl \
    rclcpp-components \
    rcutils \
    rmw \
    sensor-msgs \
"

RDEPENDS:${PN} += "${ROS_EXEC_DEPENDS}"
#DEPENDS += "ament-cmake-native"
#DEPENDS += "rclcpp"
#DEPENDS += "rclcpp-components"
#DEPENDS += "ament-cmake"
#DEPENDS += "sensor-msgs"
#DEPENDS += "ament-index-cpp"
#DEPENDS += "image-transport"
#DEPENDS += "yaml-cpp"
DEPENDS += "glib-2.0"

FILESPATH =+ "${WORKSPACE}/robotics/robot-camera:"
SRC_URI   =  "file://qrb_ros_camera/"
S         =  "${WORKDIR}/qrb_ros_camera/"

EXTRA_OECMAKE  += "-DROS_VERSION=${ROS_VERSION}"
EXTRA_OECMAKE  += "-DROS_DIR=${RECIPE_SYSROOT}/${ROS_DIR}"
EXTRA_OECMAKE  += "-DKERNEL_INCDIR=${STAGING_INCDIR}/linux-msm"
EXTRA_OECMAKE  += "-DSYSROOT_INCDIR=${STAGING_INCDIR}"
EXTRA_OECMAKE  += "-DSYSROOT_LIBDIR=${STAGING_LIBDIR}"
EXTRA_OECMAKE  += "-DDASHING_DIR=${RECIPE_SYSROOT}/${DASHING_DIR}"
EXTRA_OECMAKE  += "-DINSTALL_LIBDIR=${INSTALL_LIBDIR}"
EXTRA_OECMAKE  += "-DPLATFORM:STRING=linux"
EXTRA_OECMAKE  += "-DCPU:STRING=64"
EXTRA_OECMAKE  += "-DENABLE_LIBLOG:BOOL=True"
EXTRA_OECMAKE  += "-DCMAKE_CROSSCOMPILING:BOOL=True"
EXTRA_OECMAKE  += "-DCMAKE_C_COMPILER:STRING=${OECMAKE_C_COMPILER}"
EXTRA_OECMAKE  += '${@bb.utils.contains("PRODUCT", "ubuntu", \
                  "-DGNU:BOOL=True", "-DGNU:BOOL=False", d)}'

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}