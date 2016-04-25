package com.idear.hihocoder.number_triangle_1037;

import java.util.*;

public class Main{
    private static int getMax(int n, List<List<Integer>> matrix){
        int[] dp = new int[n];
        for (int i = 0;  i < n; i++){
            dp[i] = matrix.get(n - 1).get(i);
        }
        for (int i = n - 1; i >= 1; i--){
            for (int j = 0; j < i; j++){
                dp[j] = Math.max(dp[j], dp[j + 1]) + matrix.get(i - 1).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= i; j++){
                list.add(Integer.parseInt(scanner.next()));
            }
            matrix.add(list);
        }
        System.out.println(getMax(n, matrix));
        scanner.close();
    }
}
