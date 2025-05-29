FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " file://0001-modify-CMakelists-to-fix-Werror-for-joint-state-broa.patch"