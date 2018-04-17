# gluecon-2018-JaC
This repository includes the source code and presentation that I delivered at Gluecon 2018.

## Checklist
1. Start up a fresh Jenkins.

    I typically download the generic java package (.war) file and run it from the command-line. https://jenkins.io/download/

    ```
    $> java -jar jenkins.war
    ```

2. Install a few Jenkins Plugins

    *Navigate:* Manage Jenkins > Manage Plugins > Available Tab

    1. Install Job DSL Plugin (id: job-dsl, documentation: https://plugins.jenkins.io/job-dsl)

    2. Install Authorize Project Plugin (id: authorize-project, documentation: https://plugins.jenkins.io/authorize-project)

3. Setup Authorize Project Plugin

    *Navigate:* Manage Jenkins > Configure Global Security

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
            src/main/seed.groovy
            src/main/jobs/hello_world.groovy
            src/main/pipelines/demo.groovy
            ```
        - Use Groovy Sandbox: checked
        - Action for removed jobs: Delete
        - Action for removed views: Delete
        - Action for removed config files: Delete
    - Click "Build Now" in the left menu

5. Setup 'pipeline-lib' Global Library

    *Navigate:* Manage Jenkins > Configure System > Global Pipeline Libraries > Add

    - Library
        - Name: pipeline-lib
        - Default version: master
    - Retrieval Method
        - Modern SCM > Git > Project Repository: https://github.com/bpmericle/gluecon-2018-JaC.git
