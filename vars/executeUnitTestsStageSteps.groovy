#!/usr/bin/env groovy

def call() {
    echo("Executing [${constants.STAGE_UNIT_TESTS}] stage steps...")

    sh("mvn -DskipSourceCompile=true -DskipTestCompile=true -Dskip.failsafe.tests=true -Dmaven.javadoc.skip=true -e test")

    echo("Completed [${constants.STAGE_UNIT_TESTS}] stage steps.")
}
