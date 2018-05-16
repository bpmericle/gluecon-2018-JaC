#!/usr/bin/env groovy

def call() {
    echo("Executing [${constants.STAGE_DEPLOY_TO_PRODUCTION}] stage steps...")

    notifier.requestInput()
    input(message: 'Deploy to Production?', ok: 'Yes')

    echo("Completed [${constants.STAGE_DEPLOY_TO_PRODUCTION}] stage steps.")
}
