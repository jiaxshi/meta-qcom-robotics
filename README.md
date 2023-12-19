# Welcome to the Qualcomm Intelligent Robotics Function (QIRF) SDK

In this documentation, you will learn:

- What is the QIRF SDK
- How to sync and build the QIRF SDK
- How to install and uninstall the QIRF SDK

Let's get started!

# What is the QIRF SDK

The QIRF SDK is a powerful software development kit designed to help developers quickly use applications on Qualcomm robotics platforms.

The QIRF SDK has the advantages for developing Robotic application as it:

- Provides APIs and tools for robot application development.

- Provides solutions to address generic robotics problems like sensor input, robot control, navigation, localization and mapping method, etc.

- Supports the addition of new applications and libraries to an image, which can be flashed onto a device.

- Supports standalone compilation with the Open-Embedded Build System.

# How to sync and build the QIRF SDK

## Sync QIRF SDK

```shell
cd <your QIRF SDK workspace>
repo init -u https://github.com/quic-yocto/qcom-manifest -b qcom-linux-kirkstone -m qcom-6.6.00-QLI.1.0-Ver.1.0_robotics.xml
repo sync
```

## Build QIRF SDK

```shell
MACHINE=qcm6490 DISTRO=qcom-robotics-ros2-humble source setup-robotics-environment
bitbake qcom-robotics-full-image
bitbake qirf-sdk
```

# How to install and uninstall the QIRF SDK

## How to install QIRF SDK
```shell
adb root
adb shell mount -o remount,rw /
adb push <your QIRF SDK artifacts> /home/root
adb shell
export HOME=/home/root
cd /home/root
tar -zxvf qirf_sdk_2.0.0.tar.gz
cd qirf_sdk/runtime
tar -zxvf qirf_sdk.tar.gz
cd qirf_sdk
chmod 777 install.sh uninstall.sh
sh install.sh
```

## How to uninstall QIRF SDK
```shell
adb root
adb shell mount -o remount,rw /
adb shell
export HOME=/home/root
cd /home/root/qirf_sdk/runtime/qirf_sdk
sh uninstall.sh
```
