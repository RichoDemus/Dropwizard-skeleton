FROM frolvlad/alpine-oraclejdk8:latest

COPY *.jar /
COPY *.yml /

CMD ["java", "-jar", "/dropwizard-skeleton-1.0-SNAPSHOT.jar", "server", "/hello-world.yml"]
EXPOSE 8080
