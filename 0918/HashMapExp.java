package com.training.session6.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExp {
	public static void main(String[] args) {
		// HashMap實作Map介面，內部實作使用Hash Table。
		Map mapDatas = new HashMap();
		mapDatas.put("key1", "value1");
		mapDatas.put("key2", "value2");
		mapDatas.put("key2", "value2_1");
		mapDatas.put("key3", "value3");
		mapDatas.put("key4", "value4");
		mapDatas.put("key5", "value5");
		mapDatas.put("key6", "value5");
		// remove(Object key) 刪除指定的key與value
		mapDatas.remove("key4");
		// containsKey(Object key)是否包含指定的key
		System.out.println("mapDatas containsKey key1 ? "+ mapDatas.containsKey("key1"));
		System.out.println("mapDatas containsKey key4 ? "+ mapDatas.containsKey("key4"));		
		// containsValue(Object value)是否包含指定的value 
		System.out.println("mapDatas containsValue value1 ? "+ mapDatas.containsValue("value1"));
		System.out.println("mapDatas containsValue value4 ? "+ mapDatas.containsValue("value4"));
		// get(Object key) 回傳所指定key的value值
		System.out.println("mapDatas get key: key3 value : " + mapDatas.get("key3"));
		// isEmpty 回傳map是否有資料		
		System.out.println("mapDatas isEmpty ? " + mapDatas.isEmpty());
		// size 回傳 map大小
		System.out.println("mapDatas size ? " + mapDatas.size());
		// keySet 走訪map所有的key
		Set keys = mapDatas.keySet();
		for(Iterator i = keys.iterator(); i.hasNext();){
		   String key = (String) i.next();
		   // 再取key的同時也將value一併取回
		   String value = (String) mapDatas.get(key);
		   System.out.println("key:" + key);
		   System.out.println("value:" + value);
		}		
		// values 走訪map所有的value
		Collection values  = mapDatas.values();
		for(Iterator i = values.iterator(); i.hasNext();){
			String value = (String) i.next();
			System.out.println("value:" + value);
		}
	}
}
