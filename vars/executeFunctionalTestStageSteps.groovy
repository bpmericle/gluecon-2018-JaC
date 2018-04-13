#!/usr/bin/env groovy

def call() {
    def stageName = 'Functional Test'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn -V -B -U -e -DskipTests verify')

    echo("Completed [${stageName}] stage steps.")
}
