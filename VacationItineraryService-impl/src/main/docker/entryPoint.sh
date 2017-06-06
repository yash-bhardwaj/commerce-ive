#!/bin/bash

set -e

APP_CLASSPATH=/usr/src/app/commerce-ive/lib/*

PLAY_SECRET=none

CONFIG="-Dplay.crypto.secret=$PLAY_SECRET -Dlagom.cluster.join-self=on"

JVM_OPS="-Xmx2048m -Xms2048m"

PLAY_SERVER_START="play.core.server.ProdServerStart"

echo "$APP_CLASSPATH $JVM_OPS $PLAY_SERVER_START"

#exec java -version

exec java -cp "$APP_CLASSPATH" $JVM_OPS $CONFIG $PLAY_SERVER_START
