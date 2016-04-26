package com.idear.hihocoder.complete_package_1043;

import java.util.*;
public class Main{
    private static int completePackage(int[] need, int[] value, int n, int m){
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++){
            for (int j = need[i - 1]; j <= m; j++){
                dp[j] = Math.max(dp[j], dp[j - need[i - 1]] + value[i - 1]);
            }
        }
        return dp[m];
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] need = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++){
            need[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }
        System.out.println(completePackage(need, value, n, m));
        scanner.close();
    }
}

