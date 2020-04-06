package BOJ.bojsolve;

import java.io.*;

public class n2493 {
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());

		String[] tower = new String[num];
		int[] real_tower = new int[num];

		// 결과 저장
		int[] result = new int[num];

		tower = br.readLine().split(" ");

		// 탑의 높이 입력
		for(int i=0; i<num; i++) {
			real_tower[i] = Integer.parseInt(tower[i]);
		}

		// 탑의 맨끝부터 처음 까지 역순으로 체크
		for(int j=num-1; j>=0; j--) {
			if(j == 0) { // 맨 처음 탑은 수신하는 탑이 없다.
				result[j] = 0;
				break;
			}

			int k = j-1; // 수신할 수 있는 탑을 이전부터로 설정
			long cur = real_tower[j]; // 현재의 탑

			while( k >= 0 ) { // k가 0이 될때까지 반복
				if( cur < real_tower[k] ) { // 만약 현재의 탑 높이보다 큰 높이의 탑이 있다면 수신을 한다.
					result[j] = k+1; // 그 인덱스를 저장한다.
					break; // 종료한다.
				}
				k--; // 없을 경우 k를 감소시켜가며 반복한다.
			}
		}

		for(int n : result) {
			bw.write(n+" ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}