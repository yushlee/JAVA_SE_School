package com.training.session7.lambda.streamApi;

import java.util.ArrayList;
import java.util.List;

public class ListDefaultMethod {

	public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        
        // Java 8 List 所提供的 default method
        strings.replaceAll(s -> s.toUpperCase());
        
        System.out.println(strings);

        strings.sort((o1, o2) -> o2.compareTo(o1));
        
        System.out.println(strings);
		
	}

}
