#!/usr/bin/env groovy

multibranchPipelineJob('pipelines/demo') {
    displayName('Demo')
    description('Pipeline for the demo project.')

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
