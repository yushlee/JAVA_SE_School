import java.math.BigDecimal;
import java.math.RoundingMode;


public class WrapperDataType {

	public static void main(String[] args) {
//		Integer intNumber = new Integer(7);
		
		// Auto-Boxing
		Integer intNumber = 7;
		// Auto-UnBoxing
		int intValue = new Integer(7);
		
		System.out.println(intNumber.compareTo(8));
		System.out.println(intNumber.compareTo(7));
		System.out.println(intNumber.compareTo(6));
		
		System.out.println("3" + "2");
		
		System.out.println(3 + "2");
		
		String no = "2";
		System.out.println(3 + Integer.parseInt(no));
		
		
		BigDecimal seven = new BigDecimal("7");
		BigDecimal three = new BigDecimal("3");
		
		System.out.println(seven.add(three));
		System.out.println(seven.subtract(three));
		System.out.println(seven.multiply(three));
		
		System.out.println( (double) 7/3 );
		System.out.println( seven.divide(three, 0, RoundingMode.UP)  );
		System.out.println( seven.divide(three, 0, RoundingMode.DOWN)  );
		System.out.println( seven.divide(three, 1, RoundingMode.HALF_UP)  );
		
	}

}
