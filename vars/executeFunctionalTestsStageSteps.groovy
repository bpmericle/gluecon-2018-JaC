#!/usr/bin/env groovy

def call() {
    def stageName = 'Functional Tests'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn -V -B -U -e -Dmaven.main.skip=true -Dskip.surefire.tests=true -Dmaven.javadoc.skip=true -Dmaven.source.skip=true verify')

    echo("Completed [${stageName}] stage steps.")
}
