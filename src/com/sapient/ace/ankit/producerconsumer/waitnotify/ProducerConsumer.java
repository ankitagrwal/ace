package com.sapient.ace.ankit.producerconsumer.waitnotify;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

	public static void main(String[] args) {
		List<Integer> queue = new ArrayList<Integer>(5);
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
