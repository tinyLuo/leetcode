package com.ly.stack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Case841 {
    
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if(rooms == null || rooms.isEmpty()) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        stack.addAll(rooms.get(0));
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!stack.isEmpty()) {
            int next = stack.pop();
            if(visited.contains(next)) {
                continue;
            }
            visited.add(next);
            stack.addAll(rooms.get(next));
        }
        if(visited.size() == rooms.size()) {
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(0);
        list2.add(1);
        List<Integer> list3 = new ArrayList<>();
        list3.add(2);
        List<Integer> list4 = new ArrayList<>();
        list1.add(0);
        List<List<Integer>> list = new ArrayList<>();
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);
        System.out.println(canVisitAllRooms(list));
    }
}
