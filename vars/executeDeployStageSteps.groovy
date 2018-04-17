#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    def serverPort = 8080
    sh("mvn -Dserver.port=${serverPort} -V -e spring-boot:run &")

    def retries = 4
    def attempts = 0
    retry(retries) {
        attempts++

        def sleepInterval = attempts > 1 ? 5 : 35
        sleep(sleepInterval)

        echo("Test the service. Attempt ${attempts} out of ${retries}.")
        def healthEndpointContent = sh(script: "curl -X GET http://localhost:${serverPort}/actuator/health", returnStdout: true).trim()
        echo("received content: [${healthEndpointContent}]")
        assert healthEndpointContent.contains('{"status":"UP"}')
    }

    echo('Shutdown the service.')
    def shutdownEndpointContent = sh(script: "curl -X POST http://localhost:${serverPort}/actuator/shutdown", returnStdout: true).trim()
    echo("received content: [${shutdownEndpointContent}]")
    assert shutdownEndpointContent.contains('{"message":"Shutting down, bye..."}')

    echo("Completed [${stageName}] stage steps.")
}
