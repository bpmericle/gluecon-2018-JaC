#!/usr/bin/env groovy

folder('jobs') {
    displayName("Jobs")
    description("The base folder containing jobs managed by JaC.")
}

job('jobs/hello-world') {
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
