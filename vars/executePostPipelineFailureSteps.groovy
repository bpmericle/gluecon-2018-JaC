#!/usr/bin/env groovy

def call() {
    echo("Completed pipeline with result [failure].")
    notifier.notifyPipelineFailure()
    measurePipelineExecutionTime()
}
