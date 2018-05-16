#!/usr/bin/env groovy

def call() {
    measureStageExecutionTime("${constants.STAGE_COMPILE}") {
        echo("Executing [${constants.STAGE_COMPILE}] stage steps...")

        measureStepExecutionTime("${constants.STEP_NAME_COMPILE}") {
            sh("mvn -Djacoco.skip=true -e clean test-compile")
        }

        echo("Completed [${constants.STAGE_COMPILE}] stage steps.")
    }
}
