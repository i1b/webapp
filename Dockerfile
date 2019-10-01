FROM tomcat:8.0-alpine
LABEL maintainer="doc@do.c"
ADD target/webapp-1.0-SNAPSHOT.war /usr/local/tomcat/webapps/
EXPOSE 8080
CMD ["catalina.sh", "run"]