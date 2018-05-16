#!/usr/bin/env groovy

def call() {
    measureStageExecutionTime('Compile') {
        echo("Executing [Compile] stage steps...")

        measureStepExecutionTime('Compile') {
            sh("mvn -Djacoco.skip=true -e clean test-compile")
        }

        echo("Completed [Compile] stage steps.")
    }
}
