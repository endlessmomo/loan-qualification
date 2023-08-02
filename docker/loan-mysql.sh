docker run -d \
  --name loan-mysql \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_USER=soohyuk \
  -e MYSQL_PASSWORD=yuki0326.. \
  -e MYSQL_DATABASE=loan \
  -e TZ=Asia/Seoul \
  -p 3306:3306 \
  mysql:latest