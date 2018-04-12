#!/usr/bin/env groovy

def call() {
    def stageName = 'Build'
    echo("Executing [${stageName}] stage steps...")

    def javaHome = tool('jdk8')
    def mvnHome = tool('maven3')

    /*env.JAVA_HOME="${javaHome}"
    env.MAVEN_HOME="${mvnHome}"
    env.PATH="${env.JAVA_HOME}/bin:${env.MAVEN_HOME}/bin:${env.PATH}"
    echo("Java Home: ${env.JAVA_HOME}, Maven Home: ${env.MAVEN_HOME}, Path: ${env.PATH}")*/

    sh("mvn -v clean compile")

    echo("Completed [${stageName}] stage steps.")
}
