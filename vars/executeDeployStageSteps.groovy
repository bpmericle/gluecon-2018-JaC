#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    def serverPort = 8090
    def response = sh(script: "mvn -Dserver.port=${serverPort} -V -e spring-boot:run", returnStdout: true).trim()
    echo("Output:\r\n${response}")

    sleep(30)

    echo('Testing health endpoint.')
    def rawContent = sh(script: "curl -i -X GET http://localhost:${serverPort}/actuator/health", returnStdout: true).trim()
    echo("rawContent: ${rawContent}")
    def content = readJSON(rawContent)
    echo("content: ${content}")
    def status = content.get('status')
    assert status == 'UP'

    echo('Shutting down service.')
    sh("curl -i -X POST http://localhost:${serverPort}/actuator/shutdown")

    echo("Completed [${stageName}] stage steps.")
}
