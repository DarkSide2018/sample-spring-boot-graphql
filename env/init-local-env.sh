#!/bin/bash
echo "=========================="
echo "Creating postgres"
echo "----------------"

docker container stop neuro-names-postgres

pip install --upgrade pip
pip install natasha

echo "=========================="
echo "launch docker"
echo "----------------"

docker container rm neuro-names-postgres

docker run --name neuro-names-postgres   \
             -e POSTGRES_USER=migration     \
             -e POSTGRES_PASSWORD=123456    \
             -e POSTGRES_DB=neuro_db -p 5451:5432 \
             -v ./env/sql:/docker-entrypoint-initdb.d \
             -v ./env/data:/data \
             -d postgres