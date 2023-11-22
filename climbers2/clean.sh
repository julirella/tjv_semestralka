docker compose down
sudo rm -rf .docker/postgres-data/
mkdir .docker/postgres-data
docker rmi climbers2-backend:latest