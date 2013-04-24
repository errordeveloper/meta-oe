DESCRIPTION = "Requests: HTTP for Humans"
HOMEPAGE = "http://docs.python-requests.org/en/latest/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"

RDEPENDS_${PN} = "python"
PR = "r0"

SRC_URI = "git://github.com/kennethreitz/requests;protocol=git"

S = "${WORKDIR}/git/"

SRCREV = "v${PV}"

LIC_FILES_CHKSUM = "file://README.rst;md5=74c75b1ca7932ffb54dc2d3d185d8803 \
                    file://NOTICE;md5=a7fcf1dc2d13f4c1e901564711244fb4 \
                    file://LICENSE;md5=c858703330162aa799141655a10fe120"

inherit setuptools

# need to export these variables for python-config to work
export BUILD_SYS
export HOST_SYS
export STAGING_INCDIR
export STAGING_LIBDIR

BBCLASSEXTEND = "native"

do_install_append() {
  rm -f ${D}${libdir}/python*/site-packages/site.py*
}
