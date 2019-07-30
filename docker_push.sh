#!/bin/bash

# Login to repository
echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin

# Build image
docker build -t saniaky/planner-api:${TRAVIS_BUILD_NUMBER} .

# Push to repository
docker push saniaky/planner-api:${TRAVIS_BUILD_NUMBER}
