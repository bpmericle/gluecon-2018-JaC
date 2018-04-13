#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    publishHTML([allowMissing: false, alwaysLinkToLastBuild: true, keepAll: true, reportDir: 'target/site', reportFiles: 'index.html', reportName: 'Maven Generated Website'])
    echo("Completed [${stageName}] stage with result [success].")
}
