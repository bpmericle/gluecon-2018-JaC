#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    sh('mvn spring-boot:run')

    echo("Completed [${stageName}] stage steps.")
}
