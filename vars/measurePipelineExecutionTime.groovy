#!/usr/bin/env groovy

def call() {
    def startTime = currentBuild.startTimeInMillis
    def endTime = System.currentTimeMillis()
    def executionTime = endTime - startTime

    publishMetric(constants.METRIC_NAME_EXECUTION_TIME, executionTime)
}
