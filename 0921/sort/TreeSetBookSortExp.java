package com.training.session6.collection.sort;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSetBookSortExp {

	public static void main(String[] args) {
		// 加入 TreeSet 當中的所有集合原素都必須實作 Interface Comparable，同時兼顧二者元素"重複性"、"排序性"
		
		Set<Book> books = new TreeSet<>();
		books.add(new Book("B", 1));
		books.add(new Book("B", 2));
		books.add(new Book("B", 3));
		books.add(new Book("C", 3));
		books.add(new Book("C", 2));
		books.add(new Book("C", 1));		
		books.add(new Book("A", 3));
		books.add(new Book("A", 2));
		// Set 的特性「不允許」元素重覆
		books.add(new Book("A", 1));
		books.add(new Book("A", 1));
		books.add(new Book("A", 1));
		books.add(new Book("A", 1));
		
		for(Book book : books){
			System.out.println(book);
		}
		
		System.out.println(books.size());
		
		System.out.println("----------------------------------------");
		
		Map<Book, Object> booksMap = new TreeMap<>();
		booksMap.put(new Book("B", 1),null);
		booksMap.put(new Book("B", 2),null);
		booksMap.put(new Book("B", 3),null);
		booksMap.put(new Book("C", 3),null);
		booksMap.put(new Book("C", 2),null);
		booksMap.put(new Book("C", 1),null);		
		booksMap.put(new Book("A", 3),null);
		booksMap.put(new Book("A", 2),null);
		// TreeMap 的特性「不允許」元素重覆
		booksMap.put(new Book("A", 1),null);
		booksMap.put(new Book("A", 1),null);
		booksMap.put(new Book("A", 1),null);
		booksMap.put(new Book("A", 1),null);
		
		for(Book book : booksMap.keySet()) {
			System.out.println(book);
		}
	}

}
