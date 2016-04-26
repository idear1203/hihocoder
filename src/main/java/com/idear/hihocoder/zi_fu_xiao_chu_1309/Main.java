package com.idear.hihocoder.zi_fu_xiao_chu_1309;

import java.util.*;

public class Main{
    public static int getScore(String s){
        char[] ss = s.toCharArray();
        int n = ss.length;
        int max = Integer.MIN_VALUE;
        String sub = "ABC";
        for (int i = 0; i < n; i++){
            for (int j = 0; j < 3; j++) {
                String t = s.substring(0, i + 1) + sub.charAt(j) + s.substring(i + 1);
                int score = getStringScore(t);
                max = Math.max(max, score);
            }
        }
        return max;
    }

    private static int getStringScore(String s){
        int score = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n;){
            if (i < n - 1 && s.charAt(i) == s.charAt(i + 1)){
                char ch = s.charAt(i);
                int j;
                for (j = i; j < n && s.charAt(j) == ch; j++);
                score += j - i;
                i = j;
            } else{
                sb.append(s.charAt(i++));
            }
        }
        String after = sb.toString();
        if (after.length() == n)
            return 0;
        return score + getStringScore(after);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
        while (t-- > 0){
            String s = scanner.nextLine();
            System.out.println(getScore(s));
        }
        scanner.close();
    }
}


