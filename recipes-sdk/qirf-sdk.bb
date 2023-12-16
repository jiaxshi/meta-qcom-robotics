#License applicable to the recipe file only,  not to the packages installed by this recipe.
LICENSE = "BSD-3-Clause-Clear"

inherit fsdk-base fsdk-package

SRC_URI =+ "file://install.sh"
SRC_URI =+ "file://uninstall.sh"

# The path infos of qirf content
TOOLCHAIN_PATH = "${TOPDIR}/SDK"
SETUP_PATH = "${FILE_DIRNAME}/files/setup.sh"

PKG_LISTS = " \
  librealsense2-2.54_2.54.2-r0_armv8-2a.ipk \
  librealsense2-tests_2.54.2-r0_armv8-2a.ipk \
"

# The name and version of qirf SDK artifact
SDK_PN = "qirf_sdk"
PV = "2.0.0"

