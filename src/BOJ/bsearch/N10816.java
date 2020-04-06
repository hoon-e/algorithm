package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N10816 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        while(M-- > 0){
            int t = Integer.parseInt(st.nextToken());
            bw.write(upIdx(t,N)-lowIdx(t,N) + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int lowIdx(int target, int len){
        int st = 0;
        int en = len;

        // st = mid / en = mid-1 일때에는 mid = (st+en+1)/2
        // st = mid+1 / en = mid 일때에는 mid = (st+en)/2
        while(st < en){
            int mid = (st+en)/2;
            if(arr[mid] >= target)
                en = mid;
            else
                st = mid+1;
        }
        return st;
    }

    static int upIdx(int target, int len){
        int st = 0;
        int en = len;

        while(st < en){
            int mid = (st+en)/2;
            if(arr[mid] > target)
                en = mid;
            else
                st = mid+1;
        }
        return st;
    }
}
