#!/usr/bin/env groovy

def call() {
    junit(allowEmptyResults: false, testResults: '**/target/failsafe-reports/**/*.xml')
    echo("Completed [${constants.STAGE_INTEGRATION_TESTS}] stage with result [${constants.STATUS_SUCCESS}].")
}
