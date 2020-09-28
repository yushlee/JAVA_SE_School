package com.training.session7.lambda.streamApi;

public class Person {
	
	private String name, email;
	private int age;

	private Person(Person.Builder builder) {
		this.name = builder.name;
		this.age = builder.age;
		this.email = builder.email;
	}
	
	/**
	 * Builder pattern 建構者模式
	 * 可避免使用帶參數建構子時參數值誤傳,比如name給成email,
	 * 因為兩個欄位型別相同,所以再使用上就容易指定錯欄位
	 */
	public static class Builder {
		private String name = "", email = "";
		private int age = 0;
		public Person.Builder name(String name) {
			this.name = name;
			return this;
		}
		public Person.Builder age(int val) {
			this.age = val;
			return this;
		}
		public Person.Builder email(String val) {
			this.email = val;
			return this;
		}
		public Person build() {
			return new Person(this);
		}
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "Person[name=" + name + ", email=" + email + ", age=" + age + "]";
	}	
}
