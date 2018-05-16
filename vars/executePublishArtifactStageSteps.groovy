#!/usr/bin/env groovy

def call() {
    echo("Executing [Publish Artifact] stage steps...")

    echo ("Deploy artifact to artifact repository.")
    //sh("mvn -Djacoco.skip=true -DskipSourceCompile=true -DskipTestCompile=true -Dskip.surefire.tests=true -Dskip.failsafe.tests=true -Dartifact.repo.host=??? -Dartifact.repo.port=??? -e deploy")

    echo("Completed [Publish Artifact] stage steps.")
}
