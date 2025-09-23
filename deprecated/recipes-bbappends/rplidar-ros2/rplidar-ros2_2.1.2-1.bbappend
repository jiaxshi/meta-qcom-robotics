FILES:${PN}:prepend = "${datadir}/rplidar_ros"
FILES:${PN} += "${libdir}/*"

inherit robotics-package
