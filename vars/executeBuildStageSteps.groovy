#!/usr/bin/env groovy

def call() {
    def stageName = 'Build'
    echo("Executing [${stageName}] stage steps...")

    tool('jdk8')
    def mvnHome = tool('maven3')

    sh("${mvnHome}/bin/mvn -v clean compile")

    echo("Completed [${stageName}] stage steps.")
}
