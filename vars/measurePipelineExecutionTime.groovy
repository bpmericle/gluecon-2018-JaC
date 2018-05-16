#!/usr/bin/env groovy

def call() {
    def startTime = currentBuild.startTimeInMillis
    def endTime = System.currentTimeMillis()
    def executionTime = endTime - startTime

    publishMetric('execution_time', executionTime)
}
