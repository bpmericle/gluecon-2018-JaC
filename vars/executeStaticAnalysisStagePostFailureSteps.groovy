#!/usr/bin/env groovy

def call() {
    echo("Completed [${constants.STAGE_STATIC_ANALYSIS}] stage with result [${constants.STATUS_FAILURE}].")
}