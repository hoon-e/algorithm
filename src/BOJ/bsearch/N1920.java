package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1920 {
    static StringBuffer sb;
    static int[] lnum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        lnum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            lnum[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(lnum);
        sb = new StringBuffer();

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        while(M-- > 0){
            if(BSearch(Integer.parseInt(st.nextToken()), N) == -1)
                bw.write("0\n");
            else
                bw.write("1\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static int BSearch(int target, int len){
        int start = 0;
        int end = len-1;

        while(start <= end){
            int mid = (start+end)/2;
            if(lnum[mid] < target)
                start = mid+1;
            else if(lnum[mid] > target)
                end = mid-1;
            else
                return mid;
        }
        return -1;
    }
}
