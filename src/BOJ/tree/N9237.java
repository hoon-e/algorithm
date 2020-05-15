package BOJ.tree;

import java.io.*;
import java.util.*;

public class N9237 {
    static Integer[] trees;
    static int treeNum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        treeNum = Integer.parseInt(br.readLine());
        trees = new Integer[treeNum];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int idx=0;
        while(st.hasMoreTokens())
            trees[idx++] = Integer.parseInt(st.nextToken());

        Arrays.sort(trees, Collections.reverseOrder());

        int maxDay = -1;
        int day = 0;

        for(int t : trees){
            maxDay = Math.max(maxDay, ++day + t);
        }

        bw.write((maxDay+1)+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
