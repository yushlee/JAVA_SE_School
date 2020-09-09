package com.training.session6.a;

public abstract class 女孩 {
	
	// 抽象方法
	 abstract void 結婚();	
	 abstract void 交往();
	 abstract void 認識();
	
	
	
	public final void 追女孩的流程(){
		// 呼叫的次數、順序
		認識();
		交往();
		結婚();
	}
}
