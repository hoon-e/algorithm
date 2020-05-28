package BOJ.sort;

import java.io.*;
import java.util.*;

public class N3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<Character, Integer> m = new HashMap<>();
        int[] num = new int[3];

        StringTokenizer st = new StringTokenizer(in.readLine());

        for(int i=0; i<3; i++)
            num[i] = Integer.parseInt(st.nextToken());

        String line = in.readLine();

        bubbleSort(num);

        for(int i=0; i<3; i++){
            m.put((char)(65+i), num[i]);
        }

        for(int i=0; i<line.length(); i++){
            out.write(m.get(line.charAt(i)) + " ");
        }

        out.flush();
        in.close();
        out.close();
    }

    static void bubbleSort(int[] num){
        int len = num.length;

        for(int i=0; i<len-1; i++){
            boolean flag = false;
            for(int j=0; j<len-i-1; j++){
                if(num[j+1] < num[j]){
                    int temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;
                    flag = true;
                }
            }
            if(!flag) break;
        }
    }
}
