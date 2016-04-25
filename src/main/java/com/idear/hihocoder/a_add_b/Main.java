package com.idear.hihocoder.a_add_b;

import java.util.Scanner;

/**
 * Created by wangdongwei on 4/25/16.
 */
public class Main{
    public static void main(String[] args)    {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNextInt()){
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            System.out.println(a + b);
        }
    }
}
