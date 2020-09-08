
public class TriangleSum {

	public static void main(String[] args) {
		
		/*
		 給定一個非負整數，生成三角形
		 在三角形中
		 1.每一列的頭、尾元素都是1
		 2.每一列中間的數字都是其上一列兩個數字的和
		 
		Input:6
		Output:
		[
		      [1]
		     [1,1]
		    [1,2,1]
		   [1,3,3,1]
		  [1,4,6,4,1]
		 [1,5,10,10,5,1]
		]
		*/
		int numRows = 6;
		int[][] triangles = generate1(numRows);
		for(int[] triangle : triangles){
			for(int number : triangle){
				System.out.print(number + ",");
			}
			System.out.println();
		}

	}
	
    public static int[][] generate1(int numRows) {
    	int[][] triangles = null;

    	
    	return triangles;
    }
	
}
