#!/usr/bin/env groovy

def call() {
    echo("Completed [${constants.STAGE_INTEGRATION_TESTS}] stage with result [${constants.STATUS_FAILURE}].")
}
