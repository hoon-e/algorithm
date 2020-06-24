package BOJ.sort;

import java.io.*;
import java.util.*;

// Quick Selection Sort
public class n11004 {
    static int N;
    static int K;
    static int[] numbers;
    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N];

        st = new StringTokenizer(in.readLine());

        for(int i=0; i<N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        quickSort(0, N-1);

        out.write(numbers[K-1]+"");
        out.flush();
        in.close();
        out.close();
    }

    static void quickSort(int left, int right){
        if(left < right){
            int pivot = partition(left, right);

            if(pivot+1 == K) return;
            if(K < pivot+1)
                quickSort(left, pivot - 1);
            else // pivot+1 > K
                quickSort(pivot + 1, right);
        }
    }

    static void swap(int src, int dst){
        int tmp = numbers[src];
        numbers[src] = numbers[dst];
        numbers[dst] = tmp;
    }

    static int partition(int left, int right){
        int mid = (left+right)/2;
        
        // 처음과 중간값을 교환
        swap(left, mid);

        int pivot = numbers[left];
        int start = left;
        int end = right;

        while(start < end){
            while(start < end && pivot < numbers[end]) --end;
            while(start < end && pivot >= numbers[start]) ++start;

            swap(start, end);
        }

        // 만약 start가 end보다 클 경우는 중간값과 교환한다.
        numbers[left] = numbers[start];
        numbers[start] = pivot;

        return start;
    }
}
