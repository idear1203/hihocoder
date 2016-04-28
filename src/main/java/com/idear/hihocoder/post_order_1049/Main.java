package com.idear.hihocoder.post_order_1049;

import java.util.*;

public class Main{
    public static String postOrder(String preOrder, String inOrder){
        if (preOrder.length() == 0)
            return "";
        char root = preOrder.charAt(0);
        int i = inOrder.indexOf(root);
        String inOrderLeft = inOrder.substring(0, i);
        String inOrderRight = inOrder.substring(i + 1);
        String preOrderLeft = preOrder.substring(1, 1 + inOrderLeft.length());
        String preOrderRight = preOrder.substring(1 + inOrderLeft.length());
        return postOrder(preOrderLeft, inOrderLeft)
            + postOrder(preOrderRight, inOrderRight) + root;
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String preOrder = scanner.nextLine();
        String inOrder = scanner.nextLine();
        System.out.println(postOrder(preOrder, inOrder));
        scanner.close();
    }
}
