package BOJ.io;

import java.io.*;
import java.util.StringTokenizer;

public class N10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] card = new int[21];

        for(int i=1; i<21; i++)
            card[i] = i;

        for(int i=0; i<10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            changeCard(card, start, end);
        }

        for(int i=1; i<21; i++)
            bw.write(card[i] + " ");
        bw.flush();
        bw.close();
        br.close();
    }

    static void changeCard(int[] card, int start, int end){
        int length = end-start+1;
        int[] temp = new int[length];

        int j=0;
        for(int i=end; i>=start; i--){
            temp[j++] = card[i];
        }

        j=0;
        for(int i=start; i<=end; i++){
            card[i] = temp[j++];
        }
    }
}
