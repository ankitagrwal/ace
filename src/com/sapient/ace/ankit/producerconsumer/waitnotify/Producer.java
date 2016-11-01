package com.sapient.ace.ankit.producerconsumer.waitnotify;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
	
	private List<Integer> queue;
	
	public Producer(List<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=1; i<6; i++) {
				synchronized (queue) {
					while(queue.size()==5) {
						System.out.println("Queue is full, so "+Thread.currentThread().getName()+ " will wait.");
						try {
							queue.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
						Random random = new Random();
						int randomNum = random.nextInt(100);
						queue.notify();
						System.out.println(Thread.currentThread().getName()+" produced number:"+randomNum);
						queue.add(randomNum);
				}
		}
	}

}
