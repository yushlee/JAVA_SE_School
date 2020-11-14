package session2.homework;

public class Customer {
	
	public String maskCustomer(String name){
		String maskName = "";
		int nameLength = name.length();
		if(nameLength == 2){
//			1.若為"兩個字"則隱碼第二個字
			
		}else if(nameLength == 3) {
//			2.若為"三個字"則隱碼第二個字
			
		}else if(nameLength == 4) {
//			3.若為"四個字"則隱碼第二、第三個字
			
		}else if(nameLength > 4) {
//			4.若為"四個字以上"則一律隱碼第二、第三個字
			
		}		
		
		return maskName;
	}
	
}
