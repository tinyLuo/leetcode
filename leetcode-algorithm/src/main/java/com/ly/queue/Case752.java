package com.ly.queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * https://leetcode-cn.com/problems/open-the-lock/
 * 打开转盘锁
 * @author ly
 *
 */
public class Case752 {
    
    public static int openLock(String[] deadends, String target) {
        if (deadends == null || deadends.length == 0) {
            return -1;
        }
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String start = "0000";
        if(deadSet.contains(start) || deadSet.contains(target)) {
            return -1;
        }
        queue.add("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            List<String> level = new ArrayList<>();
            step++;
            while (!queue.isEmpty()) {
                String cur = queue.poll();
                if(cur.equals(target)) {
                    return step;
                }
                visited.add(cur);
                List<String> nexts = getNext(cur);
                for(String next : nexts) {
                    if(visited.contains(next) || deadSet.contains(next)) {
                        continue;
                    }
                    if(next.equals(target)) {
                        return step;
                    }
                    visited.add(next);
                    level.add(next);
                }
            }
            queue.addAll(level);
            level.clear();
        }
        return -1;
    }
    
    
    private static List<String> getNext(String cur) {
        List<String> list = new ArrayList<>();
        //长度为四，每个位可以向上或者向下移一位
        for(int i = 0 ; i < cur.length() ; i++) {
            char ic = cur.charAt(i);
            //向上
            if(ic == '0') {
                list.add(cur.substring(0, i) + '9' + cur.substring(i+1));
            }else {
                list.add(cur.substring(0, i) + ((char)((int)ic-1)) + cur.substring(i+1));
            }
            
            //向下
            if(ic == '9') {
                list.add(cur.substring(0, i) + '0' + cur.substring(i+1));
            }else {
                list.add(cur.substring(0, i) + ((char)((int)ic+1)) + cur.substring(i+1));
            }
        }
        
        return list;
    }
    
    public static void main(String[] args) {
        System.out.println(openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202"));
        System.out.println(openLock(new String[] {"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
        System.out.println(openLock(new String[] {"0000"}, "8888"));
    }
}
