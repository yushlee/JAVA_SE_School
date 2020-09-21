package com.training.session7.generics.after;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericsObjectMain {

	public static void main(String[] args) {
		GenericsObject<Integer> object = new GenericsObject<Integer>();
		object.setValue(5);
		System.out.println(object.getValue());
		
		List<String> list = new ArrayList<>();
		list.add("A");
		list.add("B");
		list.add("C");
		
		for(String text : list){
			System.out.println(text);
		}
		
		Map< String,List<String> > rooms = new HashMap();
		String key = "A";
		List<String> value = new ArrayList<>();
		rooms.put(key, value);
		
//		Map< String,List<Map<String,String>>  > a = null;
		
	}

}
