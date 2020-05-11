package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2110 {
    static int[] house;
    static int N;
    static int C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for(int i=0; i<N; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int left = 1;
        int right = house[N-1] - house[0];
        int result = 0;

        while(left <= right){
            int target = (left + right)/2;
            int count = 1;
            int start = house[0];

            for(int i=1; i<N; i++) {
                // 해당 집에서 시작 까지의 거리가 중간값보다 크거나 같다면
                if (house[i] - start >= target) {
                    count++;
                    start = house[i];
                }
            }

            // 만약 공유기의 갯수가 크거나 같은 경우
            // 너무 설치된 간격이 가깝다. or 최소거리가 더 있을 수 있다.
            if (count >= C) {
                left = target+1;
                result = target;
            } else { // 너무 간격이 멀어서 설치 갯수가 부족한 경우
                right = target - 1;
            }
        }
        System.out.println(result);
    }
}
