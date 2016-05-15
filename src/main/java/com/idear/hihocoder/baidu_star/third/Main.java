package com.idear.hihocoder.baidu_star.third;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class TrieNode{

    private int count = 0;
    private TrieNode[] children;

    TrieNode(){
        children = new TrieNode[26];
    }

    void insert(char[] s, int i){
        count++;
        if (i < s.length){
            int index = s[i] - 'a';
            if (children[index] == null)
                children[index] = new TrieNode();
            children[index].insert(s, i + 1);
        }
    }

    int startWith(char[] s, int i){
        if (i == s.length){
            return count;
        } else {
            int index= s[i] - 'a';
            if (children[index] == null)
                return 0;
            return children[index].startWith(s, i + 1);
        }
    }

    void print(){
        for (int i = 0; i < 26; i++){
            if (children[i] != null){
                System.out.println((char)(i + 'a') + " " + children[i].count);
                children[i].print();
            }
        }
    }

    void delete(char[] s, int i, int num){
        count-=num;
        if (i < s.length){
            int index = s[i] - 'a';
            if (children[index] == null)
                return;
            children[index].delete(s, i + 1, num);
            if (children[index].count == 0)
                children[index] = null;
        }
    }
}

class TrieTree{
    private TrieNode root;
    TrieTree(){
        root = new TrieNode();
    }
    public void insert(String s){
        root.insert(s.toCharArray(), 0);
    }
    boolean startWith(String s){
        return root.startWith(s.toCharArray(), 0) > 0;
    }
    public void delete(String s){
        char[] ss = s.toCharArray();
        int cnt = root.startWith(ss, 0);
        if (cnt > 0){
            root.delete(ss, 0, cnt);
        }
    }
    public void print(){
        root.print();
        System.out.println();
    }
}

public class Main{
    public static void main(String[] args) throws IOException{

        StreamTokenizer st = new StreamTokenizer(new BufferedReader(
                new InputStreamReader(System.in)
        ));
        st.nextToken();
        int n = (int) st.nval;
        TrieTree trie = new TrieTree();
        for (int i = 0; i < n; i++){
            st.nextToken();
            String op =  st.sval;
            st.nextToken();
            String str = st.sval;
//            System.out.println("Yes");
            if (op.equals("insert")){
                trie.insert(str);
            } else if (op.equals("delete")){
                trie.delete(str);
            } else {
                boolean rst = trie.startWith(str);
                if (rst)
                    System.out.println("Yes");
                else
                    System.out.println("No");
            }
        }
    }
}
