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
