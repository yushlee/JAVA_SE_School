package com.training.session6.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeExample {

	public static void main(String[] args) {
		Path path = Paths.get("dir/session6").toAbsolutePath();
		try {
			Files.walkFileTree(path, new PrintTree());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}


class PrintTree implements FileVisitor<Path> {
	
	// 讀取目錄前要做的事
	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
			throws IOException {
		
		System.out.println("讀取「目錄前」要做的事:" + dir);
		
		return FileVisitResult.CONTINUE;
	}
	
	// 讀取檔案時要做的事
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {
		
		System.out.println("讀取「檔案時」要做的事:" + file);
		
		return FileVisitResult.CONTINUE;
	}
	
	// 讀取目錄後要做的事
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException exc)
			throws IOException {
		
		System.out.println("讀取「目錄後」要做的事:" + dir);
		
		return FileVisitResult.CONTINUE;
	}
	
	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc)
			throws IOException {

		return FileVisitResult.CONTINUE;
	}


	
}
