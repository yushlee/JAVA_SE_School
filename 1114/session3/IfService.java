package session3;

public class IfService {
	
	public String getLevel(int score){
		if(score < 0){
			return "Error";
		}
		
		String level = "";
        if(score >= 90) {
        	level = "A";
        } else if(score >= 80 && score < 90) {
        	level = "B";
        	return level;
        } else if(score >= 70 && score < 80) {
        	level = "C";
        	return level;
        } else if(score >= 60 && score < 70) {
        	level = "D";
        	return level;
        } else {
        	level = "E";
        	return level;
        }
		
        return level;
	}
	
}
