FROM nginx:1.23.3

ENV API_URL http://gateway_service:8080/api

EXPOSE 80

ADD dist/lab5_aui /usr/share/nginx/html/
ADD docker/etc/nginx/templates/ /etc/nginx/templates/
