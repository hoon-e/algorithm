package leetcode.august;

import java.util.ArrayList;
import java.util.List;

public class n12 {
	public List<Integer> getRow(int rowIndex) {
        int[][] number = new int[rowIndex+1][rowIndex+1];
        
        number[0][0] = 1;
        for(int i=1; i<rowIndex+1; i++) {
            for(int j=0; j<=i; j++) {
                if(j == 0 || j == i) {
                    number[i][j] = 1;
                    continue;
                }
                number[i][j] = number[i-1][j-1] + number[i-1][j];
            }
        }
        
        List<Integer> ans = new ArrayList<>();
        
        for(int i=0; i<rowIndex+1; i++)
            ans.add(number[rowIndex][i]);
        
        return ans;
    }
}
