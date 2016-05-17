package com.zhou.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	Lock lock = new ReentrantLock();

	public static void main(String[] args) {
           final OutPutter1 output = new OutPutter1();
		new Thread() {

			@Override
			public void run() {
				output.output("zhansan");

			};
		}.start();
		
		new Thread(){
			
			public void run() {
				
				output.output("lisis");
			};
			
		}.start();

	}

}

class OutPutter1 {
	private Lock lock = new ReentrantLock();

	public void output(String name) {

		lock.lock();
		try {

			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		} finally {
			lock.unlock();
		}

	}

}