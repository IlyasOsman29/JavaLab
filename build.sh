#!/usr/bin/env bash
set -e;rm -rf out;mkdir -p out/classes;javac -d out/classes $(find src -name '*.java');cp -r resources/* out/classes/;java -cp out/classes app.Main
