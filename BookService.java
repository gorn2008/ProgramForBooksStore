package com.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.Book;
import com.store.BookStore;

public class BookService {
	
	public static File directory = new File(BookStore.DIRECTORY_FOR_JSONS);
	
	static {
		if (!directory.exists()) {
			directory.mkdir();
		}
	}

	
	public static List<JSONObject> loadBooks() throws IOException {
		List<JSONObject> result = new LinkedList<JSONObject>();
		
		File[] files = directory.listFiles();
		if(files != null) {
			for (File f : files) {				
				FileReader fr = new FileReader(f);			
				JSONObject JSONObjectForCurrentFile = new JSONObject(fr.readAllAsString());	
				result.add(JSONObjectForCurrentFile);				
			}
		}
		
		return result;
	}
	
	public static List<String> listBooks() {
		List<String> result = new LinkedList<String>();
			File[] files = directory.listFiles();
			if (files != null) {
				for (File f : files) {	
					result.add(f.getName().substring(0, f.getName().length()-5));
				}
			}
		return result;
	}
	
	public static void addBook(Book book) throws IOException {
		book.setBookId(getNewBookId(book.getBookName()));
		BookStore.saveBook(book);		
	}
	
	public static int getNewBookId(String bookName) throws JSONException, IOException {
		File[] files = directory.listFiles();
		if (files != null) {
			for (File f : files) {	
				if (f.getName().equals(bookName + ".json")) {
					FileReader fr = new FileReader(f);			
					JSONObject JSONObjectForCurrentFile = new JSONObject(fr.readAllAsString());	
					try {
						int i = JSONObjectForCurrentFile.getInt(Book.JSON_BOOK_ID_KEY);
						return i;
					}
					catch (Exception e) {
						return files.length + 1;
					}
				}
			}
			return files.length + 1;
		}
		return 1;
	}
	
	public static Book getBookByName(String bookName) throws JSONException, IOException {
		File[] files = directory.listFiles();
		if (files != null) {
			for (File f : files) {	
				if (f.getName().equals(bookName + ".json")) {
					FileReader fr = new FileReader(f);			
					JSONObject JSONObjectForCurrentFile = new JSONObject(fr.readAllAsString());	
					return Book.getBook(JSONObjectForCurrentFile);
				}
			}
		}
		return null;
	}

}
