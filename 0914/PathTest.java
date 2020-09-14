package com.training.session6.nio;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathTest {

	private static void testSplit() {
		System.out.println("==================== testSplit() ====================");
		// Path 所建立的路徑無須實際存在
		Path p1 = Paths.get("Temp/Foo/file1.txt");
		System.out.format("getFileName: %s%n", p1.getFileName());
		// 取得檔案所在路徑
		System.out.format("getParent: %s%n", p1.getParent());
		// 檔案路徑階層數
		System.out.format("getNameCount: %d%n", p1.getNameCount());
		// 指定索引值取得檔案路徑(從零開始)
		System.out.format("getName index 0:%s%n", p1.getName(0).toString());
		System.out.format("getRoot: %s%n", p1.getRoot());
		// 是否為絕對路徑
		System.out.format("isAbsolute: %b%n", p1.isAbsolute());
		// 轉換為絕對路徑(以classpath為基礎)
		System.out.format("toAbsolutePath: %s%n", p1.toAbsolutePath());		
	}

	private static void testNormalize() {
		System.out.println("==================== testNormalize() ====================");
		// Normalize:路徑標準化
		// normalize方法可以移除路徑多餘的部份:「.」和「directory/..」，
		// 該方法只是語法上處理，不檢查實際檔案狀況。
		// 「.」代表目前目錄、「..」代表上一層目錄
		Path p1 = Paths.get("/home/./clarence/foo");
		p1 = p1.normalize();
		System.out.println(p1);
		Path p2 = Paths.get("/home/peter/../clarence/foo");
		p2 = p2.normalize();
		System.out.println(p2);
	}

	private static void testSubPath() {
		System.out.println("==================== testSubPath() ====================");
		// subpath可以取得路徑裡的部份路徑
		Path p1 = Paths.get("D:/Temp/foo/bar");
		p1.subpath(1, 3);
		System.out.println(p1);
		// beginIndex(索引值從零開始)
		// endIndex(索引值從一開始)
		p1 = p1.subpath(1, 3);
		System.out.println(p1);
	}

	private static void testResolve() {
		System.out.println("==================== testResolve() ====================");
		// resolve方法結合2個路徑
		// 若傳入「相對路徑」，則將該「相對路徑」連接在「原路徑」之後
		// 若傳入「絕對路徑」，則方法回傳該「絕對路徑」
		String p = "/home/clarence/foo";
		Path p1 = Paths.get(p).resolve("bar");
		System.out.println(p1);
		Path p2 = Paths.get(p).resolve("/home/clarence");
		System.out.println(p2);
	}

	private static void testRelativize() {
		System.out.println("==================== testRelativize() ====================");
		// relativize方法建構2路徑間的路徑
		Path p1 = Paths.get("peter");
		Path p2 = Paths.get("jim");
		System.out.println("p1 path:" + p1.toString());
		System.out.println("p2 path:" + p2.toString());
		// 由 p1 到 p2 的走法
		Path p1Top2 = p1.relativize(p2); 
		System.out.println("p1 To p2: " + p1Top2);
		// 由 p2 到 p1 的走法
		Path p2Top1 = p2.relativize(p1);
		System.out.println("p2 To p1: " + p2Top1);
	}

	private static void textComparePath() {
		System.out.println("==================== textComparePath() ====================");
		Path p1 = Paths.get("C:/A/jim/abc.txt");
		Path p2 = Paths.get("C:/A/jim/");
		System.out.println(p1.startsWith(p2));
		System.out.println(p1.endsWith(p2));
	}

	public static void main(String[] args) {
		testSplit();
		testNormalize();
		testSubPath();
		testResolve();
		testRelativize();
		textComparePath();
	}


}
