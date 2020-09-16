package com.training.session6.nio;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class WalkFileTreeExample {

	public static void main(String[] args) {
//		Path path = Paths.get("D:/").toAbsolutePath();
		Path path = Paths.get("dir/session6").toAbsolutePath();
		
		try {
//			Files.walkFileTree(path, new PrintTree());
			
			Files.walkFileTree(path, new SimplePrintTree());
			
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

//		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{mp4,mov,avi,flv,wmv,mkv}");
		Path fileName = file.getFileName();
		if(matcher.matches(fileName)){
			System.out.println(fileName + " 吼! 抓到了吼!");
		}else{
			System.out.println(fileName + " not Java file");
		}
		
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


class  SimplePrintTree  extends  SimpleFileVisitor<Path> {
	
	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
			throws IOException {


		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.java");
//		PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*.{mp4,mov,avi,flv,wmv,mkv}");
		Path fileName = file.getFileName();
		if(matcher.matches(fileName)){
			System.out.println(file);
		}
		
		return FileVisitResult.CONTINUE;
	}
	
}
