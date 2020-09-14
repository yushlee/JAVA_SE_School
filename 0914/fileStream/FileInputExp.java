package com.training.session6.fileStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileInputExp {

	public static void main(String[] args) {
//		File file = new File("C://Users//shang//Desktop//Resources//workspace//JavaSE8//FirstProject//src//com//training//session6//fileStream//source.txt");
		// 絕對路徑
//		File file = new File("C:/Users/shang/Desktop/Resources/workspace/JavaSE8/FirstProject/dir/session6/source.txt");
		// 相對路徑(class path(類別路徑) 同階層目錄)
		File file = new File("dir/session6/source.txt");
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			// 1.檔案輸入串流(位元串流)
			fis = new FileInputStream(file);
			// 2.輸入讀取串流(字元串流)
			isr = new InputStreamReader(fis); 
			// 3.緩存讀取(字元串流)
			br = new BufferedReader(isr);
			
			String text = null;
//			System.out.println(text);
			while( (text = br.readLine()) != null ){
				System.out.println(text);
			}
			
		} catch(FileNotFoundException ex){
			ex.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 資源建立的順序與關閉相反!
				if(br != null) { br.close(); }
				if(isr != null) { isr.close(); }
				if(fis != null) { fis.close(); }				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
