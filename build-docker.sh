#!/bin/bash
rm -rf target/
rm librarian-docker
mvn clean package
mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)
docker system prune -f
docker rmi $(docker images |grep 'lms/librarian'|cut -d" " -f1)
docker build -t lms/librarian .
docker save -o librarian-docker lms/librarian
chown marc:marc librarian-docker
