package com.idear.hihocoder.zhao_ze_yu_1082;

import java.util.*;

public class Main{
//    private static String substitute(String s){
//        return s.replaceAll("(?i)marshtomp", "fjxmlhx");
//    }

    private static final String PATTERN = "marshtomp";

    private static final String SUB = "fjxmlhx";

    private static int[] next = findNext(PATTERN);

    private static String substitute(String s){
        for (int index = findMarshtomp(s); index != -1; index = findMarshtomp(s)){
            s = s.substring(0, index) + SUB + s.substring(index + PATTERN.length());
        }
        return s;
    }

    private static int findMarshtomp(String s){
        String p = PATTERN;
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        int m = ss.length;
        int n = pp.length;
        int i = 0;
        int j = 0;
        while (i < m && j < n){
            if (j == -1 || equalsIgnoreCase(ss[i], pp[j])){
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j == n)
            return i - j;
        return -1;
    }

    private static boolean equalsIgnoreCase(char ch1, char ch2){
        return Character.toLowerCase(ch1) == Character.toLowerCase(ch2);
    }

    private static int[] findNext(String p){
        return new int[]{-1, 0, 0, 0, 0, 0, 0, -1, 1};
        // char[] pp = p.toCharArray();
        // int n = pp.length;
        // int[] next = new int[n];
        // int j = 0;
        // int k = -1;
        // next[0] = -1;
        // while (j < n - 1){
        //     if (k == -1 || pp[j] == pp[k]){
        //         j++;
        //         k++;
        //         if (pp[j] == pp[k])
        //             next[j] = next[k];
        //         else
        //             next[j] = k;
        //     } else {
        //         k = next[k];
        //     }
        // }
        // return next;
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(substitute(scanner.nextLine()));
        }
        scanner.close();
    }
}

