package com.sapient.ace.ankit.multipleproducerconsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
	
	private BlockingQueue<Integer> queue;
	
	public Producer(BlockingQueue<Integer> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=1; i<51; i++) {
			try {
				Random random = new Random();
				int randomNum = random.nextInt(100);
				System.out.println(Thread.currentThread().getName()+" produced number:"+randomNum);
				System.out.println(Thread.currentThread().getName()+" daemon thread?:"+Thread.currentThread().isDaemon());
				queue.put(randomNum);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Queue:"+queue);
	}

}
