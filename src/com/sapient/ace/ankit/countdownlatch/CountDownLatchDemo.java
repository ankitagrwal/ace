package com.sapient.ace.ankit.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String args[]) {
       final CountDownLatch latch = new CountDownLatch(3);
       Thread cacheService = new Thread(new Service("CacheService", latch));
       Thread alertService = new Thread(new Service1("AlertService", latch));
       Thread validationService = new Thread(new Service2("ValidationService", latch));
      
       cacheService.start(); //separate thread will initialize CacheService
       alertService.start(); //another thread for AlertService initialization
       validationService.start();
      
       try{
            latch.await();  //main thread is waiting on CountDownLatch to finish
            System.out.println("All services are up, Application is starting now");
       }catch(InterruptedException ie){
           ie.printStackTrace();
       }
      
    }
  
}


/**
 * Service class which will be executed by Thread using CountDownLatch synchronizer.
 */
class Service implements Runnable{
    private final String name;
    private final CountDownLatch latch;
  
    public Service(String name, CountDownLatch latch) {
		super();
		this.name = name;
		this.latch = latch;
	}
  
    @Override
    public void run() {
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
  
}

class Service2 implements Runnable{
    private final String name;
    private final CountDownLatch latch;
  
    public Service2(String name, CountDownLatch latch) {
		super();
		this.name = name;
		this.latch = latch;
	}
  
    @Override
    public void run() {
    	System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
  
}

class Service1 implements Runnable{
    private final String name;
    private final CountDownLatch latch;
  
    public Service1(String name, CountDownLatch latch) {
		super();
		this.name = name;
		this.latch = latch;
	}

    @Override
    public void run() {
        System.out.println( name + " is Up");
        latch.countDown(); //reduce count of CountDownLatch by 1
    }
  
}


