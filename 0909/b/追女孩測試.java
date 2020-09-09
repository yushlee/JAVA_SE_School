package com.training.session6.b;

import com.training.session6.a.大喬;
import com.training.session6.a.女孩;
import com.training.session6.a.小喬;

public class 追女孩測試 {

	public static void main(String[] args) {
		// 修改前(各自為政)
//		大喬   wendy = new 大喬();
//		wendy.結婚();
//		wendy.交往();
//		wendy.交往();
//		wendy.交往();
//		wendy.認識();
		
//		小喬 rita = new 小喬();
//		rita.認識();
//		rita.交往();
//		rita.結婚();
		
		// 修改後
//		女孩  girl = new 大喬();
//		girl.追女孩的流程();
		
//		girl = new 小喬();
//		girl.追女孩的流程();
		
		test(new 大喬());
		test(new 小喬());
	}
	
	public static void test(女孩  girl){
//		girl.交往();
//		girl.交往();
//		girl.交往();
//		girl.交往();
		girl.追女孩的流程();
	}

}
