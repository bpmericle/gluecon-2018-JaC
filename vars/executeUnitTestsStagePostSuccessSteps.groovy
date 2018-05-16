#!/usr/bin/env groovy

def call() {
    junit(allowEmptyResults: false, testResults: '**/target/surefire-reports/**/*.xml')
    echo("Completed [${constants.STAGE_UNIT_TESTS}] stage with result [${constants.STATUS_SUCCESS}].")
}
