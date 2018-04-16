#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    def serverPort = 8080
    sh("mvn -Dserver.port=${serverPort} -V -e spring-boot:run &")

    sleep(45)

    echo('Testing health endpoint.')
    def content = sh(script: "curl -X GET http://localhost:${serverPort}/actuator/health", returnStdout: true).trim()
    echo("content: ${content}")
    assert content.contains('{\"status\":\"UP\"}')

    echo('Shutting down service.')
    sh("curl -i -X POST http://localhost:${serverPort}/actuator/shutdown")

    echo("Completed [${stageName}] stage steps.")
}
