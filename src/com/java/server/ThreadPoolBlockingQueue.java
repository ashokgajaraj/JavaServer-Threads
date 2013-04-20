package com.java.server;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolBlockingQueue {

	// Thread constants
	// TODO Make these configurable
	private static final int THREAD_IDLE_TIME = 20;
	private static final int QUEUE_SIZE = 20;
	private static final int MIN_THREADS = 5;
	private static final int MAX_THREADS = 10;

	protected BlockingQueue queue = null;
	protected ThreadPoolExecutor ex = null;
	protected HashMap<String,String> analyticsOptions = null;

	protected ThreadPoolBlockingQueue() {
		queue = new ArrayBlockingQueue(QUEUE_SIZE);
		ex = new ThreadPoolExecutor(MIN_THREADS, MAX_THREADS, THREAD_IDLE_TIME, TimeUnit.SECONDS, queue);
	}

	public void startNewThread(){
		ThreadRunner runner = new ThreadRunner();
		ex.execute(runner);
	}

	// Class that processes and forwards the analytics data in a thread
	protected class ThreadRunner implements Runnable{

		@Override
		public void run() {
			// Do stuff
		}

	}

}