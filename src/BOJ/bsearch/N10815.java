package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10815 {
    static int N;
    static int M;
    static int[] src;
    static int[] dst;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        src = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            src[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(src);

        M = Integer.parseInt(br.readLine());
        dst = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            dst[i] = Integer.parseInt(st.nextToken());
            if(binarySearch(dst[i]) < 0)
                bw.write(0 + " ");
            else
                bw.write(1 + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int binarySearch(int target){
        int start = 0;
        int end = N-1;

        while(start <= end){
            int mid = (start+end)/2;

            if(src[mid] < target){
                start = mid + 1;
            }else if(src[mid] > target){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return -(start+1);
    }
}
