#!/usr/bin/env groovy

folder('pipelines') {
    displayName("Pipelines")
    description("The base folder containing pipelines managed by JaC.")
}

multibranchPipelineJob('pipelines/declarative-pipeline-demo') {
    displayName('Declarative Pipeline Example')
    description('Declarative Pipeline for a demo project.')

    branchSources {
        git {
            remote('https://github.com/bpmericle/gluecon-2018-demo-app.git')
            includes('*')
        }
    }

    orphanedItemStrategy {
        discardOldItems {
            numToKeep(25)
        }
    }
}
