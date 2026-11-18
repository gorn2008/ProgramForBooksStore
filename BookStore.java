package com.store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONObject;

import com.Book;

public class BookStore {
	
	public final static String DIRECTORY_FOR_JSONS = "C://BooksRepository";
	
	
	public static void saveBook(JSONObject jsonObject) throws IOException {
		File f = new File(DIRECTORY_FOR_JSONS, jsonObject.getString(Book.JSON_BOOK_NAME_KEY) + ".json");
		
		if (!f.exists()) {
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(f);			
		jsonObject.write(fw);
		fw.close();
	}
	
	public static void saveBook(Book book) throws IOException {
		File f = new File(DIRECTORY_FOR_JSONS, book.getBookName() + ".json");
		
		if (!f.exists()) {
			f.createNewFile();
		}
		FileWriter fw = new FileWriter(f);
		JSONObject jsonObject = Book.getJSONFromBook(book);
		jsonObject.write(fw);		
		fw.close();	
	}

}
