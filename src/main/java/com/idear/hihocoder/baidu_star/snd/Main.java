package com.idear.hihocoder.baidu_star.snd;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by wangdongwei on 5/14/16.
 */
public class Main {


    public static void main(String[] args) throws IOException {

        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            System.out.println(sol.getFib(n));
        }
    }
}

class Solution{

    String getFib(int n){
        BigInteger ll = BigInteger.valueOf(1);
        BigInteger l = BigInteger.valueOf(1);
        for (int i = 1; i <= n; i++){
            BigInteger tmp = ll.add(l);
            ll = l;
            l = tmp;
        }
        return ll.toString();
    }

}