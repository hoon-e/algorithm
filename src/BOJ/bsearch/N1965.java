package BOJ.bsearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// TODO: LIS 개념 복습하기
public class N1965 {
    static int[] box = new int[1001];
    static int[] chk = new int[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0;

        while(st.hasMoreTokens()){
            box[i++] = Integer.parseInt(st.nextToken());
        }

        chk[0] = box[0];
        int size = 1;

        for(int idx=1; idx<num; idx++){
            if(chk[0] > box[idx])
                chk[0] = box[idx];
            else if(chk[size-1] < box[idx]){
                chk[size] = box[idx];
                size++;
            }else{
                int index = Arrays.binarySearch(chk, 0, size, box[idx]);
                if( index < 0 ) index = -1-index;
                chk[index] = box[idx];
            }
        }

        bw.write(size+"");
        bw.flush();
        bw.close();
        br.close();
    }
}
