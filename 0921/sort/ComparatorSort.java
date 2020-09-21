package com.training.session6.collection.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorSort {

	public static void main(String[] args) {
		List<Integer> datas = new ArrayList();		
		datas.add(45);
		datas.add(3);
		datas.add(24);
		datas.add(79);
		
		Collections.sort(datas, new NumberComparator());
		
		for(Integer data : datas){
			System.out.println(data);
		}
		
		System.out.println("---------------------------------");
		
		List<String> texts = new ArrayList();		
		texts.add("B");
		texts.add("D");
		texts.add("A");
		texts.add("C");
		
		Collections.sort(texts, new LetterComparator());
		
		for(String text : texts){
			System.out.println(text);
		}
	}

}

class NumberComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
//		if(o1 > o2){
//			return -1;
//		}
//		if(o1 < o2){
//			return 1;
//		}
		
//		return 0;
		
		return o2.compareTo(o1);
	}	
}

class LetterComparator implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o2.compareTo(o1);
	}
	
}
