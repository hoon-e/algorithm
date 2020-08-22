package RE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 뮤탈리스크가 공격을 할때, 한 번에 세개의 SCV를 공격할 수 있다.
// SCV의 체력이 0또는 그 이하가 되어버리면, SCV는 즉시 파괴된다.
// 한번의 공격에서 같은 SCV를 여러번 공격할 수 는 없다.
// 모든 SCV를 파괴하기위해 공격해야 하는 횟수의 최솟값
public class n12869 {
	static int n, minTime = Integer.MAX_VALUE;
	static int[] scv;
	static HashMap<Integer, boolean[][][]> chk;
	static int[][] attack = {{9, 3, 1}, {9, 1, 3}, {1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}};
	static boolean[][][] tmp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		scv = new int[3];
		chk = new HashMap<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++)
			scv[i] = Integer.parseInt(st.nextToken());

		attackSCV(scv[0], scv[1], scv[2], 0);
		System.out.println(minTime);
	}
	
	private static void attackSCV(int scv1, int scv2, int scv3, int time) {
		if(scv1 == 0 && scv2 == 0 && scv3 == 0) {
			minTime = Math.min(minTime, time);
			return;
		}
		
		tmp = chk.get(time);
		
		if(tmp == null) { tmp = new boolean[61][61][61]; }
		if(tmp[scv1][scv2][scv3]) return;
		
		tmp[scv1][scv2][scv3] = true;
		chk.put(time, tmp);
		
		for(int d=0; d<6; d++) {
			int n1 = (scv1 - attack[d][0] < 0) ? 0 : scv1 - attack[d][0];
			int n2 = (scv2 - attack[d][1] < 0) ? 0 : scv2 - attack[d][1];
			int n3 = (scv3 - attack[d][2] < 0) ? 0 : scv3 - attack[d][2];

			if(time + 1 > minTime) continue;
			attackSCV(n1, n2, n3, time+1);
		}
	}
}
