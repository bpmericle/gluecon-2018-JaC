#!/usr/bin/env groovy

/**
 * Closure that will measure the execution time of stage body the closure surrounds.
 */
def call(stageName, body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config

    def startTime = System.currentTimeMillis()
    try {
        body()
    } catch (Exception e) {
        error(e.message)
    } finally {
        def endTime = System.currentTimeMillis()
        def executionTime = endTime - startTime

        def tags = [:]
        tags['stage_name', stageName]
        publishMetric('execution_time', executionTime, tags)
    }
}
