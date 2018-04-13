#!/usr/bin/env groovy

def call() {
    publishHTML(reportName: 'Maven Site', reportDir: 'target/site', reportFiles: 'index.html', includes: '**/*')
    echo("Completed [Deploy] stage with result [success].")
}
