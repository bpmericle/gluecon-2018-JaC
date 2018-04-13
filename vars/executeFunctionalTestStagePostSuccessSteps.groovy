#!/usr/bin/env groovy

def call() {
    junit(allowEmptyResults: false, testResults: '**/target/failsafe-reports/**/*.xml')
    echo("Completed [Functional Test] stage with result [success].")
}
