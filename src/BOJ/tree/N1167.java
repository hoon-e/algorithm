package BOJ.tree;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;


public class N1167 {
    static class edges {
        int vertex;
        long weight;

        edges(int vertex, long weight){
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    static ArrayList<edges>[] nodes;
    static boolean[] vst;
    static int maxPos;
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        nodes = new ArrayList[N+1];
        vst = new boolean[N+1];

        for(int i=0; i<=N; i++)
            nodes[i] = new ArrayList<>();

        for(int i=0; i<N; i++){
            String[] nums = br.readLine().split(" ");
            int v = Integer.parseInt(nums[0]);

            for(int j=1; j<nums.length; ){
                if(!nums[j].equals("-1")){
                    int c = Integer.parseInt(nums[j]);
                    long d = Long.parseLong(nums[j+1]);

                    nodes[v].add(new edges(c,d));
                    j+=2;
                }else
                    break;
            }
        }

        DFS(1, 0);
        vst = new boolean[N+1];
        DFS(maxPos, 0);

        bw.write(max+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int vtx, long w){
        vst[vtx] = true;

        if(w > max){
            maxPos = vtx;
            max = w;
        }

        for(edges e : nodes[vtx]){
            if(!vst[e.vertex]){
                DFS(e.vertex, e.weight + w);
            }
        }
    }
}
