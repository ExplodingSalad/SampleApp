FROM azul/zulu-openjdk-alpine:17
EXPOSE 8080

COPY target/*.jar zenyeradataprovider.jar
ENTRYPOINT ["java","-jar","/zenyeradataprovider.jar"]