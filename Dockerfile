# Etapa 1: Build con Gradle 8.14.2 y JDK 21 (compilacion)
FROM gradle:8.14.2-jdk21 AS build
COPY --chown=gradle:gradle . /app

# AJUSTE 1: Nos movemos a la subcarpeta interna donde realmente está tu código y el build.gradle
WORKDIR /app/platzi-play

# AJUSTE 2: Agregamos '-x test' para saltar las pruebas que buscan tu Docker local
RUN gradle bootJar --no-daemon -x test

# Etapa 2: Runtime con JDK 21 (ejecución)
FROM eclipse-temurin:21-jdk
WORKDIR /app

# AJUSTE 3: Apuntamos a la nueva ruta de la subcarpeta para copiar el .jar generado
COPY --from=build /app/platzi-play/build/libs/*.jar platzi_play.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "platzi_play.jar"]