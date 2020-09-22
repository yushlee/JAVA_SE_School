package com.training.session6.collection;


public class TreeSetSort {

	public static void main(String[] args) {
		// 姓名-身高-資產
		// 排序規則:按「資產」、「身高」降羃排序，最後按「姓名」升羃排序
		// 排除重覆的資料
		// 輸出結果：
		// [Ace-175-350, Cameron-180-200, Abel-177-200, Aaron-175-200, Caesar-175-200, Chance-175-200, Felix-175-200, Ford-175-200, Frank-175-200]

		String[] datas = new String[]{
			"Aaron-175-200","Ford-175-200","Frank-175-200",
			"Cameron-180-200","Chance-175-200","Felix-175-200",
			"Caesar-175-200","Ace-175-350","Abel-177-200",
			"Aaron-175-200","Chance-175-200","Felix-175-200"
		};
		

	}

}

class User {
	
	private String name;
	private Integer height;
	private Integer assets;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getHeight() {
		return height;
	}
	public void setHeight(Integer height) {
		this.height = height;
	}
	public Integer getAssets() {
		return assets;
	}
	public void setAssets(Integer assets) {
		this.assets = assets;
	}
	
	@Override
	public String toString() {		 
		return name + "-" + height + "-" + assets;
	}	
}
