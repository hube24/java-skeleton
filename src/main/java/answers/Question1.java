package answers;

import java.util.HashSet;
import java.util.Set;

public class Question1 {

	public static int bestMergedPortfolio(int[] portfolios) {
		
		 int max = 0, tmp = 0;
	        for(int i = 31; i >= 0; i--){
	        	tmp = tmp|(1<<i);
	            
	            Set<Integer> s = new HashSet<>();
	            
	            for(int num : portfolios){
	                s.add(num&tmp);
	            }
	            
	            int txor = max|(1<<i);
	            
	            for(int pre : s)
	                if(s.contains(txor ^ pre)) {
	                    max = txor; break;
	                }
	            
	        }
	        return max;
	}

	

}
