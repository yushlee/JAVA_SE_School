package com.training.session6.fileStream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class FileOutputExp {

	public static void main(String[] args) {
		
		String[] texts = new String[]{"A","B","C","D"};
		
		File file = new File("dir/session6/source_out.txt");
		
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		BufferedWriter bw = null;
		try {
			fos = new FileOutputStream(file);
			osw = new OutputStreamWriter(fos);
			bw = new BufferedWriter(osw); 
			for(String text : texts){
				bw.write(text + "\n");
				bw.flush();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 資源建立的順序與關閉相反!
			try {
				if(bw != null) {bw.close();}
				if(osw != null) {osw.close();}
				if(fos != null) {fos.close();}
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}

	}

}
