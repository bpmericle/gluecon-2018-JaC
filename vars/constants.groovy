#!/usr/bin/env groovy

import groovy.transform.Field

@Field public final String STAGE_COMPILE = 'Compile'
@Field public final String STAGE_UNIT_TESTS = 'Unit Tests'
@Field public final String STAGE_STATIC_ANALYSIS = 'Static Analysis'
@Field public final String STAGE_INTEGRATION_TESTS = 'Integration Tests'
@Field public final String STAGE_PUBLISH_ARTIFACT = 'Publish Artifact'
@Field public final String STAGE_DEPLOY_TO_PRE_PRODUCTION = 'Deploy to Pre-Production'
@Field public final String STAGE_DEPLOY_TO_PRODUCTION_INPUT = 'Deploy to Production?'
@Field public final String STAGE_DEPLOY_TO_PRODUCTION = 'Deploy to Production'

@Field public final String STEP_NAME_COMPILE = 'Compile'

@Field public final String METRIC_NAME_EXECUTION_TIME = 'execution_time'

@Field public final String STATUS_SUCCESS = 'success'
@Field public final String STATUS_FAILURE = 'failure'
@Field public final String STATUS_ABORTED = 'aborted'
