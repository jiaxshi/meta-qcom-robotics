ROS_BUILD_DEPENDS:remove = " \
  freeglut \
  mesa \
"
ROS_EXPORT_DEPENDS:remove = " \
  freeglut \
  mesa \
"
ROS_EXEC_DEPENDS:remove = " \
  freeglut \
  mesa \
"

EXTRA_OECMAKE:append = " -DWITH_OPENGL=OFF"
FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
SRC_URI += "file://0001-remove-libs-depending-on-opengl-from-moveit-perception.patch"
