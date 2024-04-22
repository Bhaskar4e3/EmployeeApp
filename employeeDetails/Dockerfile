FROM openjdk:17-alpine
WORKDIR /opt
ENV PORT 8181
EXPOSE 8181
COPY target/EmployeeApp.exe.jar /opt/EmployeeApp.exe.jar
ENTRYPOINT exec java $JAVA_OPTS -jar EmployeeApp.exe.jar
