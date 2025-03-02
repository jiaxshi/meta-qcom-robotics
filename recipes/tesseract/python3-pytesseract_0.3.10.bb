SUMMARY = "Python-tesseract is a python wrapper for Google's Tesseract-OCR"
HOMEPAGE = "https://github.com/madmaze/pytesseract"
AUTHOR = "Samuel Hoffstaetter <samuel@hoffstaetter.com>"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI = "https://files.pythonhosted.org/packages/f0/f1/e34221d3b870fb3b6b38a5843ad2b802bdc85c222c7c49555b72e59eb52b/pytesseract-0.3.10.tar.gz"
SRC_URI[md5sum] = "8abcce2d353750780c2e74b43571a0a3"
SRC_URI[sha256sum] = "f1c3a8b0f07fd01a1085d451f5b8315be6eec1d5577a6796d46dc7a62bd4120f"

S = "${WORKDIR}/pytesseract-0.3.10"

RDEPENDS:${PN} = " python3-packaging python3-pillow "

inherit setuptools3
