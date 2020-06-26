package BOJ.sort;

import java.io.*;
import java.util.*;

public class n1059 {
    static int L;
    static int[] sets;
    static int N;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        L = Integer.parseInt(in.readLine());
        sets = new int[L];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i=0; i<L; i++)
            sets[i] = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(in.readLine());

        quickSort(0, L-1);

        // 찾고자하는 값보다 뒤에 값이 존재할 경우
        // 찾고자하는 값보다 앞에 값이 존재하는 경우

        out.write(findNumber() + "");
        out.flush();
        in.close();
        out.close();
    }

    static int findNumber(){
        int left = 1;
        int right = 0;
        int cnt = 0;

        for(int i=0; i<N; i++){
            if(N <= sets[i]){
                right = sets[i];
                break;
            }
            left = sets[i] + 1;
        }

        for(int i = left; i < right; i++){
            for(int j = i+1; j < right; j++){
                if( i <= N && N <= j) ++cnt;
            }
        }

        return cnt;
    }

    static int partition(int st, int end){
        int mid = sets[(st+end)/2];

        while(st < end){
            while(st < end && sets[st] < mid) ++st;
            while(st < end && sets[end] > mid) --end;

            if(st < end){
                swap(st, end);
            }
        }

        return st;
    }

    static void quickSort(int st, int end){
        if( st < end ){
            int pivot = partition(st, end);

            quickSort(st, pivot - 1);
            quickSort(pivot + 1, end);
        }
    }

    static void swap(int a, int b){
        int tmp = sets[a];
        sets[a] = sets[b];
        sets[b] = tmp;
    }
}

