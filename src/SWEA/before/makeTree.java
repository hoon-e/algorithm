package SWEA.before;

import java.io.*;
import java.util.*;

public class makeTree {
    static ArrayList<Integer>[] graph = new ArrayList[1000];
    static ArrayList<Integer> parents = new ArrayList<>();
    static boolean[] vst = new boolean[1000];
    static int root;

    public static void main( String[] args ) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0; i<1000; i++){
            graph[i] = new ArrayList<>();
        }

        root = Integer.parseInt(in.readLine());
        parents.add(root);

        while(true){
            StringTokenizer st = new StringTokenizer(in.readLine());

            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            if(parent == 0)
                break;

            graph[parent].add(child);
            parents.add(parent);
        }

        for(int p : parents){
            if(!vst[p]){
                dfs(p);
            }
        }

        in.close();
        out.close();
    }

    static void dfs(int v){
        vst[v] = true;

        switch (String.valueOf(v).length()){
            case 1:
                System.out.print("[00"+v+"]");
                break;
            case 2:
                System.out.print("[0"+v+"]");
                break;
            case 3:
                System.out.print("["+v+"]");
                break;
        }

        for(int next : graph[v]){
            if(!vst[next]) {
                if( v == root ) {
                    if(graph[v].indexOf(next) == graph[v].size()-1) {
                        System.out.println();
                        System.out.print("       L--");
                    }else if(graph[v].indexOf(next) == 0)
                        System.out.print("--+--");
                    else {
                        System.out.println();
                        System.out.print("       +--");
                    }
                }
                else
                    System.out.print("-----");
                dfs(next);
            }
        }
    }
}
