#!/usr/bin/env groovy

def call() {
    def stageName = 'Functional Tests'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn -Dskip.surefire.tests=true -Dmaven.javadoc.skip=true -Dmaven.source.skip=true -V -e verify')

    echo("Completed [${stageName}] stage steps.")
}
