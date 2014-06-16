DESCRIPTION = "bootloader for RIoTboard"
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=1707d6db1d42237583f50183a5651ecb"

SRC_URI = "git://github.com/embest-tech/u-boot-imx.git"
SRCBRANCH = "embest_imx_v2013.04_3.10.17_1.0.0_ga"
SRCREV = "${SRCBRANCH}"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(riotboard)"
