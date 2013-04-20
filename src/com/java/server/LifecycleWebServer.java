package com.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

class LifecycleWebServer {
	private static final int NTHREADS = 100;
    private final ExecutorService exec = Executors.newFixedThreadPool(NTHREADS);

    public void start() throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (!exec.isShutdown()) {
            try {
                final Socket conn = socket.accept();
                exec.execute(new Runnable() {
                    public void run() { handleRequest(conn); }
                });
            } catch (RejectedExecutionException e) {
                if (!exec.isShutdown())
                    System.out.println("task submission rejected");
            }
        }
    }

    public void handleRequest(Socket connection) {
        Request req = readRequest(connection);
        if (isShutdownRequest(req))
            stop();
        else
            dispatchRequest(req);
    }
    
    public void stop() { exec.shutdown(); }
    
    public Request readRequest(Socket connection) {
		System.out.println("handling request");
		return null;
	}
    
    public void dispatchRequest(Request req) {
		System.out.println("handling request");
	}
    
    private boolean isShutdownRequest(Request req){
    	return false;
    }
}