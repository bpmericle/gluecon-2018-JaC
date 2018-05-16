#!/usr/bin/env groovy

def call() {
    echo("Executing [Deploy to Production?] stage steps...")

    notifier.requestInput()
    input(message: 'Deploy to Production?', ok: 'Yes')

    echo("Completed [Deploy to Production?] stage steps.")
}
