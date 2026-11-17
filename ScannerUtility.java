package com.util;

import static java.lang.System.out;

import java.util.Scanner;


public class ScannerUtility {
	private static Scanner scanner = new Scanner(System.in);
	
	public static Integer getInteger() {
		Integer result = null;
		while (true) {
			String input = scanner.nextLine();
			try {
				result = Integer.parseInt(input);
				break;
			} catch (NumberFormatException e) {
				out.println("The data entered is not Integer number."
						+ "Please enter Integer number.");
			}
		}
		return result;
	}
	
	public static Double getDouble() {
		Double result = null;
		while (true) {
			String input = scanner.nextLine();
			try {
				result = Double.parseDouble(input);
				break;
			} catch (NumberFormatException e) {
				out.println("The data entered is not Double number."
						+ "Please enter Double number.");
			}
		}
		return result;
	}
	
	public static Byte getByte() {
		Byte result = null;
		while (true) {
			String input = scanner.nextLine();
			try {
				result = Byte.parseByte(input);
				break;
			} catch (NumberFormatException e) {
				out.println("The data entered is not Byte number."
						+ "Please enter Byte number.");
			}
		}
		return result;
	}
	
	public static Boolean getBoolean() {
		String input = scanner.nextLine();
		return Boolean.parseBoolean(input);
	}
	
	public static String getString() {
		return scanner.nextLine();
	}
	
	public static Scanner getScanner() {
		return scanner;
	}
	
	public static void closeScanner() {
		scanner.close();
	}
	

}