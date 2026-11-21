package com;

import static java.lang.System.out;

import java.io.IOException;
import com.service.BookService;
import com.util.ScannerUtility;
import java.util.List;

public class BookStoreProgram {
	
	public final static String STORE_MESSAGE = "Books Store console application.";
	public final static String CYCLE_MESSAGE = "Select action to do (add, edit, sell, list, show, exit)";
	public final static String ENTER_BOOK_NAME_MESSAGE = "Please enter book name.";
	public final static String ENTER_BOOK_AUTHOR_MESSAGE = "Please enter book author.";
	public final static String ENTER_BOOK_YEAR_MESSAGE = "Please enter book year.";
	public final static String ENTER_BOOK_PRICE_MESSAGE = "Please enter book price.";
	public final static String ENTER_BOOK_QUANTITY_MESSAGE = "Please enter book quantity.";
	
	public final static String ENTER_PASSWORD_MESSAGE = "Please enter password.";
	public final static String ENTER_PASSWORD_MESSAGE_2 = "Your password is incorrect. Please try again.";
	public final static String APPLICATION_TERMINATED_MESSAGE = "All attempts to enter password are used. The application is terminated.";
	public final static String PASSWORD = "superstore";
	
	public static void main(String[] args) throws IOException {	
		out.println(STORE_MESSAGE);		
		BookService bookService = new BookService();		
		if (isAdminAuthentificated()) {			
			while (true) {
				out.println(CYCLE_MESSAGE);
				String userInput = ScannerUtility.getString();
				if ("add".equals(userInput)) {
					Book book = new Book();	
					out.println(ENTER_BOOK_NAME_MESSAGE);
					book.setBookName(ScannerUtility.getString());
					out.println(ENTER_BOOK_AUTHOR_MESSAGE);
					book.setBookAuthor(ScannerUtility.getString());	
					out.println(ENTER_BOOK_YEAR_MESSAGE);
					book.setBookYear(ScannerUtility.getInteger());	
					out.println(ENTER_BOOK_PRICE_MESSAGE);
					book.setBookPrice(ScannerUtility.getDouble());	
					out.println(ENTER_BOOK_QUANTITY_MESSAGE);
					book.setBookQuantity(ScannerUtility.getInteger());
					BookService.addBook(book);		
					out.println("Book was saved");
					continue;
				}
				if ("list".equals(userInput)) {
					List<String> booksList = BookService.listBooks();
					for (String bookName : booksList) {
						out.println(bookName);
					}
					continue;
				}
				if ("show".equals(userInput)) {
					out.println(ENTER_BOOK_NAME_MESSAGE);
					Book book = BookService.getBookByName(ScannerUtility.getString());
					if (book != null) {
						out.println("Book information:");
						out.println(Book.JSON_BOOK_ID_KEY + ":" + book.getBookId());
						out.println(Book.JSON_BOOK_NAME_KEY + ":" + book.getBookName());
						out.println(Book.JSON_BOOK_AUTHOR_KEY + ":" + book.getBookAuthor());
						out.println(Book.JSON_BOOK_PRICE_KEY + ":" + book.getBookPrice());
						out.println(Book.JSON_BOOK_YEAR_KEY + ":" + book.getBookYear());
						out.println(Book.JSON_BOOK_QUANTITY_KEY + ":" + book.getBookQuantity());
					} else {
						out.println("The book was not found.");
					}
					continue;
				}
				if ("exit".equals(userInput)) {
					break;		
				}				
			}
		
		} else {
			out.println(APPLICATION_TERMINATED_MESSAGE);
		}
	}
	
	private static boolean isAdminAuthentificated() {
		boolean result = false;
		out.println(ENTER_PASSWORD_MESSAGE);
		
		if (ScannerUtility.getString().equals(PASSWORD)) {
			result = true;
		} else {
			out.println(ENTER_PASSWORD_MESSAGE_2);
			if (ScannerUtility.getString().equals(PASSWORD)) {
				result = true; 
			} else {
				out.println(ENTER_PASSWORD_MESSAGE_2);
				if (ScannerUtility.getString().equals(PASSWORD)) {
					result = true; 
				}
			}
		}		
		return result;
	}
	

}
