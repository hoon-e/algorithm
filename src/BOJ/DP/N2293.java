package BOJ.DP;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2293 {
    static int[] coin = new int[101];
    static int n,k;
    static int[] d1;
    static int[] d2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        d1 = new int[k+1];
        d2 = new int[k+1];

        for(int i=0; i<n; i++)
            coin[i] = Integer.parseInt(br.readLine());

        for(int i=0; i<=k; i+=coin[0]){ // COIN에 해당하는 d1의 값을 1로 해놓음.
            d1[i] = 1;
        }

        for(int i=1; i<n; i++){ // 동전 갯수만큼 반복
            Arrays.fill(d2, 0); // d2 0으로 설정
            for(int j=0; j<=k; j++){ // 0부터 k까지
                d2[j] = d1[j];
                if( j >= coin[i] ){ // j가 coin[i]보다 크거나 같다면
                    d2[j] += d2[j-coin[i]]; // d2[j]
                }
            }
            for(int j=0; j<=k; j++)
                d1[j] = d2[j];
        }

        bw.write(d1[k] + "");
        bw.flush();
        bw.close();
        br.close();
    }
}
