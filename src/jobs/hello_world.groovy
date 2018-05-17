#!/usr/bin/env groovy

def baseFolder = 'jobs'

folder(baseFolder) {
    displayName("Jobs")
    description("The base folder containing jobs managed by JaC.")
}

job("${baseFolder}/hello-world") {
    displayName('Hello World Job DSL Example')
    description('This Hello World job was created by using the Job DSL/Plugin.')

    logRotator(-1,5,-1,-1)

    parameters {
        stringParam('NAME', '', 'Enter your name.')
    }

    steps {
        shell('''#!/bin/bash
echo \"Hello $NAME\".''')
    }
}
