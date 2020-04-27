package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2110 {
    static int[] house;
    static int N;
    static int C;
    static int MAX = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for(int i=0; i<C; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        for(int i=0; i<N; i++){
            binarySearch(i);
        }
    }

    static void binarySearch(int start){
        int st = start;
        int end = N-1;

        while(st <= end){
            int mid = (st+end)/2;
            findDist(mid);
        }
    }

    static void findDist(int mid){

    }
}
