FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " file://0001-modify-CMakeLists-to-solve-Werror.patch"