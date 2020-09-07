package com.training.session5.exception;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionMultiCatch {

	public static void main(String[] args) {

		try {
			FileReader fr = new FileReader("C:/User.txt");
			Class account = Class.forName("com.training.session5.bank.finalPkg.User");
		} catch (FileNotFoundException | ClassNotFoundException  e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
