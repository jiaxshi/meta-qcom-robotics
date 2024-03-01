inherit cmake pkgconfig

SUMMARY  = "QTI open-source GStreamer Plug-in for ROS2"
HOMEPAGE = "https://www.codelinaro.org/"
iSECTION = "multimedia"
LICENSE  = "BSD"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=3775480a712fc46a69647678acb234cb"

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

# Dependencies.
DEPENDS += "system-core-headers"
DEPENDS += "llvm-arm-toolchain-native"
DEPENDS += "glib-2.0"
DEPENDS += "${@bb.utils.contains('WITHIN_EXT_SDK', '1', '', '\
    gstreamer1.0 \
    gstreamer1.0-plugins-base \
    ', d)}"

SOURCEPATH = "${@bb.utils.contains('WITHIN_EXT_SDK', '1', '${WORKSPACE}', '${WORKSPACEROOT}/layers/src', d)}"
FILESPATH =+ "${SOURCEPATH}/vendor/qcom/opensource/robotics-oss:"
SRC_URI   =  "file://gst-ros2sink/"
S         =  "${WORKDIR}/gst-ros2sink/"

# Install directries.
INSTALL_LIBDIR := '${@bb.utils.contains("PRODUCT", "ubuntu", \
                  "${libdir}/${TARGET_SYS}/gstreamer-1.0", "${libdir}/gstreamer-1.0", d)}'

EXTRA_OECMAKE += "-DGST_VERSION_REQUIRED=1.14.4"
EXTRA_OECMAKE += "-DSYSROOT_INCDIR=${STAGING_INCDIR}"
EXTRA_OECMAKE += "-DSYSROOT_LIBDIR=${STAGING_LIBDIR}"
EXTRA_OECMAKE += "-DGST_PLUGINS_QTI_OSS_INSTALL_LIBDIR=${INSTALL_LIBDIR}"
EXTRA_OECMAKE += "-DGST_PLUGINS_QTI_OSS_LICENSE=${LICENSE}"
EXTRA_OECMAKE += "-DGST_PLUGINS_QTI_OSS_VERSION=1.0"
EXTRA_OECMAKE += "-DGST_PLUGINS_QTI_OSS_PACKAGE=${PN}"
EXTRA_OECMAKE += "-DGST_PLUGINS_QTI_OSS_SUMMARY="${SUMMARY}""
EXTRA_OECMAKE += "-DGST_PLUGINS_QTI_OSS_ORIGIN=${HOMEPAGE}"
EXTRA_OECMAKE += "-DPLATFORM:STRING=linux"
EXTRA_OECMAKE += "-DCPU:STRING=64"
EXTRA_OECMAKE += "-DCMAKE_CROSSCOMPILING:BOOL=True"
EXTRA_OECMAKE += "-DCMAKE_C_COMPILER:STRING=${OECMAKE_C_COMPILER}"

do_install:append() {
    install -d ${D}/${INSTALL_LIBDIR}/
}

FILES:${PN} += " \
  ${INSTALL_LIBDIR}/* \
  /usr/bin/* "

SOLIBS = ".so*"
FILES_SOLIBSDEV = ""
do_package_qa[noexec] = "1"
#RM_WORK_EXCLUDE += "${PN}"
