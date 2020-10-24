package session2;

public class AttributeScopeMain {

	public static void main(String[] args) {
		
		AttributeScope attribute = new AttributeScope();
		// 可被外界存取
		System.out.println(attribute.memberField);
		// 不能讓外界存取
		// System.out.println(attribute.localField);
		
		attribute.localMethod();

	}

}
