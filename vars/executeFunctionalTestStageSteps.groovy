#!/usr/bin/env groovy

def call() {
    def stageName = 'Functional Test'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn -V -B -U -e -Dskip.surefire.tests=true -Dmaven.javadoc.skip=true -Dmaven.source.skip=true verify')

    echo("Completed [${stageName}] stage steps.")
}
