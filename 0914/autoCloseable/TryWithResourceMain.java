package com.training.session6.autoCloseable;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class TryWithResourceMain {

	public static void main(String[] args) {
		
			/*
			Resource resource = null; 
			try {
				resource = new Resource();
				resource.work();
			} catch (Exception e) {	
				e.printStackTrace();
			} finally {
				if(resource != null){
					try {
						resource.close();
					} catch (Exception e) {
						e.printStackTrace();
					}					
				}
			}
			*/
			
			// try-with-resource 自動關閉資源
			try(
				Resource resource = new Resource();
				Resource2 resource2	 = new Resource2()
			){
				resource.work();
				resource2.work();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("--------------------------------------");
			
			// 相對路徑(class path(類別路徑) 同階層目錄)
			File file = new File("dir/session6/source.txt");
			try(FileInputStream fis = new FileInputStream(file);
				InputStreamReader isr = new InputStreamReader(fis);
				BufferedReader br = new BufferedReader(isr)){
				String text = null;
				while( (text = br.readLine()) != null ){
					System.out.println(text);
				}				
			} catch(FileNotFoundException ex){
				ex.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
	
	}

}


class Resource implements AutoCloseable {

	public Resource(){
		System.out.println("Resource1 create!");
	}
	
	public void work()throws Exception{
		System.out.println("Resource1 work!");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Resource1 is close !!!");		
	}
	
}


class Resource2 implements AutoCloseable {

	public Resource2(){
		System.out.println("Resource2 create!");
	}
	
	public void work()throws Exception{
		System.out.println("Resource2 work!");
	}
	
	@Override
	public void close() throws Exception {
		System.out.println("Resource2 is close !!!");		
	}
	
}
