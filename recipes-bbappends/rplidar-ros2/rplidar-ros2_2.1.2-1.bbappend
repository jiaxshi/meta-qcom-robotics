FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://0001-Add-rplidar-scan-latency.patch"
FILES:${PN}:prepend = "${datadir}/rplidar_ros"
FILES:${PN} += "${libdir}/*"
