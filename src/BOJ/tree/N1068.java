package BOJ.tree;

import java.io.*;
import java.util.*;

class Node1 {
    int idx;
    Node1(int idx){
        this.idx = idx;
    }
}

public class N1068 {
    static List<Node1>[] tree1;
    static boolean[] vst;
    static int root;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] n = br.readLine().split(" ");

        int dell = Integer.parseInt(br.readLine());

        tree1 = new ArrayList[N];
        vst = new boolean[N];

        for(int i=0; i<N; i++)
            tree1[i] = new ArrayList<>();

        int idx = -1;
        for(int i=0; i<N; i++){
            if(Integer.parseInt(n[i]) == -1){
                root = ++idx;
            }else{
                int t = Integer.parseInt(n[i]);
                tree1[t].add(new Node1(++idx));
            }
        }

        delNode(root, dell);

        vst = new boolean[N];
        countNode(root);

        bw.write(cnt+"\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void countNode(int vtx){
        vst[vtx] = true;

        if(tree1[vtx] == null) return;
        if(tree1[vtx].size() == 0){
            ++cnt;
            return;
        }

        for(Node1 n : tree1[vtx]){
            if(!vst[n.idx]){
                countNode(n.idx);
            }
        }
    }

    static void delNode(int vtx, int dell){
        vst[vtx] = true;

        if(dell == root){
            tree1[root] = null;
            return;
        }

        for(Node1 n : tree1[vtx]){
            if(!vst[n.idx]){
                if(n.idx == dell) {
                    tree1[vtx].remove(n);
                    return;
                }
                delNode(n.idx, dell);
            }
        }
    }
}
