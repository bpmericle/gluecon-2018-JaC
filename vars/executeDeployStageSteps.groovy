#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    sh("mvn -Dserver.port=8080 -V -e spring-boot:run &")

    sleep(45)

    sh('uname -s')
    sh('ps -ax | grep java')

    def serverPort = 8080
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
