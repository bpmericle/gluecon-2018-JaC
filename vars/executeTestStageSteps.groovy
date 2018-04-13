#!/usr/bin/env groovy

def call() {
    def stageName = 'Test'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn -V -B -U -e test')

    echo("Completed [${stageName}] stage steps.")
}
