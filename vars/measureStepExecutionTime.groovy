#!/usr/bin/env groovy

/**
 * Closure that will measure the execution time of step body the closure surrounds.
 */
def call(stepName, body) {
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
        tags['step_name', stepName]
        publishMetric('execution_time', executionTime, tags)
    }
}
