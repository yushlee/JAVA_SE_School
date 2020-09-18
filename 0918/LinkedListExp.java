package com.training.session6.collection;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExp {
	public static void main(String[] args) {
//		如果物件加入之後大都是為了取出，而不會常作移除或插入（Insert）的動作，則使用ArrayList，
//		如果會經常從容器中作移除或插入物件的動作，則使用LinkedList會獲得較好的效能。
//		LinkedList實作了List介面，並增加了一些移除與插入物件的特定方法，
//		像是addFirst()、addLast()、 getFirst()、getLast()、removeFirst( )、removeLast()
//		ps:LinkedList 資料不具排序性、具順序性、具重複性		
		LinkedList list = new LinkedList();
		list.add("B");
		list.add("C");
		list.addFirst("A");
		list.addLast("D");
		list.removeFirst();
		list.removeLast();
		showList(list);
	}
	
	private static void showList(List list) {
		for(int index = 0 ; index < list.size() ; index++) {
			String data = (String) list.get(index);
			System.out.println("index_"+ index +":" + data);
		}
	}
}
