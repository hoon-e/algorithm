package leetcode.august;

import java.util.*;
import java.io.*;

// TODO: Set인데, HashSet을 구현하라고 했다. Hash bucket을 구현하는 것을 살펴보자
public class n2 {
    ArrayList<Integer> set;

    /** Initialize your data structure here. */
    public n2() {
        this.set = new ArrayList<>();
    }

    public void add(int key) {
        if(set.isEmpty()) {
            set.add(key);
        } else {
            boolean isIn = false;
            for(Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
                int n = it.next();

                if(n == key) {
                    isIn = true;
                    break;
                }
            }

            if(!isIn) set.add(key);
        }
    }

    public void remove(int key) {
        if(set.size() == 0) return;
        // 검색속도에서 굉장히 비효율적이다. 키 값을 이용해서 hash를 이용한다면 O(1)의 시간으로 탐색할 수 있다.
        for(Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
            int n = it.next();

            if(n == key) {
                it.remove();
                break;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        if(set.size() == 0) return false;
        for(Iterator<Integer> it = set.iterator(); it.hasNext(); ) {
            int n = it.next();

            if(n == key) {
                return true;
            }
        }
        return false;
    }

    /**
         private int bucketCount = 10000;
         private LinkedList<Integer>[] buckets;
         // Initialize your data structure here.
        public MyHashSet() {
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
    */

    /**
         class MyHashSet {
             // TC: O(N/K)=O(1) N: Total number of possible inputs, K: Total number of buckets(769 here)
             // SC: O(K+M) K: Total number of buckets(769) M: Total number of unique values that can be inserted
             private Bucket[] bucketArray;
             private int keyRange;

            public MyHashSet() {
                this.keyRange = 769;        // Consider a prime number to reduce the number of collisions
                this.bucketArray = new Bucket[this.keyRange];
                for(int i=0; i<this.keyRange; i++){
                    this.bucketArray[i] = new Bucket();
                }
            }

            public int _hash(int key){
                return (key % this.keyRange);
            }

            public void add(int key) {
                int hashIndex = this._hash(key);
                this.bucketArray[hashIndex].insert(key);
            }

            public void remove(int key) {
                int hashIndex = this._hash(key);
                this.bucketArray[hashIndex].delete(key);
            }

            public boolean contains(int key) {
                int hashIndex = this._hash(key);
                return this.bucketArray[hashIndex].exists(key);
            }
        }

        class Bucket {
            private LinkedList<Integer> container;

            public Bucket(){
                container = new LinkedList<>();
            }

            public void insert(Integer key){
                int index = this.container.indexOf(key);
                if(index == -1)
                    this.container.addFirst(key);
            }

            public void delete(Integer key){
                this.container.remove(key);
            }

            public boolean exists(Integer key){
                int index = this.container.indexOf(key);
                return (index!=-1);
            }
        }
     */
}
