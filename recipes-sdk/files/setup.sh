#!/bin/bash

# Copyright (c) 2023 Qualcomm Innovation Center, Inc. All rights reserved.
# SPDX-License-Identifier: BSD-3-Clause-Clear

export SDK_TOP_DIR=$PWD

#create toolchain dir
if [ ! -d "$SDK_TOP_DIR/toolchain/install_dir" ];then
  # Install toolchain
  search_dir="toolchain"
  for file in $search_dir/*.sh; do
    echo $file
      mkdir toolchain/install_dir
      ./"$file" -d $PWD/toolchain/install_dir -y
  done

  #tar -zxvf qirf tar.gz
  search_dir="runtime"
  cd $search_dir
  for file in *tar.gz; do
    echo $file
    tar -zxvf "$file"
  done

  #install qirf packages
  for file in qirf*; do
    echo $file
    if [ -d "$file" ]; then
      cd $file
      ar -x qirf-*
      xz -d data.tar.xz && tar -xf data.tar -C $SDK_TOP_DIR/toolchain/install_dir/sysroots/*-oe-linux
      cd ../
    fi
  done
cd $SDK_TOP_DIR

#run sdk env setup
export search_dir=$SDK_TOP_DIR/toolchain/install_dir/environment*linux
for file in $search_dir;do
  . "$file"
done
echo "run sdk env setup ok : $search_dir"

#config multi-platform using platform_config.h
DISTRO=$(cat $SDKTARGETSYSROOT/../../version-aarch64-oe-linux | grep -oP '(?<=Distro: )\S+')
MACHINE=$(cat $SDKTARGETSYSROOT/etc/hostname)
export MACHINE_DISTRO=$MACHINE'_'$DISTRO

ln -sf $SDK_TOP_DIR/sample-code/Product_SDK_Samples/Applications/platform_config.h $SDKTARGETSYSROOT/usr/include/platform_config.h
fi

#install or uninstall qirf
if [ "$1" == "uninstall" ]; then
  if [ -d "toolchain/install_dir" ]; then
    rm -rf toolchain/install_dir
    rm -rf runtime/product*/*
  fi
  echo "uninstall qirf sdk "
else
  export search_dir=$SDK_TOP_DIR/toolchain/install_dir/environment*linux
  for file in $search_dir;do
    . "$file"
  done
  echo "setup qirf sysroot done!"
fi

