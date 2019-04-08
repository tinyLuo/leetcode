package com.ly.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * https://leetcode-cn.com/problems/min-stack/
 * 最小栈
 * @author ly
 *
 */
public class MinStack {
    private List<Integer> stack;
    
    private int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayList<>();
        min = -1;
    }
    
    public void push(int x) {
        int perSize = stack.size();
        stack.add(x);
        if(perSize == 0) {
            min = 0;
        }else {
            if(stack.get(min) > x) {
                min = perSize;
            }
        }
    }
    
    public void pop() {
        int target = stack.get(stack.size()-1);
        if(min == stack.size()-1) {
            if(min == 1) {
                min = -1;
            }else {
                int newMin = Integer.MAX_VALUE;
                for(int i = 0 ; i < stack.size()-1 ; i++) {
                    if(newMin >= stack.get(i)) {
                        newMin = stack.get(i);
                        min = i;
                    }
                }

            }
        }
        stack.remove((Object)target);
    }
    
    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.get(stack.size()-1);
    }
    
    public int getMin() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.get(min);
    }
    
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }
}
