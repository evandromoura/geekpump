#!/bin/sh
mvn clean package && docker build -t br.com/geekpump .
docker rm -f geekpump || true && docker run -d -p 8080:8080 -p 4848:4848 --name geekpump br.com/geekpump 
