#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    //sh('mvn -Dskip.surefire.tests=true -Dskip.failsafe.tests=true -V -e verify site')
    sh('mvn -Dserver.port=8080 -V -e spring-boot:run &')

    sleep(30)

    echo('Testing health endpoint.')
    def rawContent = sh(script: 'curl -i -X GET http://localhost:8080/actuator/health', returnStdout: true).trim()
    echo("rawContent: ${rawContent}")
    def content = readJSON(rawContent)
    echo("content: ${content}")
    def status = content.get('status')
    assert status == 'UP'

    echo('Shutting down service.')
    sh('curl -i -X POST http://localhost:8080/actuator/shutdown')

    echo("Completed [${stageName}] stage steps.")
}
