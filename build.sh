#!/usr/bin/env bash
set -e; rm -rf out; mkdir -p out/classes; javac -d out/classes src/api/*.java src/plugin/*.java src/app/*.java; cp -r resources/* out/classes/; java -cp out/classes app.Main
