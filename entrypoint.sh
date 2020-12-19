#!/usr/bin/env bash
cd /testapp
./gradlew clean test \
-Dselenide.headless=true \
-Dselenide.remote=http://chrome-standalone:4444/wd/hub
