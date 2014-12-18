DESCRIPTION = "Linux kernel for IPTV board"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

#PROVIDES = ""

SRC_URI = "git://github.com/embest-tech/linux-imx.git"

SRCBRANCH = "iptv_imx_3.10.17_1.0.0_ga"
SRCREV = "${SRCBRANCH}"
LOCALVERSION = "_1.0.0_IPTV"

S = "${WORKDIR}/git"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(iptv)"

do_configure_prepend() {
   # In some cases we'll use a different defconfig
   # example is manufacturing image which uses imx_v7_mfg_defconfig
   # however need way to change it back during daily build

   if [ -z "${FSL_KERNEL_DEFCONFIG}" ] ; then
       echo " defconfig from local.conf not set"
       fsl_defconfig='imx_v7_defconfig'
   else
       echo " Use local.conf for defconfig to set"
       fsl_defconfig=${FSL_KERNEL_DEFCONFIG}
   fi

   # check that defconfig file exists
   if [ ! -e "${S}/arch/arm/configs/$fsl_defconfig" ]; then
       fsl_defconfig='imx_v7_defconfig'
   fi


    cp ${S}/arch/arm/configs/${fsl_defconfig} ${S}/.config
    cp ${S}/arch/arm/configs/${fsl_defconfig} ${S}/../defconfig
}

