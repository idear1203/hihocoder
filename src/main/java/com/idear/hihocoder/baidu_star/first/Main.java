package com.idear.hihocoder.baidu_star.first;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null){
            int t = Integer.parseInt(line);
            String s = in.readLine();
            SegmentTree tree = SegmentTree.get(s);
            for (int i = 0; i < t; i++){
                String[] tmp = in.readLine().split("\\s");
                int start = Integer.parseInt(tmp[0]);
                int end = Integer.parseInt(tmp[1]);
                int rst = (int) tree.query(start - 1, end - 1);
                System.out.println(rst);
            }
        }
    }
}


//class SegmentTreeNode{
//    private int s, e;
//    private SegmentTreeNode left, right;
//    long hash;
//
//    SegmentTreeNode(int start, int end) {
//        this.s = start;
//        this.e = end;
//    }
//
//    long query(int start, int end)  {
//        if (start > end || start > e || end < s)
//            return 0;
//        if (start <= s && e <= end)
//            return hash;
//        int m = s + (e - s) / 2;
//        long rst = 1;
//        if (start <= m)
//            rst = Util.hashTwo(rst, left.query(start, end));
//        if (end >= m + 1)
//            rst = Util.hashTwo(rst, right.query(start, end));
//        return rst;
//    }
//
//    @Override
//    public String toString() {
//        return "{" +
//                "[" + s +
//                ", " + e +
//                "], " + hash +
//                '}';
//    }
//}
//
//class SegmentTree{
//
//    private SegmentTreeNode root;
//
//    static SegmentTree get(String s){
//        SegmentTree tree = new SegmentTree();
//        if (s.length() > 0)
//            tree.root = build(s, 0, s.length() - 1);
//        return tree;
//    }
//
//    private static SegmentTreeNode build(String s, int start, int end) {
//        SegmentTreeNode root = new SegmentTreeNode(start, end);
//        if (start == end){
//            root.hash = s.charAt(start) - 28;
//        } else{
//            int mid = (start + end) / 2;
//            root.left = build(s, start, mid);
//            root.right = build(s, mid + 1, end);
//            root.hash = Util.hashTwo(root.left.hash, root.right.hash);
//        }
//        return root;
//    }
//
//    long query(int start, int end){
//        if (root == null)
//            return 0;
//        return root.query(start, end);
//    }
//}

class SegmentTree{

    private String s;
    private long[] hash;

    private SegmentTree(String s) {
        this.s = s;
    }

    static SegmentTree get(String s){
        SegmentTree tree = new SegmentTree(s);
        tree.hash = new long[s.length() * 4];
        tree.build();
        return tree;
    }

    void build(){
        if (s.length() > 0)
            build(0, s.length() - 1, 0);
    }

    private void build(int start, int end, int root) {
        if (start == end){
            hash[root] = s.charAt(start) - 28;
        } else {
            int mid = (start + end) / 2;
            int l = left(root);
            int r = right(root);
            build(start, mid, l);
            build(mid + 1, end, r);
            hash[root] = Util.hashTwo(hash[l], hash[r]);
        }
    }

    private int left(int root) {
        return ((root<<1) + 1);
    }

    private int right(int root){
        return ((root<<1) + 2);
    }

    long query(int start, int end) {
        return query(start, end, 0, s.length() - 1, 0);
    }

    private long query(int start, int end, int l, int r, int root) {
        if (start > end || start > r || end < l)
            return 0;
        if (start <= l && r <= end)
            return hash[root];
        long rst = 1;
        int m = (l + r)>>1;
        if (start <= m)
            rst = Util.hashTwo(rst, query(start, end, l, m, left(root)));
        if (end >= m + 1)
            rst = Util.hashTwo(rst, query(start, end, m + 1, r, right(root)));
        return rst;
    }
}

class Util{
    static long hashTwo(long a, long b){
        return (a * b) % 9973;
    }
}
