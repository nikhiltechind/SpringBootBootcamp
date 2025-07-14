#!/usr/bin/env bash

# Install Java (Temurin JDK 17)
curl -L -o temurin.tar.gz https://github.com/adoptium/temurin17-binaries/releases/latest/download/OpenJDK17U-jdk_x64_linux_hotspot.tar.gz
mkdir -p temurin
tar -xzf temurin.tar.gz -C temurin --strip-components=1

# Set JAVA_HOME and update PATH
export JAVA_HOME=$PWD/temurin
export PATH=$JAVA_HOME/bin:$PATH

# Now build the app
./mvnw clean package -DskipTests
