package session3;

public class IfSyntaxMain {

	public static void main(String[] args) {
		IfService service = new IfService();
		String level = service.getLevel(80);
		System.out.println(level);

	}

}
