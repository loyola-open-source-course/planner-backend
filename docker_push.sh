#!/bin/bash
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker build -t saniaky/planner-api:${TRAVIS_BUILD_NUMBER} .
docker push saniaky/planner-api:${TRAVIS_BUILD_NUMBER}