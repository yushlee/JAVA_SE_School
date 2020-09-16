package com.training.session6.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class FileCopyVisitor extends SimpleFileVisitor<Path> {
	
	private final Path targetPath;
	private Path sourcePath = null;

	public FileCopyVisitor(Path targetPath) {
		this.targetPath = targetPath;		
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		if (sourcePath == null) {
			sourcePath = dir;
			System.out.println("sourcePath:" + sourcePath.toString());
			System.out.println("targetPath:" + targetPath.toString());
			System.out.println("============================================================\n");
		} else {			
			System.out.println("dir:" + dir.toString());			
			// ●  relativize 方法建構2路徑間的路徑
			// 取得「來源路徑」至「來源路徑下目錄」的切換路徑,達到取得子目錄名稱並建立資料夾
			System.out.println("sourcePath.relativize(dir):" + sourcePath.relativize(dir).toString());
			// ● resolve 方法結合2個路徑
			// 若傳入「相對路徑」，則將該「相對路徑」連接在「原路徑」之後
			// 若傳入「絕對路徑」，則方法回傳該「絕對路徑」
			System.out.println("targetPath.resolve(sourcePath.relativize(dir)):" + targetPath.resolve(sourcePath.relativize(dir)).toString());
			System.out.println("============================================================\n");
			
			// 於targetPath底下建立相對應於sourcePath底下的子目錄
			Files.createDirectories(targetPath.resolve(sourcePath.relativize(dir)));
		}
		
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		Files.copy(file, targetPath.resolve(sourcePath.relativize(file)), LinkOption.NOFOLLOW_LINKS);
		//System.out.println(file + " -> " + targetPath.resolve(sourcePath.relativize(file)));
		return FileVisitResult.CONTINUE;
	}
	
}