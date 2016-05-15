package com.idear.hihocoder.baidu_star.forth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangdongwei on 5/14/16.
 */
public class Main {
    public static void main(String[] args) throws IOException{

        Solution sol = new Solution();
        StreamTokenizer st = new StreamTokenizer(new BufferedReader(
                new InputStreamReader(System.in)
        ));
        st.nextToken();
        int t = (int) st.nval;
        while (t-- > 0){
            st.nextToken();
            String s = st.sval;
            System.out.println(sol.getCount(s));
        }
    }
}

class  Solution{

    private Map<String, Integer> map = new HashMap<String, Integer>();

    public int getCount(String s){
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        String key = String.valueOf(ss);
        Integer rst = map.get(key);
        if (rst == null){
            rst = 0;
            map.put(key, 0);
        }
        map.put(key, rst + 1);
        return rst;
    }

}
