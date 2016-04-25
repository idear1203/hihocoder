package com.idear.hihocoder.magic_box_1135;

import java.util.*;

class Solution{
    public int getMax(String s, int[] xyz){
        Arrays.sort(xyz);
        char[] ss = s.toCharArray();
        int n = ss.length;
        int max = 0;
        int cnt = 0;
        int rCnt = 0;
        int yCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < n; i++){
            cnt++;
            max = Math.max(cnt, max);
            if (ss[i] == 'R'){
                rCnt++;
            } else if (ss[i] == 'Y'){
                yCnt++;
            } else if (ss[i] == 'B'){
                bCnt++;
            }
            int[] diff = calDiff(rCnt, yCnt, bCnt);
            if (diff[0] == xyz[0] && diff[1] == xyz[1] && diff[2] == xyz[2]){
                cnt = 0;
                rCnt = yCnt = bCnt = 0;
            }
        }
        return max;
    }

    private int[] calDiff(int r, int y, int b){
        int[] ryb = {Math.abs(r - y), Math.abs(r - b), Math.abs(y - b)};
        Arrays.sort(ryb);
        return ryb;
    }
}

public class Main{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        int[] xyz = new int[3];
        xyz[0] = Integer.parseInt(scanner.next());
        xyz[1] = Integer.parseInt(scanner.next());
        xyz[2] = Integer.parseInt(scanner.next());
        scanner.nextLine();
        String s = scanner.nextLine();
        System.out.println(solution.getMax(s, xyz));
    }
}

