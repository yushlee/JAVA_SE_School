package com.training.session6.nio;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
//import static java.nio.file.StandardOpenOption.*;
import java.util.List;

public class FileReadWriteAllLineTest {
	public static void main(String[] args) throws IOException {

		Path source = Paths.get("dir/session6/C.txt").toAbsolutePath();
		Charset cs = Charset.defaultCharset();
		List<String> lines = Files.readAllLines(source, cs);
		
		for(String line : lines){
			System.out.println(line);
		}
		
		Path target = Paths.get("dir/session6/C_Output.txt").toAbsolutePath();
		Files.write(target, lines, cs,
			// 如果目的檔案不存在就建立
			StandardOpenOption.CREATE, 
			// 檔案內容附加
			StandardOpenOption.APPEND
		);
		
		System.out.println("done...");

	}

}
