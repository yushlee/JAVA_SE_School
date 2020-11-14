package session3;

public class BreakAndContinue {
	public static void main(String[] args) {
		// break 中斷並離開 
        for(int i=0 ; i<10 ; i++){
            if(i==6){
                break;
            }
            System.out.println(i + "=>Hello");
            
        }
		
        System.out.println("----------------------------");
        
        // continue 中斷但繼續
        for(int i=0 ; i<10 ; i++){
            if(i==6){
            	continue;
            }
            System.out.println(i + "=>Hello");            
        }
	}
}
