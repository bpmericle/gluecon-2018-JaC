#!/usr/bin/env groovy

def call() {
    def stageName = 'Functional Tests'
    junit(allowEmptyResults: false, testResults: '**/target/failsafe-reports/**/*.xml')
    echo("Completed [${stageName}] stage with result [success].")
}
