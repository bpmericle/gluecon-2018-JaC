#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    //publishHTML([allowMissing: false, reportDir: 'target/site', reportFiles: 'index.html', reportName: 'Maven Site'])
    //publishHTML([allowMissing: false, reportDir: 'target/site/apidocs', reportFiles: 'overview-summary.html', reportName: 'Javadoc'])
    echo("Completed [${stageName}] stage with result [success].")
}
