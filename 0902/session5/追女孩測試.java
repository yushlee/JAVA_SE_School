package com.training.session5;

public class 追女孩測試 {

	public static void main(String[] args) {
		// 各類別之間各自為政，可能會導致商業邏輯上順序的引用錯誤
		大喬  孫策 = new 大喬();
//		 孫策.認識();
//		 孫策.交往();		 
//		 孫策.結婚();
		追女孩(孫策); 
		
		 System.out.println("----------------------------");
		 
		 小喬 周瑜 = new 小喬();
//		 周瑜.認識();
//		 周瑜.交往();
//		 周瑜.結婚();
		 追女孩(周瑜);
		 
		 // 小轉大
		 女孩 girl_1 = new 大喬();
		 女孩 girl_2 = new 小喬();
		 
		 大喬 girl_3 = (大喬) new 女孩();

	}
	
	
	public static void 追女孩(女孩 girl){
		girl.認識();
		girl.交往();
		girl.結婚();
	}

}
