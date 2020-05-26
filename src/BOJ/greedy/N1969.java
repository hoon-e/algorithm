package BOJ.greedy;

import java.io.*;
import java.util.*;

public class N1969 {
    static int[][] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N, M;
        st = new StringTokenizer(in.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] dna = new String[N];

        alpha = new int[M][26];
        int[] maxIndex = new int[M];
        char[] word = new char[M];

        Arrays.fill(maxIndex, -1);
        Arrays.fill(word, 'x');

        for(int i=0; i<N; i++){
            dna[i] = in.readLine();
        }

        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                int idx = dna[j].charAt(i)-'A';
                int temp = ++alpha[i][idx];

                if (maxIndex[i] < temp) {
                    maxIndex[i] = temp;
                    word[i] = dna[j].charAt(i);
                }else if(maxIndex[i] == temp){
                    if(word[i] > dna[j].charAt(i))
                        word[i] = dna[j].charAt(i);
                }
            }
        }

        int minDist = 0;

        for(int i=0; i<M; i++){
            out.write(word[i]);
            minDist += (N-maxIndex[i]);
        }

        out.write("\n"+minDist);
        out.flush();
        in.close();
        out.close();
    }
}
