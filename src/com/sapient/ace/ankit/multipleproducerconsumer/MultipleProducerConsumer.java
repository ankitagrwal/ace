package com.sapient.ace.ankit.multipleproducerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MultipleProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(50);
		for(int i=0; i<5; i++) {
			Thread t = new Thread(new Producer(queue), "Producer Thread-"+i);
			t.setDaemon(true);
			t.start();
		}
		for(int i=0; i<5; i++) {
			Thread t = new Thread(new Consumer(queue), "Consumer Thread-"+i);
			t.setDaemon(true);
			t.start();
		}
	}

}
