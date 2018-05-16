#!/usr/bin/env groovy

def notifyPipelineSuccess() {
    def subject = buildSubject('Succeeded')
    def body = "The pipeline [<a href=\"${BUILD_URL}\">${BUILD_TAG}</a>] has succeeded."
    notifyByEmail(subject, body)
}

def notifyPipelineFailure() {
    def subject = buildSubject('Failed')
    def body = "The pipeline [<a href=\"${BUILD_URL}\">${BUILD_TAG}</a>] has failed. Consult the <a href=\"${BUILD_URL}/consoleFull\">console output</a> to determine the cause."
    notifyByEmail(subject, body)
}

def notifyPipelineAborted() {
    def subject = buildSubject('Aborted')
    def body = "The pipeline [<a href=\"${BUILD_URL}\">${BUILD_TAG}</a>] was aborted. Consult the <a href=\"${BUILD_URL}/consoleFull\">console output</a> to determine the cause."
    notifyByEmail(subject, body)
}

def requestInput() {
    def subject = buildSubject('Needs Input')
    def body = "The pipeline [<a href=\"${BUILD_URL}\">${BUILD_TAG}</a>] requires input. Please click <a href=\"${BUILD_URL}/input\">here</a> to provide input in order to continue."
    notifyByEmail(subject, body)
}

def buildSubject(status) {
    return "Pipeline Notification [Pipeline ${JOB_NAME} ${status}]"
}

def notifyByEmail(subject, body) {
    try {
        mail(subject: subject,
             from: 'notifier@yourcompany.com',
             to: 'you@yourcompany.com',
             body: body)
    } catch (Exception ex) {
        echo("Caught while trying to email a notification: ${ex.message}")
    }
}
