package com.training.session6.collection.sort;

public class Book {

	// 書名
	private String name;
	// 書號
	private Integer isbn;
	
	public Book(String name, Integer isbn) {
		this.name = name;
		this.isbn = isbn;
	}
	

	
	public String getName() {
		return name;
	}
	public Integer getIsbn() {
		return isbn;
	}
	
	@Override
	public String toString() {
		return "Book [name=" + name + ", isbn=" + isbn + "]";
	}
}
