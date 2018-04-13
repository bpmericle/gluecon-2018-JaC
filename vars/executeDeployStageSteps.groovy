#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn -Dskip.surefire.tests=true -Dskip.failsafe.tests=true -V -e verify site')

    echo("Completed [${stageName}] stage steps.")
}
