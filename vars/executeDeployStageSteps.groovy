#!/usr/bin/env groovy

def call() {
    def stageName = 'Deploy'
    echo("Executing [${stageName}] stage steps...")

    //sh('mvn -Dskip.surefire.tests=true -Dskip.failsafe.tests=true -V -e verify site')
    sh('mvn -Dserver.port=8080 -V -e spring-boot:run &')

    sleep(30)

    echo('Testing health endpoint.')
    def rawContent = new URL('http://localhost:8000/actuator/health').getText()
    def content = readJSON(rawContent)
    def status = content.get('status')
    assert status == 'UP'

    echo('Shutting down service.')
    sh('curl -k -XPOST https://localhost:8000/actuator/shutdown')

    echo("Completed [${stageName}] stage steps.")
}
