#!/usr/bin/env groovy

def call() {
    echo("Executing [Static Analysis] stage steps...")

    sh("mvn -DskipSourceCompile=true -DskipTestCompile=true -Dskip.surefire.tests=true -Dskip.failsafe.tests=true -Dmaven.javadoc.skip=true -e verify sonar:sonar")

    echo("Completed [Static Analysis] stage steps.")
}
