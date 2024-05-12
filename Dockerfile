FROM azul/zulu-openjdk-alpine:17
EXPOSE 8080

COPY target/*.jar ZenyeraDataProvider.jar
ENTRYPOINT ["java","-jar","/ZenyeraDataProvider.jar"]