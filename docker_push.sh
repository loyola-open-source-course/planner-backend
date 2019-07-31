#!/bin/bash

echo ${DOCKER_USER}
echo ${TRAVIS_BUILD_NUMBER}

# Login to repository
docker login -u "$DOCKER_USER" -p "$DOCKER_PASSWORD"

# Build image
docker build -t "saniaky/planner-api:$TRAVIS_BUILD_NUMBER" .

# Push to repository
docker push "saniaky/planner-api:$TRAVIS_BUILD_NUMBER"
