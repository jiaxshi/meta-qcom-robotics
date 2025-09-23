do_configure:prepend() {
    # otherwise https://github.com/ceres-solver/ceres-solver/blob/0b748597889f460764f6c980a00c6f502caa3875/cmake/AddGerritCommitHook.c    make#L68
    # will try to fetch https://ceres-solver-review.googlesource.com/tools/hooks/commit-msg durind do_configure
    # which sometimes gets stuck (as there is no TIMEOUT set in DOWNLOAD)
    # and we really don't need Gerrit's Change-Id tags when just building this
    if [ ! -d ${S}/.git/hooks/ ];then
        mkdir ${S}/.git/hooks/
    fi
    touch ${S}/.git/hooks/commit-msg
}

# error: cannot convert ‘int*’ to ‘idx_t*’ {aka ‘long int*’}
# https://github.com/ceres-solver/ceres-solver/issues/828
EXTRA_OECMAKE += "-DEIGENMETIS=OFF"

# - nothing provides ceres-solver needed by packagegroup
ALLOW_EMPTY:${PN} = "1"