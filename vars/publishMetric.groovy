#!/usr/bin/env groovy

def call(metricName, value, tags=null) {
    def defaultTags = [:]
    if (tags != null) {
        defaultTags.addAll(tags)
    }
    defaultTags['job_name'] = JOB_NAME
    defaultTags['job_url'] = JOB_URL

    echo("Publishing metric [${metricName}] with value [${value}] and tags [${tags}]...")
    //publish the metric to some time-series datasource (like InfluxDB)
}
