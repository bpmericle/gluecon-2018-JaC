# Run Jenkins as a Docker Container

## Official Container Image
You can find the instructions for running the official Jenkins image [here](https://github.com/jenkinsci/docker/blob/master/README.md).

## Custom Container Image (Based on Official Image + Plugins)
This is a [custom Jenkins image](src/docker/jenkins/Dockerfile) that I have created that includes the plugins and tools required for the demo.

    docker run -p 8080:8080 -p 50000:50000 bpmericle/jenkins-with-plugins:latest

If you want the Jenkins instance to persist restarts, you can add a [volume](https://docs.docker.com/storage/volumes/) mount.

    docker run -p 8080:8080 -p 50000:50000 -v jenkins_home:/var/jenkins_home bpmericle/jenkins-with-plugins:latest
