require linux-stable.inc

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "beaglebone"

#KERNEL_DEVICETREE ?= " \
#    am335x-boneblack.dtb \
#    am335x-boneblack-wireless.dtb \
#    am335x-boneblue.dtb \
#    am335x-bonegreen.dtb \
#    am335x-bonegreen-wireless.dtb \
#    am335x-sancloud-bbe.dts \
#"
KERNEL_DEVICETREE ?= " \
    am335x-boneblack.dtb \
    am335x-sancloud-bbe.dtb \
"


LINUX_VERSION = "5.3"
LINUX_VERSION_EXTENSION = "-truckduck"

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "5.3.1"
SRCREV = "c9a59a82366b700666ddda9e344c73198391b192"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
    file://0001-spidev-Add-a-generic-compatible-id.patch \
    file://0002-dts-Remove-bbb-cape-i2c-definitions.patch \
    file://0003-wlcore-Change-NO-FW-RX-BA-session-warnings-to-debug.patch \
    file://0004-dts-add-dcans-to-bbb.patch \
"
