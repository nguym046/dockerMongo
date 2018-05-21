# Usage: FROM [image name]
#The smallest Docker image with OracleJDK 8 (167MB), https://hub.docker.com/r/frolvlad/alpine-oraclejdk8/
FROM frolvlad/alpine-oraclejdk8:slim
# VOLUME pointing to "/tmp" because that is where a Spring Boot application creates working directories for Tomcat by default.
# The effect is to create a temporary file on your host under "/var/lib/docker" and link it to the container under "/tmp". This step is optional for the simple app that we wrote here,
# but can be necessary for other Spring Boot applications if they need to actually write in the filesystem.
VOLUME /tmp
#  It basically copies the files from the source on the host into the container's own filesystem at the set destination
ADD partyApi.jar app.jar
# RUN command to "touch" the jar file so that it has a file modification time (Docker creates all container files in an "unmodified" state by default).
# This actually isn’t important for the simple app that we wrote, but any static content (e.g. "index.html") would require the file to have a modification time.
RUN sh -c 'touch /app.jar'
# application specific
# environment mongo variables
ENV env.spring.data.mongodb.database party
ENV env.spring.data.mongodb.host 10.102.184.75
ENV env.spring.data.mongodb.port 27017
ENV env.spring.data.mongodb.username partyUser
ENV spring.data.mongodb.password partyOn
# environment rest variables
ENV env.host.api.uri https://qaapi.disneystore.com
ENV env.context.root /api/public
ENV env.partnerId=/5000001
# environment logging
ENV env.log.level=INFO
# To reduce Tomcat startup time we added a system property pointing to "/dev/urandom" as a source of entropy.
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
