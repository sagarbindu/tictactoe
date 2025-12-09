# Runtime-only image: JDK not required for compilation here
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

# Copy the JAR built by Maven
COPY target/tictactoe-1.0.0.jar app.jar

# Run the console Tic Tac Toe game
CMD ["java", "-jar", "app.jar"]
