#!/usr/bin/env groovy

import groovy.transform.Field

@Field String STAGE_COMPILE = 'Compile'
@Field String STAGE_UNIT_TESTS = 'Unit Tests'
@Field String STAGE_STATIC_ANALYSIS = 'Static Analysis'
@Field String STAGE_INTEGRATION_TESTS = 'Integration Tests'
@Field String STAGE_PUBLISH_ARTIFACT = 'Publish Artifact'
@Field String STAGE_DEPLOY_TO_PRE_PRODUCTION = 'Deploy to Pre-Production'
@Field String STAGE_DEPLOY_TO_PRODUCTION_INPUT = 'Deploy to Production?'
@Field String STAGE_DEPLOY_TO_PRODUCTION = 'Deploy to Production'

@Field String STEP_NAME_COMPILE = 'Compile'

@Field String METRIC_NAME_EXECUTION_TIME = 'execution_time'

@Field String STATUS_SUCCESS = 'success'
@Field String STATUS_FAILURE = 'failure'
@Field String STATUS_ABORTED = 'aborted'
