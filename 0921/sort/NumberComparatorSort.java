package com.training.session6.collection.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberComparatorSort {

	public static void main(String[] args) {
		
		String[] numbers = new String[] {"5D","2A","1D","6J","6A","4K","8J","4A","3D"};
		List<String> texts = new ArrayList<>(Arrays.asList(numbers));
		
		
		for(String text : texts){
			System.out.println(text);
		}
	}

}
