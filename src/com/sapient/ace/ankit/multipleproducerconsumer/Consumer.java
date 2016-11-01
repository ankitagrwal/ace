package com.sapient.ace.ankit.multipleproducerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	
	private BlockingQueue<Integer> queue;
	
	public Consumer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				int consumedNum = queue.take();
				System.out.println(Thread.currentThread().getName()+" consumed number:"+consumedNum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
