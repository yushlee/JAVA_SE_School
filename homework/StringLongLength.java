package com.training.leetcode;

public class StringLongLength {

	public static void main(String[] args) {
		// 尋找共同最長的啟起字串內容
    	// Input: ["flower","flow","flight"]
    	// Output: "fl"
		String[] strs = new String[]{"flower","flow","flight"};
//		String[] strs = new String[]{"alower","blow","clight"};
		System.out.println(longestCommonPrefix(strs));
	}
	
    public static String longestCommonPrefix(String[] strs) {
    	String longestPrefix = "";
    	startsWithLab:{
    		if(strs.length > 0){
		    	for(int i = 0 ; i < strs[0].length() ; i++){
		    		String text = strs[0].substring(0, i + 1);
		    		for(String str : strs){    	
		    			if(!str.startsWith(text)){
		    				break startsWithLab;
		    			}
		    		}
		    		longestPrefix = text;
		    	}
    		}
    	}
    	
    	return longestPrefix;
    }
	
}
