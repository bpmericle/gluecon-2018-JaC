#!/usr/bin/env groovy

def call() {
    echo("Executing [${constants.STAGE_INTEGRATION_TESTS}] stage steps...")

    sh("mvn -DskipSourceCompile=true -DskipTestCompile=true -Dskip.surefire.tests=true -Dmaven.javadoc.skip=true -e integration-test")

    echo("Completed [${constants.STAGE_INTEGRATION_TESTS}] stage steps.")
}
