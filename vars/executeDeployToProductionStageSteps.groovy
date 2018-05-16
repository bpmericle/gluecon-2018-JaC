#!/usr/bin/env groovy

def call() {
    echo("Executing [${constants.STAGE_DEPLOY_TO_PRODUCTION}] stage steps...")

    echo("Deploy to production environment.")

    echo("Completed [${constants.STAGE_DEPLOY_TO_PRODUCTION}] stage steps.")
}
