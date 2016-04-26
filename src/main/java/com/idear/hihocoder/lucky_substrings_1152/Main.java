package com.idear.hihocoder.lucky_substrings_1152;

//枚举所有子串，看是否满足条件
import java.util.*;

public class Main{

    private static final Set<Integer> fibs = initFib();

    private static Set<Integer> initFib(){
        Set<Integer> set = new HashSet<>();
        int ll = 0;
        int l = 1;
        do{
            set.add(l);
            int num = ll + l;
            ll = l;
            l = num;
        }while(l < 100);
        return set;
    }

    private static Queue<String> getLuckySubstring(String s){
        Queue<String> queue = new PriorityQueue<>();
        Set<String> visit = new HashSet<>();
        int n = s.length();
        for (int i = 0; i <= n - 1; i++){
            for (int j = i + 1; j <= n; j++){
                String t = s.substring(i, j);
                if (!visit.contains(t)){
                    visit.add(t);
                    if (isAllFib(t)){
                        queue.offer(t);
                    }
                }
            }
        }
        return queue;
    }

    private static boolean isAllFib(String s){
        boolean[] hash = new boolean[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (!hash[ch - 'a']){
                hash[ch - 'a'] = true;
                count++;
            }
        }
        return fibs.contains(count);
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Queue<String> queue = getLuckySubstring(line);
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
        scanner.close();
    }
}
