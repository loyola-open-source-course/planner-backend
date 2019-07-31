#!/usr/bin/env bash

docker run -d -p 3306:3306 --name planner-db -e MYSQL_ROOT_PASSWORD=123 -e MYSQL_DATABASE=planner mysql:5.7