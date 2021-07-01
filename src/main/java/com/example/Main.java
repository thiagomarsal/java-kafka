package com.example;

import java.util.UUID;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.example.consumer.ConsumerCreator;
import com.example.producer.ProducerCreator;

public class Main {

	public static void main(String[] args) {
		runProducer();
		runConsumer();
	}

	public static void runConsumer() {
		Consumer<String, String> consumer = ConsumerCreator.createConsumer();
		ConsumerRecords<String, String> consumerRecords = consumer.poll(1000);
		
		try {
			consumerRecords.forEach(record -> {
				System.out.println(String.format("Record key=%s, partition=%s, offset=%s, value=%S", record.key(), record.partition(), record.offset(), record.value()));
			});
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			consumer.close();
		}
		
	}

	public static void runProducer() {
		Producer<String, String> producer = ProducerCreator.createProducer();

		try {
			for (int i = 0; i < 10; i++) {
				producer.send(new ProducerRecord("topic-name", UUID.randomUUID().toString(), "test message - " + i));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}

}
