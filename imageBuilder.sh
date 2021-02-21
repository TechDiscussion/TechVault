#!/bin/bash
mkdir -p build/dependency
cd build/dependency
jar -xf ../libs/*.jar
jar -xf ../libs/*.war
cd ../../
