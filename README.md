# gluecon-2018-JaC
This repository includes the source code and presentation that I delivered at Gluecon 2018.

## Installation and Setup
1. Start up a fresh Jenkins.

    I typically download the generic java package (.war) file and run it from the command-line when testing, but if you already have Jenkins running, you just need the Job DSL Plugin installed.

    https://jenkins.io/download/

    ```
    $> java -jar jenkins.war
    ```

2. Install a few Jenkins Plugins

    **Navigate To:** Manage Jenkins > Manage Plugins > Available Tab

    1. Install Job DSL Plugin (id: job-dsl, documentation: https://plugins.jenkins.io/job-dsl)

    2. Install Authorize Project Plugin (id: authorize-project https://wiki.jenkins-ci.org/display/JENKINS/Authorize+Project+plugin)

    2. (Optional) Install Blue Ocean Plugin (id: blueocean https://plugins.jenkins.io/blueocean)

3. Restart Jenkins

4. Configure Authorize Project Plugin

    **Navigate To:** Manage Jenkins > Configure Global Security

    - Find the "Access Control for Builds" section
    - Click Add
    - Select "Project default Build Authorization"
    - Select "Run as User who Triggered Build"
    - Click "Save"

5. Create seed freestyle job

    - Click "New Item" from the left menu
    - Enter "seed" for "Enter an item name"
    - Select "Freestyle project"
    - Click "Ok"
    - General > Advanced > Display Name: #Seed (this is just so the seed job shows at the top of the list of jobs)
    - Source Code Management > Git > Repositories > Repository URL: https://github.com/bpmericle/gluecon-2018-JaC.git
    - Build > Process Job DSLs
        - Look on Filesystem > DSL Scripts:
          - ```
            src/jobs/hello_world.groovy
            src/pipelines/pipeline_demo.groovy
            ```
        - Use Groovy Sandbox: checked
        - Action for removed jobs: Delete
        - Action for removed views: Delete
        - Action for removed config files: Delete
    - Click "Build Now" in the left menu

## Jobs Created
1. Hello World Freestyle Job

    **Navigate To:** Jobs > Hello World Job DSL Example

    This job is your typical "Hello World" type of job. You input a name, and the job will echo back a greeting in the output log. You can find the source code for this job [here](src/jobs/hello_world.groovy).

2. Demo Declarative Pipeline Job

    **Navigate To:** Pipelines > Pipeline Example

    This pipeline job uses a declarative pipeline [Jenkinsfile](src/pipelines/Jenkinsfile) definition.

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
