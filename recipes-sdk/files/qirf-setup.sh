#!/bin/bash

# Copyright (c) 2023 Qualcomm Innovation Center, Inc. All rights reserved.
# SPDX-License-Identifier: BSD-3-Clause-Clear

SDK_NAME="QIRF_SDK"

#common environment variables export
export PATH=/opt/qcom/qirf-sdk/usr/bin:${PATH}
export LD_LIBRARY_PATH=/opt/qcom/qirf-sdk/usr/lib:${LD_LIBRARY_PATH}

#ROS environment variables export
export AMENT_PREFIX_PATH=/opt/qcom/qirf-sdk/usr:${AMENT_PREFIX_PATH}
export PYTHONPATH=/opt/qcom/qirf-sdk/usr/lib/python3.10/site-packages:${PYTHONPATH}