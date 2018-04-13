# gluecon-2018-JaC
This repository includes the source code and presentation that I delivered at Gluecon 2018.

## Checklist
1. Start up a fresh Jenkins.

    https://jenkins.io/download/

2. Install Job DSL Plugin (id: job-dsl, documentation: https://plugins.jenkins.io/job-dsl)

    Manage Jenkins > Manage Plugins > Available Tab > Filter using "job-dsl"

3. Install Authorize Project Plugin (id: authorize-project, documentation: https://plugins.jenkins.io/authorize-project)

    Manage Jenkins > Manage Plugins > Available Tab > Filter using "authorize-project"

4. Install HTML Publisher Plugin (id: htmlpublisher, documentation: https://plugins.jenkins.io/htmlpublisher)

    Manage Jenkins > Manage Plugins > Available Tab > Filter using "htmlpublisher"

5. Setup Authorize Project Plugin

    Manage Jenkins > Configure Global Security > Access Control for Builds > Add > Project default Build Authorization: Run as User who Triggered Build

6. Create seed freestyle job

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

7. Setup 'pipeline-lib' Global Library

    - Manage Jenkins > Configure System > Global Pipeline Libraries > Add
        - Library
            - Name: pipeline-lib
            - Default version: master
        - Retrieval Method
            - Modern SCM > Git > Project Repository: https://github.com/bpmericle/gluecon-2018-JaC.git

8. Add Java and Maven tool configurations

    - Manage Jenkins > Configure Tool Configuration
        - JDK > Add JDK
            - Name: jdk8
            - Install from java.sun.com
                - Select the newest JDK 8 version
                - I agree to the Java SE Development Kit License Agreement: checked
                - Installing JDK requires Oracle account. Click on the link and enter Oracle credentials. (This is b/c Oracle considers this an older JDK, and want you to accept the warranty as such)
      - Maven > Add Maven
          - Name: maven3
      - Click "Save"
