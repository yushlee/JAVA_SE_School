package com.training.session7.lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

public class OptionalDemo {

	public static void main(String[] args) {
		// 以往資料回傳需加上判斷式以避免NullPointerException問題發生,且經常可能會忘記要加上判斷式
		String value = getMapValue("KeyD");
		System.out.println(value);
		if(value != null){
			System.out.println(value);
		}
		
		// 使用Option		
		System.out.println("=============== Option has value ===============");
		// 1.Option含物件
		// 因為資料存放在Option裡面,就可以先透過isPresent()方法確認資料是否存在,再使用get()方法取得資料
		Optional<String> optValue = getMapValueOptional("KeyB");
		System.out.println("get():" + optValue.get());
		System.out.println("isPresent():" + optValue.isPresent());
		// 搭配使用 ifPresent(Consumer<? super T> consumer)，即可省略Null空值判斷又可安心進行後續的物件操作
		// 且不會拋出NullPointerException(如遇Null則不執行)
		optValue.ifPresent(str -> System.out.println("ifPresent(Consumer):" +str));		
		System.out.println("orElse(T):" + optValue.orElse("defaultValue"));
		System.out.println("orElseGet(Supplier):" + optValue.orElseGet(() -> "NewValue"));
		try {
			System.out.println("orElseThrow(Supplier):" + optValue.orElseThrow(() -> new Exception("NonValException")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("=============== Option no value ===============");
		// 2.Option為空
		optValue = getMapValueOptional("KeyD");
		// 拋出 NoSuchElementException 例外錯誤,就可避免毫無察覺的印出  null 的錯誤
		// System.out.println("get():" + optValue.get());
		System.out.println("isPresent():" + optValue.isPresent());
		optValue.ifPresent(str -> System.out.println("ifPresent(Consumer):" +str));
		System.out.println("orElse(T):" + optValue.orElse("defaultValue"));
		System.out.println("orElseGet(Supplier):" + optValue.orElseGet(
			() -> {
				System.out.println("excute other job");
				return "NewValue";
			}
		));
		
		try {
			System.out.println("orElseThrow(Supplier):" + optValue.orElseThrow(
				() -> {
					System.out.println("excute other job");
					return new Exception("NonValueException");
				}
			));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static String getMapValue(String key){
		Map<String, String> datas = new HashMap<>();
		datas.put("KeyA", "ValueA");
		datas.put("KeyB", "ValueB");
		datas.put("KeyC", "ValueC");
		
		return datas.get(key);
	}
	
	public static Optional<String> getMapValueOptional(String key){
		Map<String, String> datas = new HashMap<>();
		datas.put("KeyA", "ValueA");
		datas.put("KeyB", "ValueB");
		datas.put("KeyC", "ValueC");
//		以下兩行等同於 ofNullable 判斷式
//		String value = datas.get(key);
//		return (value == null) ? Optional.empty() : Optional.of(value); 
		return Optional.ofNullable(datas.get(key));
	}
}
