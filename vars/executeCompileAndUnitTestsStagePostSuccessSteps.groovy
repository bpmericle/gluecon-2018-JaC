#!/usr/bin/env groovy

def call() {
    def stageName = 'Compile and Unit Tests'
    junit(allowEmptyResults: false, testResults: '**/target/surefire-reports/**/*.xml')
    echo("Completed [${stageName}] stage with result [success].")
}
