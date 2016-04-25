package com.idear.hihocoder.zero_one_package_1043;

import java.util.*;

public class Main{
    private static int getAmount(int[] need, int[] value, int m, int n){
        int[] dp = new int[n + 1];
        for (int i = 1; i <= m; i++){
            for (int j = n; j >= need[i - 1]; j--){
                dp[j] = Math.max(dp[j], dp[j - need[i - 1]] + value[j]);
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        int m = Integer.parseInt(s[0]);
        int n = Integer.parseInt(s[1]);
        int[] need = new int[m];
        int[] value = new int[m];
        for (int i = 0; i < m; i++){
            s = scanner.nextLine().split(" ");
            need[i] = Integer.parseInt(s[0]);
            value[i] = Integer.parseInt(s[1]);
        }
        System.out.println(getAmount(need, value, m, n));
        scanner.close();
    }
}


