
public class AttributeScope {
	
	// Member Scope 成員變數
	String name;
	
	public void methodOne(){
		System.out.println(name);
		
		// Local Scope 區域變數
		String title = "BBB";
		System.out.println(title);
	}
	
	public void methodTwo(){
		System.out.println(name);
//		System.out.println(title);
	}
}
