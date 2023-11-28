## About This Project

Micronaut-Starter-Basic - A basic starter project for Micronaut (v4.2.0)

This starter web application, written in Java using the Micronaut (https://micronaut.io/) framework provides a simple project template to get started quickly with a new Micronaut project.

This project was generated using Micronaut [Micronaut Launch](https://micronaut.io/launch/) and adds some example code:

- Domain objects with Lombok

- Support for runtime loading of .env files

- Sample service and controller classes

- Docker builds

### Getting started

* Rename the project package by refactoring the package name in your IDE, or by using the OpenRewrite gradle plugin - See: https://github.com/openrewrite/rewrite-docs/blob/master/reference/recipes/java/changepackage.md
  - Edit rewrite.yaml and set NewPackageName to your desired package name
  - Run: ./gradlew rewriteRun
* Note: Some artifacts need to be manually updated that reference micronaut-starter-basic
  - build.gradle - group and application.mainClass
  - application.yaml - micronaut.application.name, micronaut.processing.annotation 
  - Application.java - OpenAPIDefinition.info.title
  - settings.gradle - rootProject.name
  - Profile - jar name

### Configuration - Environment Variables

This app supports configuration via environment variables and loading via a .env file. Any environment variables present on startup, or contained in the .env file in the current working directory will be loaded at runtime.

Example .env file:

```
# Your custom ENV variable
CUSTOM_ENV_VARIABLE=value-goes-here

# Host the server will listen on - default = localhost
# Note: To run with Docker or on Heroku, this value will need to 
# be set to 0.0.0.0 
HOST=localhost

# Port the server will listen on - default = 8080
PORT=8080
```

When running from the command line and gradle, ```./gradlew run``` will load the .env file in the current working directory

To enable .env support in your IDE, using IntelliJ IDEA, you can add the following to your run configuration:

- Install the DotEnv plugin: https://plugins.jetbrains.com/plugin/9525-dotenv
- Enable the plugin by going to Run | Edit Configurations | [Created Configuration] | EnvFile tab | Check "Enable EnvFile"
- Set the path to the .env file in the "Path to .env file" field

## Development Environment

### Running the app

To start the app, run:

```
./gradlew run
```

![](https://eric-blue.com/micronaut-starter-basic/gradle_run.jpg?latest=4.2.0)

## Swagger

Swagger endpoints are available locally at http://localhost:8080/swagger-ui

## Docker

### Quick Start

Run:

```
docker run -p 8080:8080 --env-file .env  ericblue/micronaut-starter-basic:0.1
```

(note: replace ericblue/micronaut-starter-basic:0.1 with your own image name)

To enable external access with public URLs, if you are using something like ngrok (https://ngrok.com/) you can run:

```
ngrok http 8080
```

## Running on Heroku

This app has been tested on Heroku (https://heroku.com/) deploying as a Docker image and running with the Gradle buildpack.
For the application name, I used my-micronaut-starter-basic in this example, but you can use any name you like.

```
# Create a new Heroku app
heroku create my-micronaut-starter-basic

# Login to the container registry
heroku container:login

# Run a docker build
./gradlew dockerBuild

# CD to the build directory with the Dockerfile
cd build/docker/main

# Push the container
heroku container:push web -a my-micronaut-starter-basic

# Release the container
heroku container:release web -a my-micronaut-starter-basic

# Note: Make sure to set any required env cvariables var under Settings

# Open with the public URL
heroku open -a my-micronaut-starter-basic
```

## Author

This app was created by Eric Blue - [https://eric-blue.com](https://eric-blue.com/)
