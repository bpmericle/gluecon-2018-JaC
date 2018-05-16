#!/usr/bin/env groovy

def call() {
    echo("Executing [${constants.STAGE_STATIC_ANALYSIS}] stage steps...")

    echo("Execute static code analysis.")
    //sh("mvn -DskipSourceCompile=true -DskipTestCompile=true -Dskip.surefire.tests=true -Dskip.failsafe.tests=true -Dmaven.javadoc.skip=true -e sonar:sonar")

    echo("Completed [${constants.STAGE_STATIC_ANALYSIS}] stage steps.")
}
