# gluecon-2018-JaC
This repository includes the source code and presentation that I delivered at Gluecon 2018.

## Installation and Setup
Click [here](docker-setup.md) if you want to use a Docker image for step 1. If you do this, you can skip step 2.

1. Start up a fresh Jenkins.

    I typically download the generic java package (.war) file and run it from the command-line. https://jenkins.io/download/

    ```
    $> java -jar jenkins.war
    ```

2. Install a few Jenkins Plugins

    **Navigate To:** Manage Jenkins > Manage Plugins > Available Tab

    1. Install Job DSL Plugin (id: job-dsl, documentation: https://plugins.jenkins.io/job-dsl)

    2. Install Authorize Project Plugin (id: authorize-project, documentation: https://plugins.jenkins.io/authorize-project)

3. Setup Authorize Project Plugin

    **Navigate To:** Manage Jenkins > Configure Global Security

    - Access Control for Builds > Add > Project default Build Authorization: Run as User who Triggered Build

4. Create seed freestyle job

    - Click "New Item" from the left menu
    - Enter "seed" for "Enter an item name"
    - Select "Freestyle project"
    - Click "Ok"
    - General > Advanced > Display Name: #Seed
    - Source Code Management > Git > Repositories > Repository URL: https://github.com/bpmericle/gluecon-2018-JaC.git
    - Build > Process Job DSLs
        - Look on Filesystem > DSL Scripts:
          - ```
            src/main/jobs/hello_world.groovy
            src/main/pipelines/declarative_pipeline_demo.groovy
            ```
        - Use Groovy Sandbox: checked
        - Action for removed jobs: Delete
        - Action for removed views: Delete
        - Action for removed config files: Delete
    - Click "Build Now" in the left menu

5. Setup **pipeline-lib** Global Library

    This library is a set of functions that will be available for use in the pipeline. The functions live inside the `vars` directory. This library also contains the DSL for the job and pipeline creation located in the `src` directory.

    **Navigate To:** Manage Jenkins > Configure System > Global Pipeline Libraries > Add

    - Library
        - Name: pipeline-lib
        - Default version: master
    - Retrieval Method
        - Modern SCM > Git > Project Repository: https://github.com/bpmericle/gluecon-2018-JaC.git

## Jobs Created
1. Hello World Freestyle Job

    **Navigate To:** Jobs > Hello World Job DSL Example

    This job is your typical "Hello World" type of job. You input a name, and the job will echo back a greeting in the output log. You can find the source code for this job [here](src/main/jobs/hello_world.groovy).

2. Demo Declarative Pipeline

    **Navigate To:** Pipelines > Declarative Pipeline Example

    This [multibranch pipeline](https://plugins.jenkins.io/workflow-multibranch) job uses a declarative pipeline to build a demo project. You can find the source code for this job [here](src/main/pipelines/declarative_pipeline_demo.groovy) and the demo project source code [here](https://github.com/bpmericle/gluecon-2018-demo-app).

    By default, the job will not automatically scan the repository for branches that contain a [Jenkinsfile](https://jenkins.io/doc/book/pipeline/jenkinsfile/) (file defining the stages and steps within a pipeline). You will need to click the **Scan Multibranch Pipeline Now** link in the left menu, wait a few seconds, then refresh the page. You will see a separate pipeline job for each branch of the source code that contains a [Jekninsfile](https://github.com/bpmericle/gluecon-2018-demo-app/blob/master/Jenkinsfile) in the root directory.

## Resources
Below you will find the many resources I have used to aid me in my Jenkins job and pipeline development activities.

- [Job DSL Plugin](https://github.com/jenkinsci/job-dsl-plugin/wiki)
- [Job DSL API](https://jenkinsci.github.io/job-dsl-plugin/)
- [Groovy API](http://groovy-lang.org/gdk.html) ([Documentation](http://groovy-lang.org/documentation.html))
- [Script Security Plugin](https://wiki.jenkins.io/display/JENKINS/Script+Security+Plugin)
- [Authorize Project Plugin](https://wiki.jenkins.io/display/JENKINS/Authorize+Project+plugin)
- [Pipeline](https://jenkins.io/doc/book/pipeline/)
    - [Pipeline Declarative Model](https://github.com/jenkinsci/pipeline-model-definition-plugin/wiki/getting-started)
    - [Pipeline shared Libraries](https://jenkins.io/doc/book/pipeline/shared-libraries/)
    - [Pipeline Steps](https://jenkins.io/doc/pipeline/steps/)
        - [Basic Steps](https://jenkins.io/doc/pipeline/steps/workflow-basic-steps/)
        - [Utility Steps](https://jenkins.io/doc/pipeline/steps/pipeline-utility-steps/)
