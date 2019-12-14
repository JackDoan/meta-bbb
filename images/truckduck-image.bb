SUMMARY = "A console development image with some C/C++ dev tools"
LICENSE = "MIT"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit core-image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    openssl \
    openssl-bin \
    psplash \
    term-prompt \
    tzdata \
    net-tools \
 "

KERNEL_EXTRA_INSTALL = " \
    kernel-modules \
    load-modules \
 "

WIFI_SUPPORT = " \
    crda \
    iw \
    linux-firmware-ath9k \
    linux-firmware-ralink \
    linux-firmware-rtl8192ce \
    linux-firmware-rtl8192cu \
    linux-firmware-rtl8192su \
    linux-firmware-rtl8723 \
    hostapd \
    wpa-supplicant \
    iwd \
 "

DEV_SDK_INSTALL = " \
    binutils \
    binutils-symlinks \
    coreutils \
    cpp \
    cpp-symlinks \
    diffutils \
    file \
    gcc \
    gcc-symlinks \
    g++ \
    g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ \
    libstdc++-dev \
    libtool \
    make \
    perl-modules \
    pkgconfig \
    python-pip \
    python-modules \
    python-pyusb \
    python3-pyusb \
    python-can \
    python3-can \
    python-cryptography \
    python-pycrypto \
    python3-cryptography \
    python3-pycrypto \
    python3 \
    systemd-analyze \
 "

DEV_EXTRAS = " \
    serialecho \
    spiloop \
 "

EXTRA_TOOLS_INSTALL = " \
    bash \
    bc \
    bzip2 \
    cursor-blink \
    curl \
    devmem2 \
    dialog \
    dosfstools \
    emmc-installer \
    ethtool \
    findutils \
    i2c-tools \
    iftop \
    htop \
    grep \
    less \
    picocom \
    procps \
    rsync \
    sysfsutils \
    tcpdump \
    unzip \
    util-linux \
    vim \
    wget \
    zip \
 "

CAN_TOOLS = " \
    can-utils \
    libsocketcan \
    iproute2 \
 "

IMAGE_INSTALL += " \
    ${CAN_TOOLS} \
    ${CORE_OS} \
    ${DEV_SDK_INSTALL} \
    ${DEV_EXTRAS} \
    ${EXTRA_TOOLS_INSTALL} \
    ${KERNEL_EXTRA_INSTALL} \
    ${WIFI_SUPPORT} \
    gadget-init \
 "

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/CST6CDT ${IMAGE_ROOTFS}/etc/localtime
}

disable_bootlogd() {
    #JACK TEMP DISABLED
    echo
    #echo BOOTLOGD_ENABLE=no > ${IMAGE_ROOTFS}/etc/default/bootlogd
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
    disable_bootlogd ; \
    rm -rf ${IMAGE_ROOTFS}/usr/lib/opkg; \
 "

export IMAGE_BASENAME = "truckduck-image"

