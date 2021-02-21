# TechVault 

TechVault is a website to browse through the engineering blogs of software companies and computer science related papers.

## Prerequisites

- Java 8+


## Steps to create docker image
1. `./gradlew clean build`
2. `./imageBuilder.sh`
3.  `docker build --build-arg DEPENDENCY=build/dependency -t techvaulthub/techvault:<tag> .`
4.  `docker run -p 8080:8080 techvaulthub/techvault:<tag>`
