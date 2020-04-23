package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N2805 {
    static int N;
    static long M;
    static long[] tree;
    static long ans;
    static long maxHeight;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        tree = new long[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(tree);
        maxHeight = tree[N-1];

        binarySearch();
        bw.write(ans+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void binarySearch(){
        long st = 0;
        long end = maxHeight;

        while(st <= end){
            long target = (st+end)/2;
            long treesum = isSum(target);

            // treesum이 M보다 클 경우엔 길이가 길어져야한다. 지금까지 최대값은 target이다.
            if(treesum > M) {
                ans = target;
                st = target + 1;
            }
            else if(treesum < M) { // treesum이 M보다 작을 경우엔 길이가 작아져야한다.
                end = target - 1;
            }
            else{ // treesum과 M이 같을 경우 최대의 값은 target이다.
                ans = target;
                break;
            }
        }
    }

    static long isSum(long target){
        long sum = 0;
        for(int i=0; i<N; i++){
            if(tree[i] < target) continue;
            sum += (tree[i] - target);
        }
        return sum;
    }
}
