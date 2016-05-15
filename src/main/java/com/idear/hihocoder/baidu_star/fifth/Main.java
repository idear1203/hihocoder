package com.idear.hihocoder.baidu_star.fifth;

import java.io.IOException;
import java.util.*;

/**
 * Created by wangdongwei on 5/14/16.
 */
public class Main {

    public static void main(String[] args) throws IOException{
        Solution sol = new Solution();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++){
            String s = scanner.nextLine();
            List<Integer>  ids = sol.getResult(s);
            if (ids.size() == 0)
                System.out.println("unique");
            else {
                StringBuilder sb = new StringBuilder();
                sb.append(ids.get(0));
                for (int j = 1; j < ids.size(); j++){
                    sb.append(" ").append(ids.get(j));
                }
                System.out.println(sb.toString());
            }
        }
        scanner.close();
    }
}

class Solution{

    private List<Map<String, Interval>> cache = new ArrayList<Map<String, Interval>>();

    List<Integer> getResult(String s) {
        Map<String, Interval> intervals = parse(s);
//        System.out.println(intervals);
        if (isStringUnique(intervals)) {
            cache.add(null);
            return Collections.emptyList();
        }
        List<Integer> rst = new ArrayList<Integer>();
        for (int i = 0; i < cache.size(); i++){
            if (!isConflict(cache.get(i), intervals))
                rst.add(i + 1);
        }
        cache.add(intervals);
        return rst;
    }

    private boolean isConflict(Map<String, Interval> m1, Map<String, Interval> m2) {
        if (m1 == null)
            return true;
        for (String var : m2.keySet()){
            Interval i1 = m1.get(var);
            if (i1 != null){
                Interval i2 = m2.get(var);
                if (!hasIntersection(i1, i2))
                    return true;
            }
        }
        return false;
    }

    private boolean hasIntersection(Interval i1, Interval i2) {
        if (i1.high > i2.high)
            return hasIntersection(i2, i1);
        return i2.low <= i1.high;
    }

    private Map<String, Interval> parse(String s) {
        s = s.replaceAll("\\s", "");
        Map<String, Interval> map = new HashMap<String, Interval>();
        String[] ss = s.split(",");
        for (String str : ss){
            int i1 = getOpStart(str);
            String var = str.substring(0, i1);
            int i2 = getNumStart(str, i1);
            String op = str.substring(i1, i2);
            int num = Integer.parseInt(str.substring(i2));
            Interval interval = calInterval(op, num);
            Interval value = map.get(var);
            if (value == null)
                map.put(var, interval);
            else {
                map.put(var, merge(value, interval));
            }
        }
        return map;
    }

    private Interval merge(Interval i1, Interval i2) {
        return new Interval(Math.max(i1.low, i2.low), Math.min(i1.high, i2.high));
    }

    private Interval calInterval(String op, int num) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        if (op.equals(">="))
            low = num;
        else if (op.equals("<="))
            high = num;
        else if(op.equals("<"))
            high = num - 1;
        else if (op.equals(">"))
            low = num + 1;
        else if (op.equals("==")){
            high = num;
            low = num;
        }
        return new Interval(low, high);
    }

    private int getNumStart(String str, int i1) {
        for (int i = i1; i < str.length(); i++){
            char ch = str.charAt(i);
            if (ch != '>' && ch != '<' && ch != '=')
                return i;
        }
        return 0;
    }

    private int getOpStart(String str) {
        for (int i = 0; i < str.length(); i++){
            if (!(str.charAt(i) >= 'a' && str.charAt(i) <= 'z'))
                return i;
        }
        return 0;
    }

    private boolean isStringUnique(Map<String, Interval> intervals) {
        for (String s : intervals.keySet()){
            Interval interval = intervals.get(s);
            if (interval.high < interval.low)
                return true;
        }
        return false;
    }
}

class Interval {
    int low;
    int high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }

    @Override
    public String toString() {
        return "{" + low + "," + high + "}";
    }
}
