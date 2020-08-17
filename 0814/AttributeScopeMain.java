
public class AttributeScopeMain {

	public static void main(String[] args) {
		AttributeScope scope = new AttributeScope();
		scope.name = "ABC";
		System.out.println(scope.name);
		scope.methodTwo();
		scope.methodOne();
//		System.out.println(scope.title);

	}

}
