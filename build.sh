#!/usr/bin/env bash
set -euo pipefail
rm -rf out
mkdir -p out/classes
javac -d out/classes $(find src -name '*.java' | sort)
cp -R resources/. out/classes/
java -cp out/classes app.Main
