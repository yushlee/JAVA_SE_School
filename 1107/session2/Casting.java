package session2;

public class Casting {

	public static void main(String[] args) {
		
		//		　資料範圍較小　 < --- >　資料範圍較大
        // byte < short < int < long < float < double
		
		// 小　→　大 Implicit (隱含)
		int a = 10;
		long b = a;
		float c = b;
		
		// 大　→　小 Explicit (明確轉型)
		double d = 128.9;
		int e = (int) d;		
		System.out.println(e);
		byte f = (byte) e;
		System.out.println(f);
	}

}
