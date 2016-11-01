package com.sapient.ace.ankit.producerconsumer.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		Thread producerThread = new Thread(producer, "Producer Thread");
		producerThread.setDaemon(true);
		producerThread.start();
		
		Thread consumerThread = new Thread(consumer, "Consumer Thread");
		consumerThread.setDaemon(true);
		consumerThread.start();
	}

}
