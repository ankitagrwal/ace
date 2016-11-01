package com.sapient.ace.ankit.producerconsumer.waitnotify;

import java.util.List;

public class Consumer implements Runnable {
	
	private List<Integer> queue;
	
	public Consumer(List<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		synchronized (queue) {
				while(queue.isEmpty()) {
					System.out.println("Queue is empty, so "+Thread.currentThread().getName()+ " will wait.");
					try {
						queue.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} 
				for(int i=0; i<5; i++) {
					int consumedNum = queue.get(i);
					System.out.println(Thread.currentThread().getName()+" consumed number:"+consumedNum);
					queue.notify();				
				}
			}
	}

}
