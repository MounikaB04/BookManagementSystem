package com.bms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BookUtil {

	static List<Book> list = null;
	
	static {
		list = new ArrayList<>();
		
	}
	//add books
	public static String addBook(Scanner sc) {
		System.out.println("Enter the bookId");
		int bookId = sc.nextInt();
		
		System.out.println("Enter the bookName");
		String bookName = sc.next();
		
		System.out.println("Enter the authorName");
		String authorName = sc.next();
		
		System.out.println("Enter the bookPrice");
		int bookPrice = sc.nextInt();
		
		
		if(bookId >0 && bookName != null && bookName != ""&& authorName != null && authorName !=""&& bookPrice>0) {
			Book b = new Book(bookId, bookName, authorName, bookPrice);
			list.add(b);
			return "Book added successfully";
		}
		
		return "Something went wrong";
	}
	
	//read books
	public static void getBooks() {
		System.out.println("Fetching all records:");
		System.out.println("______________");
		if(list.isEmpty()) {
			System.out.println("list is empty");
			return;
		}
		for(int i=0;i<list.size();i++) {
			System.out.println("BookId :"+ list.get(i).getBookId());
			System.out.println("BookName :"+ list.get(i).getBookName());
			System.out.println("AuthorName :"+ list.get(i).getAuthorName());
			System.out.println("BookPrice:"+ list.get(i).getBookPrice());
			System.out.println("____________________");
		}
	}
	
	//update book
	public static String updateBook(Scanner sc) {
		System.out.println("Enter the bookId to update");
		int bookId = sc.nextInt();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBookId() == bookId) {
				System.out.println("Enter the bookName");
				String bookName = sc.next();
				System.out.println("Enter the authorName");
				String authorName = sc.next();
				System.out.println("Enter the bookPrice");
				int bookPrice = sc.nextInt();
				
				Book updatedBook = new Book();
				
				updatedBook.setBookId(bookId);
				updatedBook.setBookName(bookName);
				updatedBook.setAuthorName(authorName);
				updatedBook.setBookPrice(bookPrice);
				
				list.set(i, updatedBook);
			
				return "Book updated Successfully";
			}
		}
		return "No book found updated";
	}
	
	//delete book
	
	public static String deleteBook(Scanner sc) {
		System.out.println("Enter bookId to delete ");
		int bookId = sc.nextInt();
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getBookId() == bookId) {
				list.remove(i);
				
				return "Book deleted successfully";
			}
		}
		return "No book found to delete";
	}
	
	//search functionality
	
	public static String searchBookByName(Scanner sc) {
		System.out.println("Enter the book name to Search");
		String bookName = sc.next();
		for(int i=0; i<list.size();i++) {
			if(list.get(i).getBookName().equalsIgnoreCase(bookName)) {
				System.out.println(list.get(i));
				return "Book found";
			}
		}
		return " Book not found";
	}
	
	//sorting by name
	
	public static void sortBook() {
		System.out.println("After sorting :");
		Collections.sort(list, new SortByName());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}

}
