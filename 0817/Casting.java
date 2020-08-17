
public class Casting {

	public static void main(String[] args) {
		// byte、short、int、long
		int intNo = 123;
		// 資料範小的  ->  資料範大的
		// 隱含
		long longNo = intNo;
		
		// 明確轉型
		int intNo2 = (int)longNo;
		
		// 小數 轉型 整數
		float floatValue = 14.5f;
		int intNo3 = (int) floatValue;
		System.out.println(intNo3);
		
		// 轉換後的範圍
		int intNo4 = 129;
		byte byteNo = (byte)intNo4;
		System.out.println(byteNo);
	}

}
