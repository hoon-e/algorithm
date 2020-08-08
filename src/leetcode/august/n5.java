package leetcode.august;

import jogamp.opengl.util.pngj.chunks.ChunkRaw;

import java.util.*;
import java.io.*;
import java.util.regex.Pattern;

/*
Trie
HashMap은 매우 효율적인 자료구조로, 중요한 연산들에 O(1)의 시간복잡도를 가진다.
HashMap은 정렬을 지원하지 않는다.
Hash함수는 충돌이 발생한다.

노드의 모든 하위 항목에는 해당 노드와 연결된 문자열의 공통 접두사가 있으며, 루트 노드는 빈문자열을 저장한다.

 */

// Trie 시범 코드 보고 푼 내용
// TODO: Trie 공부할 것.
public class n5 {
    static class Trie {
        Trie[] child;
        boolean isLast;

        Trie() {
            this.child = new Trie[26];
            this.isLast = false;
        }
    }

    static Trie root;

    /** Initialize your data structure here. */
    public n5() {
        root = new Trie();
    }

    /** Adds a word into the data structure. */
    // 단어의 각 알파벳을 계층구조의 자식 노드로 만들어 넣는다.
    // 계층 문자의 자식 노드가 존재하지 않을때에만 자식 노드를 생성한다.
    public void addWord(String word) {
        Trie curNode = root;

        for(char n : word.toCharArray()) {
            if(curNode.child[n-'a'] == null)
                curNode.child[n-'a'] = new Trie();
            curNode = curNode.child[n-'a'];
        }
        curNode.isLast = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(Trie root, String word, int idx) {
        if(idx >= word.length())
            return root.isLast;

        char num = word.charAt(idx);

        if(num == '.'){
            for(Trie child : root.child){
                if(child != null && search(child, word, idx+1))
                    return true;
            }
            return false;
        }

        if(root == null) return false;
        if(root.child[num-'a'] == null) return false;

        return search(root.child[num-'a'], word, idx+1);
    }

    public boolean search(String word) {
        return search(root, word, 0);
    }
}
