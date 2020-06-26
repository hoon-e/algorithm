package BOJ.bsearch;

import java.io.*;
import java.util.*;

public class n1920_new {
    static int N;
    static int M;
    static int[] number;
    static int[] find;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(in.readLine());
        number = new int[N];

        st = new StringTokenizer(in.readLine());
        for(int i=0; i<N; i++)
            number[i] = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(in.readLine());
        find = new int[M];

        st = new StringTokenizer(in.readLine());
        for(int i=0; i<M; i++)
            find[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(number);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<M; i++){
            if(binarySearch(find[i]) != -1){
                sb.append("1\n");
            }
            else
                sb.append("0\n");
        }

        out.write(sb.toString());
        out.flush();
        in.close();
        out.close();
    }

    static int binarySearch(int target){
        int st = 0;
        int end = N-1;

        while(st <= end){
            int mid = (st+end)/2;

            if(number[mid] == target){
                return mid;
            }else if( number[mid] < target ){
                st = mid + 1;
            }else
                end = mid - 1;
        }

        return -1;
    }
}
