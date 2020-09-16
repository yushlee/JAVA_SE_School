package com.training.session6.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileRemoveAndCopySimpleFileVisitor {
	public static void main(String[] args) throws IOException {
		// 要複製的來源路徑
		Path pFromOri = Paths.get("dir/session6").toAbsolutePath();
		// 要複製的目標路徑
		Path copyTo = Paths.get("dir/session6_target").toAbsolutePath();
//		Files.createDirectories(copyTo);
		
		// 使用 Files walkFileTree 搭配 FileVisitor 對檔案目錄進行遞迴(複製)操作
		// 先建立目標資料夾(preVisitDirectory)再建立檔案(visitFile)
		Files.walkFileTree(pFromOri, new FileCopyVisitor(copyTo));
		
		// 使用 Files walkFileTree 搭配 FileVisitor 對檔案目錄進行遞迴(刪除)操作
		// 先刪除檔案(visitFile)再刪除資料夾(postVisitDirectory)		
		Files.walkFileTree(copyTo, new FileRemoveVisitor());
	}
}

