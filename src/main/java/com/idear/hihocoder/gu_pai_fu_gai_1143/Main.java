package com.idear.hihocoder.gu_pai_fu_gai_1143;

import java.util.*;

class Matrix{
    private static final int MOD = 19999997;
    int[][] matrix;
    int n;
    Matrix(int n){
        this.n = n;
        matrix = new int[n][n];
    }

    Matrix multiply(Matrix b){
        if (b == null || b.n != n)
            throw new IllegalArgumentException();
        Matrix rst = new Matrix(n);
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                for (int k = 0; k < n; k++){
                    rst.matrix[i][j] = (int)((rst.matrix[i][j] + ((long)(this.matrix[i][k]) * b.matrix[k][j]) % MOD) % MOD);
                }
            }
        }
        return rst;
    }

    Matrix(int[][] matrix){
        this.matrix = matrix;
        this.n = matrix.length;
    }

    int get(int i, int j){
        return matrix[i][j];
    }
}

class Identity extends Matrix{
    Identity(int n){
        super(n);
        init();
    }
    void init(){
        for (int i = 0; i < n; i++)
            Arrays.fill(matrix[i], 1);
    }
}

public class Main{
    private static Matrix matrixPow(Matrix matrix, int n){
        Matrix result = new Identity(matrix.n);
        Matrix tmp = matrix;
        for (; n > 0; n >>= 1){
            if ((n & 1) == 1){
                result = result.multiply(tmp);
            }
            tmp = tmp.multiply(tmp);
        }
        return result;
    }

    private static int fibonacci(int n){
        if (n == 0) return 0;
        int[][] matrix = new int[][]{{1, 1}, {1, 0}};
        Matrix a = new Matrix(matrix);
        Matrix ans = matrixPow(a, n - 1);
        return ans.get(0, 0);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            System.out.println(fibonacci(scanner.nextInt()));
        }
        scanner.close();
    }
}

