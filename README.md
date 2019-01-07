# Repast AMONG Model Backend
## Overview
This project provides a RESTful backend to make the [AMONG Repast model](https://github.com/gaschwanden/AMONG) interactive via a web interface.

## Usage
The project can be built directly using the Java 1.8 SDK and Maven to package into an executable JAR:
```
mvn clean package
``` 
It can also be built and packaged into a Docker container directly, without any Java/Maven specific dependencies:
```docker
docker build -t repast-amongmodel-0.1.0-SNAPSHOT
```