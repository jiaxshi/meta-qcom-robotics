do_install() {
    install -d ${D}/${includedir}
    install -d ${D}/${libdir}/

    cp -r ${RVSDK_DIR}/lib/*.so ${D}/${libdir}
    cp -r ${RVSDK_DIR}/include/* ${D}/${includedir}
}

FILES:${PN} = "${libdir}/*.so"

INSANE_SKIP:${PN} += "installed-vs-shipped"
