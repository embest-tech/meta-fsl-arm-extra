DESCRIPTION = "Linux kernel for RIoTboard"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

#PROVIDES = ""

SRC_URI = "git://github.com/embest-tech/linux-imx.git \
           file://defconfig"

SRCBRANCH = "embest_imx_3.10.17_1.0.0_ga"
SRCREV = "${SRCBRANCH}"
LOCALVERSION = "_1.0.0_RIoTboard"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(riotboard)"
