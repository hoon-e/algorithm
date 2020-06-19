package BOJ.heap;

import java.io.*;
import java.util.*;

public class n1766 {
    static int[] problem;
    static int size = 0;
    static int maxSize = 0;
    static int N;
    static int M;
    static Map<Integer, Integer> prior = new HashMap<>();

    static boolean isFull(){
        return size == maxSize;
    }

    static void addHeap(int idx){
        int cur;

        if(isFull()){
            return;
        }else{
            problem[size] = idx;
            cur = size;
            ++size;
        }

        while(cur > 0 && (prior.get(problem[cur]) > prior.get(problem[(cur-1)/2])) ){
            if(problem[cur] > problem[(cur-1)/2]){
                int temp = problem[cur];
                problem[cur] = problem[(cur-1)/2];
                problem[(cur-1)/2] = temp;
                cur = (cur-1)/2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        st = new StringTokenizer(in.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maxSize = N;

        for(int i=1; i<=N; i++)
            prior.put(i, 0);

        problem = new int[N];

        for(int i=0; i<M; i++){
            st = new StringTokenizer(in.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int p = prior.get(b);
            prior.put(a, p+1);
        }

        for(int i=1; i<=N; i++)
            addHeap(i);

        for(int i=0; i<N/2; i++){
            if(N > (int)Math.pow(2, i)) {
                Arrays.sort(problem, (int)Math.pow(2, i), (int)Math.pow(2,i) + 2*i);
            }else {
                Arrays.sort(problem, (int) Math.pow(2, i), N);
            }
        }

        for(int i=0; i<N; i++)
            System.out.print(problem[i] + " ");
        System.out.println();

        out.flush();
        in.close();
        out.close();
    }
}
