package kakao;

import java.util.Arrays;

class Solution {
    boolean[] chk;  
    int ans = Integer.MAX_VALUE;
    
    /*
     * 생각
     * 오른쪽으로만 가는 것이 최선인가? 왼쪽으로만 가는 것이 최선인가?
     * 오른쪽으로 가다가 왼쪽으로 트는 것이 최선일 수는 없을까?
     *  
     */
    
    public int solution(int n, int[] weak, int[] dist) {
        Arrays.sort(dist);
        
        if(weak.length == 0) return 0;
        
        for(int wIdx = weak.length-1; wIdx >=0; wIdx--) {
        	chk = new boolean[n];
            int dIdx = dist.length-1;
            
//            makePerm();
            
    		turn(n, weak, dist, wIdx, dIdx, 0);
        }
        
        if(ans == Integer.MAX_VALUE) ans = -1;
        return ans;
    }
    
    // 시계방향으로 해당 방향 만큼 오른쪽으로 돌린다.
    public void turn(int n, int[] weak, int[] dist, int wIdx, int dIdx, int cnt)     {
    	if(isAll(weak)) {
    		ans = Math.min(ans, cnt);
    		return;
    	}
    	
    	if(dIdx < 0) return;
    	if(chk[weak[wIdx]])
            wIdx = (wIdx-1 < 0) ? 0 : wIdx-1;
        
    	int next = (wIdx-1 < 0) ? 0 : wIdx-1;
    	
    	int i;
        
		/** 오른쪽으로 돌리면서 체크한다. **/
    	for(i=weak[wIdx]; i <= weak[wIdx] + dist[dIdx]; i++) {
    		chk[i%n] = true;
    	}
    	 	
		turn(n, weak, dist, next, dIdx-1, cnt+1);

		for(i=weak[wIdx]; i<=weak[wIdx] + dist[dIdx]; i++) {
    		chk[i%n] = false;
    	}
		
		/**** 왼쪽으로 돌리는 코드 ****/
		for(i=weak[wIdx]; i >= weak[wIdx] - dist[dIdx]; i--) {
    		if(i < 0) chk[(i%n) + n] = true;
    		else chk[i] = true;
    	}
		
		turn(n, weak, dist, next, dIdx-1, cnt+1);
				
		for(i=weak[wIdx]; i >= weak[wIdx] - dist[dIdx]; i--) {
    		if(i < 0) chk[(i%n) + n] = false;
    		else chk[i] = false;
		}
    }
    
    public boolean isAll(int[] weak) {
        for(int i=0; i<weak.length; i++) {
            if(!chk[weak[i]]) return false;
        }
        return true;
    }
}

public class Outwall {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int ans = s.solution(200, new int[]{0, 10, 50, 80, 120, 160}, new int[]{1, 10, 5, 40, 30});
		
		System.out.println(ans);
	}
}
