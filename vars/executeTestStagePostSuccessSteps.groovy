#!/usr/bin/env groovy

def call() {
    junit(allowEmptyResults: false, testResults: '**/target/surefire-reports/**/*.xml')
    echo("Completed [Test] stage with result [success].")
}
