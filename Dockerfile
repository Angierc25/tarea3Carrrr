# Usa una imagen con Java y Maven
FROM maven:3.9.4-eclipse-temurin-21 AS build

# Crea una carpeta para la app
WORKDIR /app

# Copia los archivos del proyecto
COPY pom.xml .
COPY src ./src

# Compila el proyecto y crea el .jar
RUN mvn clean package -DskipTests

# Usa una imagen más ligera con Java para correr la app
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia el jar compilado desde la etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Puerto que expone tu app (ajusta si usas otro)
EXPOSE 8080

# Comando para ejecutar
CMD ["java", "-jar", "app.jar"]