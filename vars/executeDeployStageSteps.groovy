#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    def serverPort = 8080
    sh("mvn -Dserver.port=${serverPort} -V -e spring-boot:run &")

    def retries = 4
    def attempts = 0
    def sleepInterval = 15
    retry(retries) {
        attempts++
        sleep(sleepInterval)
        echo("Testing health endpoint. Attempt ${attempts} out of ${retries}.")
        def content = sh(script: "curl -X GET http://localhost:${serverPort}/actuator/health", returnStdout: true).trim()
        assert content.contains('{\"status\":\"UP\"}')
    }

    echo('Shutting down service.')
    sh("curl -i -X POST http://localhost:${serverPort}/actuator/shutdown")

    echo("Completed [${stageName}] stage steps.")
}
