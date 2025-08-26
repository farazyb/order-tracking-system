# syntax=docker/dockerfile:1.7

########## 1) BUILD STAGE ##########
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /workspace

# Copy only the module's pom first to warm the cache (downloads deps)
COPY product-service/pom.xml product-service/pom.xml

# Optional: if you have a settings.xml for private repos, uncomment:
# COPY .mvn/ .mvn/
# COPY mvnw .
# COPY settings.xml /root/.m2/settings.xml

# Go offline to cache dependencies (faster incremental builds)
RUN --mount=type=cache,target=/root/.m2 \
    mvn -f product-service/pom.xml -B -ntp -DskipTests dependency:go-offline

# Now copy the sources
COPY product-service/src/ product-service/src/

# Build the JAR
RUN --mount=type=cache,target=/root/.m2 \
    mvn -f product-service/pom.xml -B -ntp -DskipTests package

########## 2) RUNTIME STAGE ##########
FROM eclipse-temurin:21-jre
WORKDIR /app

# (Optional) labels
LABEL org.opencontainers.image.title="product-service" \
      org.opencontainers.image.description="Spring Boot service" \
      org.opencontainers.image.source="https://github.com/<you>/<repo>"

# Copy the built JAR from the build stage
# Adjust the glob if your final JAR name is different
COPY --from=build /workspace/product-service/target/*.jar /app/app.jar


EXPOSE 8080

# Health-friendly entrypoint with overridable JVM options
ENTRYPOINT ["sh", "-c", "java  -jar /app/app.jar"]
