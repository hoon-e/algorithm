package basic.TriePractice;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {
    @Test
    public void trieTest(){
        Trie trie = new Trie();

        assertTrue(trie.isRootEmpty());

        trie.insert("PI");
        trie.insert("PIE");
        trie.insert("POW");
        trie.insert("POP");

        trie.insert("DEV");
        trie.insert("DOV");
        trie.insert("DEVS");
        trie.insert("DEVOPS");

        assertTrue(trie.contains("POW"));
        assertFalse(trie.contains("PIES"));

        trie.delete("POP");
        assertFalse(trie.contains("POP"));
        assertTrue(trie.contains("POW"));

        trie.delete("PO");
        trie.delete("PIES");
        trie.delete("PEN");
    }
}