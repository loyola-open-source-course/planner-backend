#!/bin/bash
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
docker push saniaky/planner-api:${TRAVIS_BUILD_NUMBER}