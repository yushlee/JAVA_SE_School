package com.training.session6.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HashSetExp {
	public static void main(String[] args) {
//		Set容器中的物件都是唯一的，加入 Set容器中的物件都必須重新定義equals()方法，作為唯一性的識別。
//		Set容器有自己的一套排序規則，HashSet的排序規則是利用"Hash Table"。
//		所以加入HashSet容器的物件還必須重新定義hashCode()方法，在比較兩個加入Set容器中的物件是否相同時，
//		會先比較hashCode()方法傳回的值是否相同，如果相同，則再使用equals()方法比較，如果兩者都相同，則視為相同的物件。		
//		HashSet 元素具排序性、不具順序性、不具重複性 
		
		Set set = new HashSet();
		set.add("D");
		set.add("B");
		set.add("D");
		set.add("A");
		set.add("C");
		showListToIterator(set);
		
		System.out.println("--------------------------------------------------");
		
		Book book1 = new Book("JavaSE技術手冊", 111);
		Book book2 = new Book("Servlet & JSP教學手冊", 222);
		Book book3 = new Book("jQuery實戰手冊", 333);
		Book book4 = new Book("Spring 2.0 技術手冊", 555);
		Book book5 = new Book("Spring 2.0 技術手冊", 555);
		
		Set books = new HashSet();
		// 若想要依所加入的順序為排列的順序可使用"LinkedHashSet"
		// books = new LinkedHashSet();
		
		books.add(book1);
		books.add(book2);
		books.add(book3);
		books.add(book4);
		books.add(book5);
		showAllBook(books);
	}
	
	private static void showListToIterator(Set set) {
		
//		Iterator iterator = set.iterator();
		
//		boolean hasNext = iterator.hasNext();
//		if(hasNext){
//			String c  = (String)iterator.next();
//			System.out.println(c);
//		}
		
//		while(iterator.hasNext()){
//			String c  = (String)iterator.next();
//			System.out.println(c);
//		}
		
		for( Iterator i = set.iterator(); i.hasNext(); ){
			String c  = (String)i.next();
			System.out.println(c);
		}
		
		// 使用Iterator來走訪Set內容
//		for(Iterator iterator = set.iterator(); iterator.hasNext();) {
//			Object data = iterator.next();
//			System.out.println("value:" + data + " HashCode:" + data.hashCode());
//		}
	}
	
	private static void showAllBook(Set set) {
		// 使用Iterator來走訪Set內容
		for(Iterator iterator = set.iterator(); iterator.hasNext();) {
			Book book = (Book) iterator.next();
			System.out.println(book.toString());
//			System.out.println(String.valueOf(book.hashCode()) + " : " + book );
		}
	}
}
