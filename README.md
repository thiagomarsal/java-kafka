Apache Kafka
---------------------------------------------------

Tools used:
-----------

* Maven 3.5
* Apache Kafka 2.8.0
* Java 11

Apache Kafka
-

<https://kafka.apache.org/downloads>

Start Kafka
-
	./bin/zookeeper-server-start.sh config/zookeeper.properties
	./bin/kafka-server-start.sh config/server.properties

Create Topic
-
	./bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 3 --topic topic-name
	./bin/kafka-topics.sh --list --zookeeper localhost:2181

Listening Topic
-
	./bin/kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic topic-name


Respository
---------

Clone the repository:

    $ git clone https://github.com/thiagomarsal/java-kafka.git