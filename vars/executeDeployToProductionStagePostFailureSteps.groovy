#!/usr/bin/env groovy

def call() {
    echo("Completed [${constants.STAGE_DEPLOY_TO_PRODUCTION}] stage with result [${constants.STATUS_FAILURE}].")
}
