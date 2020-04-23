package tree;

import java.io.*;

class Tree {
    Tree left;
    Tree right;
    String name;

    Tree(){
        this.left = null;
        this.right = null;
        this.name = null;
    }
}

public class N1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Tree tree = new Tree();
        int test = Integer.parseInt(br.readLine());

        while(test-- > 0){
            String[] line = br.readLine().split(" ");

        }
    }
}
