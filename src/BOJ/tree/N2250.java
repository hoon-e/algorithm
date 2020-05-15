package BOJ.tree;

import java.io.*;
import java.util.*;

class Nodes {
    int parent;
    int idx;
    int left;
    int right;

    Nodes(int idx, int left, int right){
        this.parent = -1;
        this.idx = idx;
        this.left = left;
        this.right = right;
    }
}

public class N2250 {
    static Nodes[] nodes;
    static boolean[] vst;
    static int[] minLevel;
    static int[] maxLevel;
    static int floorLevel;
    static int x;
    static int temp = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        nodes = new Nodes[num+1];

        minLevel = new int[num+1];
        Arrays.fill(minLevel, 10001);
        maxLevel = new int[num+1];
        Arrays.fill(maxLevel, -1);

        vst = new boolean[num+1];

        for(int i=1; i<=num; i++){
            nodes[i] = new Nodes(i, -1, -1);
        }

        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            nodes[v].left = l;
            nodes[v].right = r;

            if(l != -1) nodes[l].parent = v;
            if(r != -1) nodes[r].parent = v;
        }

        int root = 0;

        for(int i=1; i<=num; i++){
            if(nodes[i].parent == -1){
                root = i;
                break;
            }
        }

        x = 1; // 시작좌표
        findMinMax(root, 1);

        int ansLevel = 1;
        int ansWidth = maxLevel[1] - minLevel[1] + 1;

        for(int i=2; i<=floorLevel; i++){
            int tempWidth = maxLevel[i] - minLevel[i] + 1;

            if( tempWidth > ansWidth ){
                ansLevel = i;
                ansWidth = tempWidth;
            }
        }

        bw.write(ansLevel + " " + ansWidth);
        bw.flush();
        bw.close();
        br.close();
    }

    static void findMinMax(int vtx, int level){
        Nodes cur = nodes[vtx];

        floorLevel = Math.max(floorLevel, level);

        if(cur.left != -1)
            findMinMax(cur.left, level+1);

        minLevel[level] = Math.min(minLevel[level], x);
        maxLevel[level] = x;
        ++x;

        if(cur.right != -1)
            findMinMax(cur.right, level+1);
    }
}
