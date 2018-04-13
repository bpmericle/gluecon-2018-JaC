#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    publishHTML(reportName: 'Maven Site', reportDir: 'target/site', reportFiles: 'index.html', includes: '**/*')
    echo("Completed [${stageName}] stage with result [success].")
}
