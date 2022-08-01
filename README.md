# TO API CONSUMERS
You can use these endpoints: http://localhost:8888/swagger-ui/#/pokemon-controller


# TO API DEVELOPERS
1. Build the image with: `docker build -t heytrade/pokedex:latest .`
2. Run the image with `docker run -t -p 8888:8888 --name pokedex heytrade-pokemon-rest:1.0` or `docker-compose up`