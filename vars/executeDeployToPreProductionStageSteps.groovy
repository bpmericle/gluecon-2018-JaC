#!/usr/bin/env groovy

def call() {
    echo("Executing [${constants.STAGE_DEPLOY_TO_PRE_PRODUCTION}] stage steps...")

    echo("Deploy to pre-production environment.")

    echo("Completed [${constants.STAGE_DEPLOY_TO_PRE_PRODUCTION}] stage steps.")
}
