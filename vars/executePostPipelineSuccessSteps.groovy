#!/usr/bin/env groovy

def call() {
    echo("Completed pipeline with status [${currentBuild.result}].")
}
