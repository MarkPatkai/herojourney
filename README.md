# Hero Journey - Web based fighter game

## Quick Start
### Database


````
docker run --detach --name herojourney-mariadb -p 3306:3306 --env MYSQL_USER=admin --env MYSQL_DATABASE=herojourney --env MYSQL_PASSWORD=heroes --env MYSQL_ROOT_PASSWORD=heroes  mariadb:10.6
````

