package com.training.session6.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BookSortExp {

	public static void main(String[] args) {
		
		List<Book> books = new ArrayList<>();
		books.add(new Book("B", 1));
		books.add(new Book("B", 2));
		books.add(new Book("B", 3));
		books.add(new Book("C", 3));
		books.add(new Book("C", 2));
		books.add(new Book("C", 1));		
		books.add(new Book("A", 3));
		books.add(new Book("A", 2));
		books.add(new Book("A", 1));
		// List 的特性「允許」元素重覆
		books.add(new Book("A", 1));
		books.add(new Book("A", 1));
		books.add(new Book("A", 1));
		books.add(new Book("A", 1));
		
		// 作法一：建立比較器實作介面 Comparator<T>
//		Collections.sort(books, new BookComparator());
		
		// 作法二：集合元素物件實作介面 Comparable<T>
//		Collections.sort(books);
		
		// 作法三：搭配作法一使用建立 Anonymous Class 匿名者類別
		Collections.sort(books, new Comparator<Book>(){
			public int compare(Book b1, Book b2) {
				// 主排序:數字由小到大、次排序:字母由大到小
				int isbnCompare = b1.getIsbn().compareTo(b2.getIsbn());
				int nameCompare = b2.getName().compareTo(b1.getName());
				int resultCompare = (isbnCompare == 0) ? nameCompare : isbnCompare;
				
				return resultCompare;
			}
		});
		
		System.out.println(books.size());
		
		for(Book book : books){
			System.out.println(book);
		}
		
		// Anonymous Class 匿名者類別
		AnonymousInterface anonymous = new AnonymousInterface() {
			@Override
			public String anonymousMethod() {
				
				return "Hello Word!!!";
			}			
		};
		
		System.out.println(anonymous.anonymousMethod());
	}

}

class BookComparator implements Comparator<Book>{
	@Override
	public int compare(Book b1, Book b2) {
		// 主排序:數字由小到大、次排序:字母由大到小
		int isbnCompare = b1.getIsbn().compareTo(b2.getIsbn());
		int nameCompare = b2.getName().compareTo(b1.getName());
		int resultCompare = (isbnCompare == 0) ? nameCompare : isbnCompare;
		
		return resultCompare;
	}
}

interface AnonymousInterface {
	
	public String anonymousMethod();
	
}

class Concrete implements AnonymousInterface{

	@Override
	public String anonymousMethod() {
		
		return null;
	}
	
}
