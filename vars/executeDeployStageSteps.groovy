#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn -V -B -U -e -Dskip.surefire.tests=true -Dskip.failsafe.tests=true verify site')

    echo("Completed [${stageName}] stage steps.")
}
