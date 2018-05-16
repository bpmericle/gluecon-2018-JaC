#!/usr/bin/env groovy

def call() {
    echo("Completed pipeline with result [${constants.STATUS_SUCCESS}].")
    notifier.notifyPipelineSuccess()
    measurePipelineExecutionTime()
}
