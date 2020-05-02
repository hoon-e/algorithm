package BOJ.bsearch;

import java.io.*;
import java.util.StringTokenizer;

public class N1654 {
    static int N;
    static int K;
    static long[] lan;
    static long maxHeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        lan = new long[N];

        for(int i=0; i<N; i++){
            lan[i] = Long.parseLong(br.readLine());
            if(lan[i] > maxHeight) maxHeight = lan[i];
        }

        bw.write(binarySearch() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static long binarySearch(){
        long start = 1;
        long end = maxHeight;

        while(start <= end){
            long target = (start+end)/2;
            int many = findMany(target);

            if(many < K){
                end = target - 1;
            }else if(many >= K){ // break를 걸어주면 이상인 값을 탐색하지 못한다.
                start = target + 1;
            }
        }
        return end;
    }

    static int findMany(long target){
        int many = 0;
        for(int i=0; i<N; i++){
            if(lan[i] < target) continue;
            many += lan[i] / target;
        }
        return many;
    }
}
