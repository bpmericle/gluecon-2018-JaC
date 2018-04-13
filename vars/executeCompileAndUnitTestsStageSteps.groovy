#!/usr/bin/env groovy

def call() {
    def stageName = 'Compile and Unit Tests'
    echo("Executing [${stageName}] stage steps...")

    sh("mvn -V -B -U -e clean test")

    echo("Completed [${stageName}] stage steps.")
}