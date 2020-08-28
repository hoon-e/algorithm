package kakao;

import java.util.Arrays;

class Solution {
    boolean[] chk;
    boolean[] distChk;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[] weak, int[] dist) {
        chk = new boolean[n];
        distChk = new boolean[dist.length];
        
        Arrays.sort(dist);
        dfs(n, weak, dist, 0);
        
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
    
    public boolean isDist(int n) {
    	for(int i=0; i<n; i++) {
    		if(!distChk[i]) return false;
    	}
    	
    	return true;
    }
    
    public boolean isAll(int[] weak) {
        for(int i=0; i<weak.length; i++) {
            if(!chk[weak[i]]) return false;
        }
        
        return true;
    }
    
    public void dfs(int n, int[] weak, int[] dist, int cnt) {
    	if(isDist(dist.length)) return;
        if(isAll(weak)) { // 모두 수리 했다면
            answer = Math.min(answer, cnt);
            return;
        }

        boolean[] original = new boolean[n];
        
        for(int i=0; i<n; i++)
            original[i] = chk[i];
        
        for(int idx=0; idx < weak.length; idx++) {
            if(chk[weak[idx]]) continue; // 수리한 취약 지점이라면
            
            for(int j=0; j<dist.length; j++) {
            	if(distChk[j]) continue;
            	
            	distChk[j] = true;
            	
            	int d = dist[j]; // 거리
                int c = weak[idx]; // 시작 지점

                while(d-- >= 0) { // 거리가 0보다 클 동안
                    if(c >= n) c = 0;
                    chk[c++] = true;
                }
                
                dfs(n, weak, dist, cnt + 1);
                
                for(int i=0; i<n; i++)
                	chk[i] = original[i]; // 원상복구
                
                distChk[j] = false;
            }          
        }
    }
}

public class Outwall {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		int ans = s.solution(12, new int[]{1, 3, 4, 9, 10}, new int[]{3, 5, 7});
		
		System.out.println(ans);
	}
}
