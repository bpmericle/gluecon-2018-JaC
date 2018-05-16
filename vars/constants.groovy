#!/usr/bin/env groovy

import groovy.transform.Field

@Field final String STAGE_COMPILE = 'Compile'
@Field final String STAGE_UNIT_TESTS = 'Unit Tests'
@Field final String STAGE_STATIC_ANALYSIS = 'Static Analysis'
@Field final String STAGE_INTEGRATION_TESTS = 'Integration Tests'
@Field final String STAGE_PUBLISH_ARTIFACT = 'Publish Artifact'
@Field final String STAGE_DEPLOY_TO_PRE_PRODUCTION = 'Deploy to Pre-Production'
@Field final String STAGE_DEPLOY_TO_PRODUCTION_INPUT = 'Deploy to Production?'
@Field final String STAGE_DEPLOY_TO_PRODUCTION = 'Deploy to Production'

@Field final String STEP_NAME_COMPILE = 'Compile'

@Field final String METRIC_NAME_EXECUTION_TIME = 'execution_time'

@Field final String STATUS_SUCCESS = 'success'
@Field final String STATUS_FAILURE = 'failure'
@Field final String STATUS_ABORTED = 'aborted'
