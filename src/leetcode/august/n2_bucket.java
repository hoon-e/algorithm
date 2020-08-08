package leetcode.august;

import java.util.*;
import java.io.*;

public class n2_bucket {
    private int bucketCount = 10000;
    private LinkedList<Integer>[] buckets;

    // Initialize your data structure here.
    public n2_bucket() {
        this.buckets = new LinkedList[bucketCount];
    }

    public void add(int key) {
        int bucket = key % bucketCount;
        if (buckets[bucket] == null) {
            buckets[bucket] = new LinkedList<>();
        }
        if (!buckets[bucket].contains(key))
            buckets[bucket].addFirst(key);
    }

    public void remove(int key) {
        int bucket = key % bucketCount;
        if (buckets[bucket] == null)
            return;
        buckets[bucket].remove((Integer)key);
    }

     // Returns true if this set contains the specified element
    public boolean contains(int key) {
        int bucket = key % bucketCount;
        if (buckets[bucket] == null)
            return false;

        return buckets[bucket].contains(key);
    }
}
