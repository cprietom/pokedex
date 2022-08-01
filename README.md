# POKEDEX
This project provides an API REST to access the HeyTrade Pokedex.

## TO API DEVELOPERS
1. Create the JAR with `./gradlew.bat build`
2. Build the docker image and run a container with it inside with: `docker-compose up`
3. Access the swagger docs here: http://localhost:8888/swagger-ui/#/pokemon-controller

## TO API CONSUMERS
Once you have deployed the service following the instructions of the previous section:
- All endpoints are exposed under: http://localhost:8888/v1/pokedex
- Try them here: http://localhost:8888/swagger-ui/#/pokemon-controller
