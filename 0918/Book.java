package com.training.session6.collection;

public class Book {
	public Book(String name, int isbn) {
		super();
		this.name = name;
		this.isbn = isbn;
	}
	// 書名
	private String name;
	// 書號
	private int isbn;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + isbn;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (isbn != other.isbn)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", isbn=" + isbn + "]";
	}		
}
