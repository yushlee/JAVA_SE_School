package com.training.session6.collection.sort;

// 作法二：集合元素物件實作介面 Comparable<T>
public class Book implements Comparable<Book>{

	// 書號
	private Integer isbn;
	
	// 書名
	private String name;
	
	public Book(String name, Integer isbn) {
		this.name = name;
		this.isbn = isbn;
	}	
	
	public Integer getIsbn() {
		return isbn;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", name=" + name + "]";
	}

	// 作法二：集合元素物件實作介面 Comparable<T>
	@Override
	public int compareTo(Book b2) {
		// 主排序:數字由小到大、次排序:字母由大到小
		int isbnCompare = isbn.compareTo(b2.getIsbn());
		int nameCompare = b2.getName().compareTo(name);
		int resultCompare = (isbnCompare == 0) ? nameCompare : isbnCompare;
		
		return resultCompare;
	}

}
