package com.ly.sort;

import java.util.Stack;

/**
 * 
 * 快速排序 JAVA 实现
 * @author ly
 *
 */
public class QuickSort {

    /**
     * 快排的递归实现
     * @param arr
     * @param start
     * @param end
     */
    public static void recQuickSort(int[] arr, int start, int end) {
        if(end <= start) {
            return ;
        }
        // 随机选取基准点，大于基准点的放到 point 右边，小于的放到 point 左边
        int point = partition(arr, start, end);
        recQuickSort(arr, start, point);
        recQuickSort(arr, point + 1, end);
    }
    
    
    /**
     * 快排的非递归实现
     * @param arr
     * @param start
     * @param end
     */
    public static void iterQuickSort(int[] arr, int start, int end) {
        if(end <= start) {
            return ;
        }
        int point = partition(arr, start, end);
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        stack.push(point+1);
        stack.push(point);
        stack.push(start);
        while (!stack.isEmpty()) {
            int s = stack.pop();
            int e = stack.pop();
            int t = partition(arr, s, e);
            if( t == -1) {
                continue;
            }
            stack.push(e);
            stack.push(t+1);
            stack.push(t);
            stack.push(s);
        }
    }
    
    public static int partition(int[] arr, int start, int end) {
        if(end <= start) {
            return -1;
        }
        int point = start;
        int cp = arr[point];
        for(int i = point+1 ; i < end ; i++) {
            if(arr[i] < cp) {
                //当 i 位置的数据小于基准，将 i 位置的数据放到基准的位置，[point, i-1]全部向右移一位
                arr[point] = arr[i];
                int tmp = i -1;
                while (tmp > point) {
                    int rv = arr[tmp];
                    arr[tmp+1] = rv;
                    tmp--;
                }
                arr[++point] = cp;
            }
        }
        return point;
    }
    
    public static void main(String[] args) {
        int[] arr = {5,1,9,2,6,3,4,8,7,0,11,23,124312,3432,1231312,5342532,12313,54543,7657,2131,32525};
        for(int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println();
        iterQuickSort(arr, 0, arr.length);
        for(int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i] + ",");
        }
    }
}
