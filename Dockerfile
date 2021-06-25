####
# This Dockerfile is used in order to build a container that runs the Quarkus application in JVM mode
#
FROM registry.access.redhat.com/ubi8/openjdk-11
USER root

WORKDIR /deployments/
COPY target/*.jar /deployments/application.jar
RUN chmod 775 /deployments /deployments/application.jar \
  && chown -R 1001 /deployments \
  && chmod -R "g+rwX" /deployments \
  && chown -R 1001:root /deployments
EXPOSE 8080
USER 1001
CMD java -jar /deployments/*.jar -Dquarkus.http.host=0.0.0.0



