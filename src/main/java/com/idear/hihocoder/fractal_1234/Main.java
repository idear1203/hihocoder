package com.idear.hihocoder.fractal_1234;

import java. util.*;

class Solution{
    private double[] points;
    Solution(){
        points = initialize();
    }

    private double[] initialize(){
        double[] points = new double[502];
        points[0] = 0;
        points[1] = 0.25;
        for (int i = 2; i <= 500; i++){
          points[i] = (points[i - 1] + 0.5) / 2;
        }
        points[501] = 0.5;
        return points;
    }

    public int findPoint(double val){
        int s = 0;
        int e = 502;
        while (s < e){
            int m = s + (e - s) / 2;
            if (points[m] < val){
                s = m + 1;
            } else {
                e = m;
            }
        }
        return s;
    }

    public double getPoint(int i){
        return points[i];
    }
}

public class Main{
    public static void main(String[] args){
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0){
            double val = scanner.nextDouble();
            int index = sol.findPoint(val);
            double p = sol.getPoint(index);
            int rst;
            if (p == val){
                rst = -1;
            } else {
                rst = index * 4;
            }
            System.out.println(rst);
        }
        scanner.close();
    }
}

