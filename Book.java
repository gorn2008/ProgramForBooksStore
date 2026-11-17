package com;

import org.json.JSONObject;

public class Book {
	
	public final static String JSON_BOOK_ID_KEY = "bookId";
	public final static String JSON_BOOK_NAME_KEY = "bookName";
	public final static String JSON_BOOK_AUTHOR_KEY = "bookAuthor";
	public final static String JSON_BOOK_PRICE_KEY = "bookPrice";
	public final static String JSON_BOOK_YEAR_KEY = "bookYear";
	public final static String JSON_BOOK_QUANTITY_KEY = "bookQuantity";

	Integer bookId;
	String bookName;
	String bookAuthor;
	Double bookPrice;
	Integer bookYear;
	Integer bookQuantity;
	
	public Book Book(JSONObject myJsonObject) {
		return getBook(myJsonObject);
	}
	
	public static Book getBook(JSONObject myJsonObject) {
		Book book = new Book();
		
		book.setBookId(myJsonObject.getInt(JSON_BOOK_ID_KEY));		
		book.setBookName(myJsonObject.get(JSON_BOOK_NAME_KEY).toString());
		book.setBookAuthor(myJsonObject.get(JSON_BOOK_AUTHOR_KEY).toString());
		book.setBookPrice(myJsonObject.getDouble(JSON_BOOK_PRICE_KEY));
		book.setBookYear(myJsonObject.getInt(JSON_BOOK_YEAR_KEY));
		book.setBookQuantity(myJsonObject.getInt(JSON_BOOK_QUANTITY_KEY));		
				
		return book;
	}
	
	public static JSONObject getJSONFromBook(Book book) {
		JSONObject myJsonObject = new JSONObject();
		
		myJsonObject.put(JSON_BOOK_ID_KEY, book.getBookId());
		myJsonObject.put(JSON_BOOK_NAME_KEY, book.getBookName());
		myJsonObject.put(JSON_BOOK_AUTHOR_KEY, book.getBookAuthor());
		myJsonObject.put(JSON_BOOK_PRICE_KEY, book.getBookPrice());
		myJsonObject.put(JSON_BOOK_YEAR_KEY, book.getBookYear());
		myJsonObject.put(JSON_BOOK_QUANTITY_KEY, book.getBookQuantity());
		
		return myJsonObject;
	}	
	
	public Integer getBookId() {
		return bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public Double getBookPrice() {
		return bookPrice;
	}
	public Integer getBookYear() {
		return bookYear;
	}
	public Integer getBookQuantity() {
		return bookQuantity;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public void setBookPrice(Double bookPrice) {
		this.bookPrice = bookPrice;
	}
	public void setBookYear(Integer bookYear) {
		this.bookYear = bookYear;
	}
	public void setBookQuantity(Integer bookQuantity) {
		this.bookQuantity = bookQuantity;
	}
		
	
}
