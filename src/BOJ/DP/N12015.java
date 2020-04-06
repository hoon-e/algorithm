package BOJ.DP;

import java.io.*;
import java.util.StringTokenizer;

public class N12015 {
    static int[] arr = new int[1_000_001];
    static int size;
    static int[] ans = new int[1_000_001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int i = 0;
        while(st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        size = 1;
        ans[0] = arr[0];

        for(int j=1; j<num; j++){
            if(arr[j] > ans[size-1]){
                ans[size] = arr[j];
                size++;
            }else if(ans[j] < arr[0]){
                arr[0] = ans[j];
            }else{
                int idx = bsearch(0, size, arr[j]);
                if(idx < 0) idx = -1-idx;
                ans[idx] = arr[j];
            }
        }

        bw.write(size+"");
        bw.flush();
        bw.close();
        br.close();
    }

    static int bsearch(int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (ans[mid] < target)
                start = mid + 1;
            else if (ans[mid] > target)
                end = mid - 1;
            else
                return mid;
        }
        return -(start+1);
    }
}
