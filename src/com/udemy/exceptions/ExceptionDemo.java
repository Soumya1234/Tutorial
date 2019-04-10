package com.udemy.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionDemo {
	public static void main(String[] args) {
		System.out.println("\nInside main...");
		try {
			share();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Inside main's catch block for: FileNotFoundException");
			e.printStackTrace();
		}
		catch(IOException e) {
			System.out.println("Inside main's catch block for: IOException");
		}
		System.out.println("\nEnd of main...");
	}

	private static void share()  throws FileNotFoundException,IOException  {
		System.out.println("\nInside share...");
		try {
			HttpConnect.send(0,"hello","https://www.goodsnips.com");
			System.out.println("\nThis won't be printed if an exception is thrown");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("\nInside share's catch block for: FileNotFoundException");
			//e.printStackTrace();
			//throw e;
		}
//		catch(IOException e) {
//			System.out.println("Inside share's catch block for: IOException");
//		}
		finally {
			System.out.println("\nInside share's finally block");
		}
		System.out.println("\nEnd of share...");
		
	}
	
	
}
