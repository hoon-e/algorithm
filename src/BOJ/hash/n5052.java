package BOJ.hash;

import java.io.*;
import java.util.*;

class TrieNode {
    public Map<Character, TrieNode> childNodes;
    public boolean isLastChar;

    public Map<Character, TrieNode> getChildNodes() {
        return childNodes;
    }

    public boolean isLastChar() {
        return isLastChar;
    }

    public void setLastChar(boolean lastChar) {
        isLastChar = lastChar;
    }
}

class Trie {
    TrieNode root;

    Trie(){
        root = new TrieNode();
    }

    boolean insert(String s){
        TrieNode curNode = root;
        boolean flag = false;

        for(int i=0; i<s.length(); i++){
            if(curNode.getChildNodes() == null){
                curNode.childNodes = new HashMap<>();
                TrieNode temp = new TrieNode();
                curNode.childNodes.put(s.charAt(i), temp);

                curNode = temp;
            }else{
                TrieNode temp = curNode.getChildNodes().get(s.charAt(i));

                if(temp.isLastChar())
                    return true;

                curNode = temp;
            }
        }

        curNode.setLastChar(true);
        return false;
    }
}

public class n5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(in.readLine());

        for(int i=0; i<t; i++) {
            int c = Integer.parseInt(in.readLine());
            String[] lines = new String[c];
            Trie trie = new Trie();

            for (int j = 0; j < c; j++) {
                lines[j] = in.readLine();
            }

            boolean flag = false;

            for(int j=0; j<c; j++){
                flag = trie.insert(lines[j]);

                if(flag){
                    break;
                }
            }

            if(flag)
                out.write("NO\n");
            else
                out.write("YES\n");
        }

        out.flush();
        in.close();
        out.close();
    }
}
