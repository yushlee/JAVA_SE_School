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
		
		// 作法一：建立比較器實作介面 Comparator<T>
//		Collections.sort(books, new BookComparator());
		
		// 作法二：集合元素物件實作介面 Comparable<T>
		Collections.sort(books);
		
		for(Book book : books){
			System.out.println(book);
		}
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
