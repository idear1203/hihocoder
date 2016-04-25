package com.idear.hihocoder.bu_ti_jiao_ka_1051;

import java.util.*;

public class Main{
    private static int getLongestDay(int m, int n, int[] nums){
        if (m >= n) return 100;
        int max = nums[m] - 1;
        for (int i = m + 1; i < n; i++){
            max = Math.max(max, nums[i] - nums[i - m - 1] - 1);
        }
        return max;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        while (t-- > 0){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++){
                nums[i] = scanner.nextInt();
            }
            System.out.println(getLongestDay(m, n, nums));
        }
        scanner.close();
    }
}

