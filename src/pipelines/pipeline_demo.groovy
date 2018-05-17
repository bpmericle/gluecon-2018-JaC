#!/usr/bin/env groovy

def baseFolder = 'pipelines'

folder(baseFolder) {
    displayName("Pipelines")
    description("The base folder containing pipelines managed by JaC.")
}

pipelineJob("${baseFolder}/pipeline") {
    displayName('Pipeline Example')
    description('Pipeline for a demo project.')

    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url('https://github.com/bpmericle/gluecon-2018-JaC.git')
                    }
                    branch('master')
                }
            }
            scriptPath('src/pipelines/Jenkinsfile')
        }
    }
}
