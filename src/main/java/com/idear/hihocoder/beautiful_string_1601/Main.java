package com.idear.hihocoder.beautiful_string_1601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

/**
 * Created by wangdongwei on 5/5/16.
 */
public class Main {
    private static boolean isBeautifulString(String s, int n){
        if (s.length() < 3)
            return false;
        int[] cnt = new int[n];
        char[] chs = new char[n];
        int a = 0;
        char pivot = s.charAt(0);
        chs[0] = pivot;
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == pivot){
                cnt[a]++;
            } else {
                a++;
                pivot = s.charAt(i);
                chs[a] = pivot;
                cnt[a] = 1;
            }
        }
//        System.out.println(Arrays.toString(chs));
//        System.out.println(Arrays.toString(cnt));
        for (int i = 0; i <= a - 2; i++){
            if (chs[i] + 1 == chs[i + 1] && chs[i] + 2 == chs[i + 2] && cnt[i + 1] <= cnt[i] && cnt[i + 2] >= cnt[i + 1])
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(
                new InputStreamReader(System.in)
        ));
        st.nextToken();
        int t = (int) st.nval;
        while (t-- > 0){
            st.nextToken();
            int n = (int) st.nval;
            st.nextToken();
            String s = st.sval;
            boolean rst = isBeautifulString(s, n);
            if (rst)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
