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

        echo("Test the service health. Attempt ${attempts} out of ${retries}.")
        def healthEndpointContent = sh(script: "curl http://localhost:${serverPort}/actuator/health", returnStdout: true).trim()
        echo("received content: [${healthEndpointContent}]")
        assert healthEndpointContent.contains('{"status":"UP"}')
    }

    echo('Test the service with no parameter.')
    def testEndpointNoParamContent = sh(script: "curl http://localhost:${serverPort}/greet", returnStdout: true).trim()
    echo("received content: [${testEndpointNoParamContent}]")
    assert testEndpointNoParamContent.contains('{"id":1,"content":"Hello, Stranger!"}')

    echo('Test the service with a parameter.')
    def testEndpointContent = sh(script: "curl http://localhost:${serverPort}/greet?name=Brian", returnStdout: true).trim()
    echo("received content: [${testEndpointContent}]")
    assert testEndpointContent.contains('{"id":2,"content":"Hello, Brian!"}')

    echo('Shutdown the service.')
    def shutdownEndpointContent = sh(script: "curl -X POST http://localhost:${serverPort}/actuator/shutdown", returnStdout: true).trim()
    echo("received content: [${shutdownEndpointContent}]")
    assert shutdownEndpointContent.contains('{"message":"Shutting down, bye..."}')

    echo("Completed [${stageName}] stage steps.")
}
