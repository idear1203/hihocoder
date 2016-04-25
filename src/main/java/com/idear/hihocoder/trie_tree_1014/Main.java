package com.idear.hihocoder.trie_tree_1014;

import java.util.*;

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
}

class TrieTree{
    private TrieNode root;
    TrieTree(){
        root = new TrieNode();
    }
    private void insert(String s){
        root.insert(s.toCharArray(), 0);
    }
    int startWith(String s){
        return root.startWith(s.toCharArray(), 0);
    }
    void build(String[] ss){
        for (String s : ss){
            insert(s);
        }
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] dict = new String[n];
        for (int i = 0; i < n; i++)
            dict[i] = scanner.nextLine();
        TrieTree trie = new TrieTree();
        trie.build(dict);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- != 0){
            System.out.println(trie.startWith(scanner.nextLine()));
        }
        scanner.close();
    }
}
