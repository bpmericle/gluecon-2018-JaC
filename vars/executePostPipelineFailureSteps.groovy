#!/usr/bin/env groovy

def call() {
    echo("Completed pipeline with result [${constants.STATUS_FAILURE}].")
    notifier.notifyPipelineFailure()
    measurePipelineExecutionTime()
}
