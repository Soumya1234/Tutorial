package com.udemy.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HttpConnect {

	public static void send(int destination, String data, String url) throws FileNotFoundException,IOException {
		System.out.println("\nInside send...");
		if(destination == 0) {
			throw new IOException();
		}
		
	}

}
