package com.idear.hihocoder.kmp_1015;

import  java.util.*;

public class Main{
    private static int patternCnt(String s, String p){
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = ss.length;
        int n = pp.length;
        if (ss.length < pp.length) return 0;
        int[] next = findNext(pp);
        int cnt = 0;
        int i = 0;
        int j = 0;
        while (i < m){
            if (j == -1 || ss[i] == pp[j]){
                i++;
                j++;
            } else {
                j = next[j];
            }
            if (j == n){
              j = next[j];
              cnt++;
            }
        }
        return cnt;
    }

    private static int[] findNext(char[] p){
        int n = p.length;
        int[] next = new int[n + 1];
        if (n == 0) return next;
        next[0] = -1;
        int k = -1;
        int j = 0;
        while (j < n){
            if (k == -1 || p[k] == p[j]){
                ++k;
                ++j;
                if (j == n || p[k] != p[j])
                    next[j] = k;
                else
                    next[j] = next[k];
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- != 0){
            String p = scanner.nextLine();
            String s = scanner.nextLine();
            System.out.println(patternCnt(s, p));
        }
        scanner.close();
    }
}
