# Multistage Dockerfile.
# Use a multi-stage build to minimize image size.
## Builder Stage: build operation using Maven - download dependencies, source code compilation, and JAR creation.
## Runtime Stage: copy only the generated JAR into the smaller runtime image.

# -------- Build Stage - 1st stage - build the app --------
# Step 1: Use jdk-no-fee base image for building the app.
FROM container-registry.oracle.com/java/jdk-no-fee-term:21 AS build
#RUN mvn --version && echo "DEBUG 1"

# Step 2: Set working directory for Maven.
WORKDIR /usr/share

# Step 3: Install Maven.
RUN set -x && \
    curl -O https://archive.apache.org/dist/maven/maven-3/3.8.4/binaries/apache-maven-3.8.4-bin.tar.gz && \
    tar -xvf apache-maven-*-bin.tar.gz  && \
    rm apache-maven-*-bin.tar.gz && \
    mv apache-maven-* maven && \
    ln -s /usr/share/maven/bin/mvn /bin/
#RUN mvn --version && echo "DEBUG 2"

# Step 4: Set working directory for application.
WORKDIR /workspace

# Step 5: Copy pom.xml
COPY pom.xml .

# Step 6: Download dependencies to leverage Docker cache.
# Create a first layer to cache the "Maven World" in the local repository.
# This layer is cached and only re-executed if pom.xml changes.
# Incremental docker builds will always resume after that, unless you update the pom.
RUN mvn dependency:go-offline

# Step 7: Copy source code.
COPY src ./src

# Step 8: Compile and package the Spring Boot application.
# Do the Maven build.
# Incremental docker builds will resume here when you change sources.
RUN mvn clean package -DskipTests

# Step 9
RUN echo "Build Stage Done!"

# -------- Runtime Stage - 2nd stage - build the runtime image --------

# Step 10: Use a smaller base image for runtime (to minimize size).
FROM container-registry.oracle.com/java/jdk-no-fee-term:21

# Step 11: Set working directory.
WORKDIR /workspace

# Step 12: add JVM options.
# Using Environment Variables (Recommended)
# Using an environment variable is often preferred as it allows the options to be easily overridden at runtime without rebuilding the Docker image.
# JDK_JAVA_OPTIONS: This environment variable is read automatically by the JVM (since Java 10) and is the most modern, recommended approach.
ENV JDK_JAVA_OPTIONS="-Dusing_env_docker1=this -Dusing_env_docker2=is -Dusing_env_docker3=recommended -Dusing_env_docker4=approach"

ENV JAVA_OPTS="-Dusing_java_opts_hardcoded_docker1=hardcoded1 -Dusing_java_opts_hardcoded_docker2=hardcoded2 -Dusing_java_opts_hardcoded_docker3=hardcoded3 -Dusing_java_opts_hardcoded_docker4=hardcoded4"

# Step 13: Copy the jar from build stage.
COPY --from=build /workspace/target/docker-demo-1.0.0.jar ./

# Step 14: Expose the port your application will run on.
EXPOSE 8080

# Step 15: Run the Spring Boot application.
ENTRYPOINT exec java \
           -jar \
           -Dusing_entrypoint_hardcoded_docker1=hardcoded5 -Dusing_entrypoint_hardcoded_docker2=hardcode6 -DSPRING_APPLICATION_NAME=local-docker-demo \
           $JAVA_OPTS \
           docker-demo-1.0.0.jar

# docker --version
# Docker version 28.1.1-rd, build 4d7f01e

# docker build --progress=plain --no-cache -t spring-boot-app-docker-demo:latest .
# --no-cache                       Do not use cache when building the image.
#  --progress string               Set type of progress output ("auto", "quiet", "plain", "tty", "rawjson"). Use plain to show container output (default "auto").

# docker images
# REPOSITORY                                          TAG                    IMAGE ID       CREATED         SIZE
# spring-boot-app-docker-demo                         latest                 912f617c88f4   2 minutes ago   648MB

# docker run -p 8080:8080 -e "JDK_JAVA_OPTIONS=-Dusing_env_docker3=correct -Dusing_env_docker4=way" -e "JAVA_OPTS=-Dusing_java_opts_hardcoded_docker2=hardcoded20 -Dusing_java_opts_hardcoded_docker3=hardcoded30" spring-boot-app-docker-demo
# docker run -p 8080:8080 spring-boot-app-docker-demo