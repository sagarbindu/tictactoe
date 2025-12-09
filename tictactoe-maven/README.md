# Java Console Board Game – Tic Tac Toe (Maven + Docker + GitHub Actions)

This is a simple console-based Tic Tac Toe game written in **Java**, packaged with **Maven**, containerized with **Docker**, and built via **GitHub Actions**.

## Project Layout

```text
.
├── pom.xml
├── Dockerfile
├── README.md
├── src
│   └── main
│       └── java
│           └── com
│               └── example
│                   └── boardgame
│                       └── tictactoe
│                           ├── Board.java
│                           ├── Game.java
│                           ├── Player.java
│                           ├── HumanPlayer.java
│                           ├── ComputerPlayer.java
│                           └── TicTacToeApp.java
└── .github
    └── workflows
        └── maven-docker.yml
```

## Build and Run Locally (Maven)

```bash
# From project root
mvn clean package

# Run the game
java -jar target/tictactoe-1.0.0.jar
```

## Build and Run with Docker

```bash
# Build image
docker build -t java-board-game:latest .

# Run container (interactive)
docker run -it --rm java-board-game:latest
```

## Game Modes

- Player vs Player
- Player vs Computer (simple AI: tries to win, then block, else random)
