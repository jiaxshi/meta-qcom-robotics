# remove same headers with abseil-cpp and keep align with upstream to generate ESDK

do_install:append() {
    rm -rf ${D}${includedir}/absl
}

