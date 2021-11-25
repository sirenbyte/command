FROM openjdk:8-jre-alpine
MAINTAINER Abzal <a.tuganbay@p-s.kz>

ENV TZ=Asia/Almaty
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ARG JAR_FILE
ADD ./target/command-0.0.1-SNAPSHOT.jar /app/
EXPOSE 9091
ENTRYPOINT ["java","-XX:+UnlockExperimentalVMOptions","-jar","/app/command-0.0.1-SNAPSHOT.jar"]