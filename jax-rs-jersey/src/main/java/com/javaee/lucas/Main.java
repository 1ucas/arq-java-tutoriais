package com.javaee.lucas;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Main {
	
	public static final String BASE_URI = "http://localhost:8080/";

	public static void main(String[] args) throws IOException {
		final HttpServer server = startServer();
		System.out.println("Iniciou");
		System.in.read();
		server.shutdown();
	}
	
	public static HttpServer startServer() {
		final ResourceConfig config = new ResourceConfig().packages("com.javaee.lucas.controllers");
		
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), config);
	}
	

}
