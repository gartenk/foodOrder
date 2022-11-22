# 

## Model
www.msaez.io/#/storming/LhmqXY7Td7dNGaj2zfi4RPe73bm2/1df170bc06d56095db6b7d07560fc02b

## Before Running Services
### Make sure there is a Kafka server running
```
cd kafka
docker-compose up
```
- Check the Kafka messages:
```
cd kafka
docker-compose exec -it kafka /bin/bash
cd /bin
./kafka-console-consumer --bootstrap-server localhost:9092 --topic 
```

## Run the backend micro-services
See the README.md files inside the each microservices directory:

- app
- pay
- store
- customer


## Run API Gateway (Spring Gateway)
```
cd gateway
mvn spring-boot:run
```

## Test by API
- app
```
 http :8088/주문 id="id" 품목="품목" 수량="수량" 
 http :8088/orders id="id" item="item" qty="qty" price="price" orderState="orderState" address="address" receiver="receiver" moblieNo="moblieNo" 
```
- pay
```
 http :8088/결제이력 id="id" orderId="orderId" 금액="금액" 
 http :8088/payments id="id" orderId="orderId" price="price" aprovaled="aprovaled" canceled="canceled" address="address" receiver="receiver" mobileNo="mobileNo" 
```
- store
```
 http :8088/주문관리 id="id" 
 http :8088/orders id="id" orderId="orderId" item="item" qty="qty" address="address" receiver="receiver" mobileNo="mobileNo" deliveryState="deliveryState" 
```
- customer
```
```


## Run the frontend
```
cd frontend
npm i
npm run serve
```

## Test by UI
Open a browser to localhost:8088

## Required Utilities

- httpie (alternative for curl / POSTMAN) and network utils
```
sudo apt-get update
sudo apt-get install net-tools
sudo apt install iputils-ping
pip install httpie
```

- kubernetes utilities (kubectl)
```
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl
```

- aws cli (aws)
```
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install
```

- eksctl 
```
curl --silent --location "https://github.com/weaveworks/eksctl/releases/latest/download/eksctl_$(uname -s)_amd64.tar.gz" | tar xz -C /tmp
sudo mv /tmp/eksctl /usr/local/bin
```

