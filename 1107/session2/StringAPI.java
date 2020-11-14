package com.training.session2;

public class StringAPI {
	public static void main(String[] args) {
		System.out.println("--------------------String API--------------------");
		//                       012345678910
		String str = new String("i Love Java");
		
		System.out.println(str);
		// 字串長度
		System.out.println("String length:"+str.length());
		// 取出指定索引值的字元
		System.out.println(str.charAt(2)); 
		// 回傳所查尋的字元位置,如果找不到回傳-1
		System.out.println(str.indexOf("ve")); 
		System.out.println(str.indexOf('a'));
		System.out.println(str.indexOf('z'));
		
		// 是否包含所指定的字串
		System.out.println(str.contains("Love"));
		System.out.println(str.contains("love"));
		
		// 是否為指定的啟始字串內容
		
		System.out.println(str.startsWith("i Love"));
		System.out.println(str.startsWith("I Love"));
		System.out.println(str.endsWith("Java"));
		System.out.println(str.endsWith("java"));
		
		
		// 最後一個字元的索引值
		System.out.println(str.lastIndexOf('a')); 
		// 傳回指定索引值後的字串
		System.out.println(str.substring(4));
		// 傳回所指定的起始及結束索引值的字元
		System.out.println(str.substring(4, 8));		
				
		// replace:找到所指定搜尋的字,取代為指定的字
		String name = "李昱賞";		
		System.out.println(name.replace("昱", "X"));

		
		// replaceFirst:找到所指定搜尋的字,取代為指定的字
		// PS:以搜尋到的第一個字
		String nameOne = "郭祥祥";
		System.out.println(nameOne.replaceFirst("祥", "X"));		
		// replaceAll:只要搜尋到指定的字,就全部取代為指定的字
		// replaceAll、replace差別在於replaceAll 支援 Regular expression(正規表示式)
		System.out.println(nameOne.replaceAll("祥", "X"));
		
		// 指定字元切割String字串
		String text = "A,B,C,D";
		String[] texts = text.split(","); 
		System.out.println(texts[0]);
		System.out.println(texts[1]);
		System.out.println(texts[2]);
		System.out.println(texts[3]);
		
		String strText = "ABDE";
		int endIndex = strText.length();
		String endText = strText.substring(endIndex-2, endIndex);
		
		System.out.println("-------------------- StringBuilder、StringBuffer API --------------------");
		// 實務面上應使用StringBuilder會獲得較好的效能及避免不必要的創建字串實例
		// StringBuilder vs StringBuffer
		// 在不需考量多執行緒同步(非執行緒安全)的時候我們使用 StringBuilder來獲得最佳的效率
		// 要考慮多執行緒的情況下使用StringBuffer來讓類別自動處理同步的問題(thread safe 執行緒安全)
		StringBuilder sb = new StringBuilder();
//		 StringBuffer sb = new StringBuffer();
		// 將指定字串加入
		sb.append("String1,");
		sb.append("String2,");
		sb.append("String3");
		System.out.println(sb.toString());
		// 於指定的索引位置加入文字 
		sb.insert(8, "String5,");
		System.out.println(sb.toString());
		// 刪除指定索引區間文字
		sb.delete(8, 16);
		System.out.println(sb.toString());
		System.out.println(sb.length());
		
		
		sb.replace(8, 16, "String7,");
		System.out.println(sb.toString());
		
		// 將文字結果顛倒
		System.out.println(sb.reverse().toString());
	}
}

