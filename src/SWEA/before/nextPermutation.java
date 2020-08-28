package SWEA.before;

public class nextPermutation {
	int N; // 배열의 갯수
	int[] vst = new int[N];
	
	private boolean nextPerm() {
		int i = N-1;
		
		while(i > 0 && vst[i-1] >= vst[i]) --i;
		if(i == 0) return false;
		
		int j = N-1;
		while(j > 0 && vst[j-1] >= vst[j]) --j;
		
		int tmp = vst[i-1];
		vst[i-1] = vst[j];
		vst[j] = tmp;
		
		int k = N-1;
		while(i < k) {
			tmp = vst[i];
			vst[i] = vst[k];
			vst[k] = tmp;
			
			++i;
			--k;
		}
		
		return true;
	}
}
