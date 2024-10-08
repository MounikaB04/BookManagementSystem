package com.bms;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Welcome to Book Management Syatem");
		Scanner sc = new Scanner(System.in);
		char response;
		do {
			System.out.println("1.AddBook 2.GetBook 3.UpdateBook 4.DeleteBook 5.SearchBookByName 6. SortByName");
			
			System.out.println("Select any option");
			int option = sc.nextInt();
			switch(option) {
			case 1: System.out.println(BookUtil.addBook(sc));
				break;
			case 2: BookUtil.getBooks();
				break;
			case 3: System.out.println(BookUtil.updateBook(sc));
				break;
			case 4: System.out.println(BookUtil.deleteBook(sc));
				break;
			case 5: System.out.println(BookUtil.searchBookByName(sc));
				break;
			case 6: BookUtil.sortBook();
				break;
			default: System.out.println("Invalid option");
			
			}
			
			System.out.println("Do you want to continue?y/n");
			response = sc.next().charAt(0);
		}while(response =='y');
		System.out.println("Thanks for using BMS");
	}

}
