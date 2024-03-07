# Welcome to the Qualcomm Intelligent Robotics Function (QIRF) SDK

In this documentation, you will learn:

- What is the QIRF SDK
- How to sync and build the QIRF SDK
- How to install and uninstall the QIRF SDK

Let's get started!

# What is the QIRF SDK

The QIRF SDK is a software development kit designed to accelerate developers to use and develop applications on Qualcomm robotics platforms.

The QIRF SDK provides advanced features as below:

- APIs and tools for robot application development.

- Solutions to address generic robotics problems like sensor input, robot control, navigation, localization and mapping method, etc.

- Add your own application recipes based on QIRF.

- Standalone compilation based on Yocto Project.


# How to sync and build the QIRF SDK

**QIRF packages are generated combined with Qualcomm Linux 1.0 base.**

## Host Setup

Refer to https://github.com/quic-yocto/qcom-manifest/blob/qcom-linux-kirkstone/README.md setup the host environment.

## Sync QIRF SDK

```shell
mkdir <QIRF SDK workspace>
cd <QIRF SDK workspace>
repo init -u https://github.com/quic-yocto/qcom-manifest -b qcom-linux-kirkstone -m qcom-6.6.13-QLI.1.0-Ver.1.2_robotics.xml
repo sync -c -j8
```

## Build QIRF SDK

```shell
export SHELL=/bin/bash
MACHINE=qcm6490 DISTRO=qcom-robotics-ros2-humble source setup-robotics-environment
bitbake qcom-robotics-full-image
bitbake qirf-sdk
```
Note:
The qcom-robotics-full-image consists of [multimedia image](https://github.com/quic-yocto/meta-qcom-distro/blob/kirkstone/recipes-products/images/qcom-multimedia-image.bb) add-on ROS.

QIRF SDK output path: ${QIRF SDK workspace}/build-qcom-robotics-ros2-humble/tmp-glibc/deploy/artifacts.

Image output path: ${QIRF SDK workspace}/build-qcom-robotics-ros2-humble/tmp-glibc/deploy/images/qcm6490/qcom-robotics-full-image.


# How to install and uninstall the QIRF SDK

## Flash image

Refer to User Guide on [Qualcomm Robotics RB3 Gen2 Development Kit User Guide](https://docs.qualcomm.com/bundle/80-70014-101/resource/80-70014-101_REV_AC_Qualcomm_Robotics_RB3_Gen2_Development_Kit_User_Guide.pdf)
to complete flashing image.

Note: Use ${QIRF SDK workspace}/build-qcom-robotics-ros2-humble/tmp-glibc/deploy/images/qcm6490/qcom-robotics-full-image to replace the folder in step 4 of part 3.3.

## How to install QIRF SDK
```shell
adb root
adb push <QIRF SDK> /opt/qcom/qirf-sdk
adb shell
export HOME=/opt/qcom/qirf-sdk
cd /opt/qcom/qirf-sdk
tar -zxvf qirf-sdk_2.0.0.tar.gz
cd qirf-sdk/runtime
tar -zxvf qirf-sdk.tar.gz
cd qirf-sdk
sh install.sh
```

## How to uninstall QIRF SDK
```shell
adb root
adb shell
export HOME=/opt/qcom/qirf-sdk
cd /opt/qcom/qirf-sdk/qirf-sdk/runtime/qirf-sdk
sh uninstall.sh
```

NOTE: For the further development, please refer to QIRF SDK user guide documentation, to be released later.

# Reference

[Standard Yocto environment](https://docs.yoctoproject.org/4.0.13/brief-yoctoprojectqs/index.html)

[QCOM Linux Yocto BSP releases](https://github.com/quic-yocto/qcom-manifest/blob/qcom-linux-kirkstone/README.md)
