# Team Planner (aka Trello)

This tool is useful for planning and organizing people work.


## How to start development?
1. Run MySQL database in a docker container (or install it separately as a standalone app):
    ```$bash
    docker run -d \
        --name=planner-db \
        -p 3306:3306 \
        -e MYSQL_DATABASE=planner \
        -e MYSQL_ROOT_PASSWORD=111 \
        mysql:5.7 \
            --character-set-server=utf8mb4 \
            --collation-server=utf8mb4_unicode_ci
        
    ```
2. ...  
[TODO]