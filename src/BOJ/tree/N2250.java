package BOJ.tree;

import java.io.*;
import java.util.*;

class Nodes {
    int parent; // 부모
    int idx; // 현재 idx
    int left; // 왼쪽 자식
    int right; // 오른쪽 자식

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

        // 최저 
        minLevel = new int[num+1];
        Arrays.fill(minLevel, 10001);
        
        // 최고
        maxLevel = new int[num+1];
        Arrays.fill(maxLevel, -1);

        vst = new boolean[num+1];

        // num개의 노드들을 초기화한다.따라서 root는 parent를 -1로 가질 것입니다.
        for(int i=1; i<=num; i++){
            nodes[i] = new Nodes(i, -1, -1);
        }

        // num 번만큼 반복하여, 노드번호, 왼쪽 오른쪽 번호를 입력받습니다.
        for(int i=0; i<num; i++){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            nodes[v].left = l;
            nodes[v].right = r;

            // -1이 아니라면, 왼쪽과 오른쪽의 parent를 v로 초기화시켜줍니다.
            if(l != -1) nodes[l].parent = v;
            if(r != -1) nodes[r].parent = v;
        }

        int root = 0;

        // parent가 -1인 것을 root로 초기화합니다.
        for(int i=1; i<=num; i++){
            if(nodes[i].parent == -1){
                root = i;
                break;
            }
        }

        x = 1; // 시작좌표
        // root부터 최고, 최저를 찾는 함수를 호출합니다.
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

    // root부터 시작하여 최저, 최고를 찾습니다.
    static void findMinMax(int vtx, int level){
        Nodes cur = nodes[vtx];

        // 함수를 전부 돌면 가장 밑의 level이 됩니다.
        floorLevel = Math.max(floorLevel, level);

        // 현재에서 왼쪽 자식이 있다면, level을 하나 증가시켜 함수를 호출합니다.
        if(cur.left != -1)
            findMinMax(cur.left, level+1);

        // 현재 level에서 최저 레벨을 구해줍니다.
        minLevel[level] = Math.min(minLevel[level], x);
        // 현재 레벨의 가장 큰 x 좌표입니다.
        maxLevel[level] = x;
        // x값을 증가시킵니다.
        ++x;

        // 오른쪽 자식이 있다면 반복합니다.
        if(cur.right != -1)
            findMinMax(cur.right, level+1);
    }
}
