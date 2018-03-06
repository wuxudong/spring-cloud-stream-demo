mvn clean package

java -jar sender/target/sender-1.0-SNAPSHOT.jar --server.port=10000


# start two receivers in one group1
java -jar receiver1/target/receiver1-1.0-SNAPSHOT.jar --server.port=10001

java -jar receiver1/target/receiver1-1.0-SNAPSHOT.jar --server.port=10002


# start another receiver in  group2
java -jar receiver2/target/receiver2-1.0-SNAPSHOT.jar --server.port=10003

curl -l -H "Content-type:application/json" -X POST -d '{"msg":"Hello","name":"RabbitMQ"}' http://localhost:10000/send