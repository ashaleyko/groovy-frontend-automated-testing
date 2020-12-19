#!/usr/bin/env bash
cd /testapp
./gradlew clean test -Dselenide.headless=true
