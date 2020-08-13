package RE.bs;

import java.util.*;
import java.io.*;

public class n3079 {
    static int[] num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        num = new int[N];
        int[] check = new int[N];

        Queue<Integer> q = new LinkedList<>();

        // lower bound 탐색 -
        // 시간 / num[i]
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        //
    }

    private static int binarySearch(int st, int end, int target) {
        while(st <= end) {
            int mid = (st+end)/2;

            if(target < num[mid])
                end = mid-1;
            else if(target > num[mid])
                st = mid+1;
            else
                return mid;
        }

        return -1;
    }
}
