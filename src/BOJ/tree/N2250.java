package BOJ.tree;

import java.io.*;
import java.util.*;

class Info {
    int width;
    int level;

    Info(int width, int level){
        this.width = width;
        this.level = level;
    }

    public void maxHeight(int newLevel){
        level = Math.max(level, newLevel);
    }
}

public class N2250 {
    static List<Integer>[] nodes;
    static Info[] infos;
    static boolean[] vst;
    static int maxWidth;
    static int minWidth;
    static int temp = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());
        nodes = new ArrayList[num+1];
        infos = new Info[num+1];
        vst = new boolean[num+1];

        for(int i=1; i<=num; i++) {
            nodes[i] = new ArrayList<>();
            infos[i] = new Info(0, 0);
        }

        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            if(c != -1)
                nodes[v].add(c);
            if(w != -1)
                nodes[v].add(w);
        }

        infos[1].width = 0;
        infos[1].level = 1;

        DFS(1, 1);

        for(int i=1; i<=num; i++)
            System.out.print(infos[i].width + " ");
    }

    static int DFS(int vtx, int level){
        vst[vtx] = true;

        for(int e : nodes[vtx]){
            if(!vst[e]){
                infos[vtx].level = level+1;
                infos[vtx].width += Math.max(infos[vtx].level, DFS(e, level+1));
            }
        }

        return infos[vtx].level;
    }
}
