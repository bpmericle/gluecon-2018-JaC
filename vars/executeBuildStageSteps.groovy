#!/usr/bin/env groovy

def call() {
    def stageName = 'Build'
    echo("Executing [${stageName}] stage steps...")

    sh("mvn -v clean compile")

    echo("Completed [${stageName}] stage steps.")
}
