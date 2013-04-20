package com.java.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// Best for light to moderate load
public class ThreadPerTask {
	public static void main(String[] args) throws IOException{
		ServerSocket socket = new ServerSocket(80);
		while(true){
			final Socket connection = socket.accept();
			Runnable task = new Runnable(){
				public void run(){
					handleRequest(connection);
				}
			};
			new Thread(task).start();
		}
	}

	public static void handleRequest(Socket conn){
		System.out.println("handled");
	}
}