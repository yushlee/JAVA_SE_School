package folder1.folder2.folderOne;

import folder1.folder2.folderTwo.C;
//import folder1.folder2.folderThree.C;

public class B {

	public static void main(String[] args) {
		// 同一Package不須import
		A a = new A();
		// 位於不同Package則必須import
		// folderTwo
		C cOne = new C();
		// 同名類別不同Package須宣告完整Package路徑
		// folderThree
		folder1.folder2.folderThree.C cTwo = new folder1.folder2.folderThree.C();
	}

}
