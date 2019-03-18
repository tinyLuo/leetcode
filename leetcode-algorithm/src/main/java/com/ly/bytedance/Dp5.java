package com.ly.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * 三角形最小路径和
 * @author ly
 *
 */
public class Dp5 {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        // triangle(x,y) = min(triangle(x+1, y),triangle(x+1,y+1)) + triangle[x,y]
        int xLen = triangle.size();
        int[][] dp = new int[xLen][triangle.get(xLen-1).size()];
        for(int i = xLen - 1 ; i >= 0 ; i--) {
            List<Integer> list = triangle.get(i);
            for(int j = 0 ; j < list.size() ; j++) {
                if(i == xLen-1) {
                    dp[i][j] = triangle.get(i).get(j);
                }else {
                    dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1]) + triangle.get(i).get(j);
                }
            }
        }
        
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        int[][] tri = new int[4][4];
        tri[0] = new int[] {2};
        tri[1] = new int[] {3,4};
        tri[2] = new int[] {6,5,7};
        tri[3] = new int[] {4,1,8,3};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list.add(list1);
        
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list.add(list2);
        
        List<Integer> list3 = new ArrayList<>();
        list3.add(6);
        list3.add(5);
        list3.add(7);
        list.add(list3);
        
        List<Integer> list4 = new ArrayList<>();
        list4.add(4);
        list4.add(1);
        list4.add(8);
        list4.add(3);
        list.add(list4);
        Dp5 dp5 = new Dp5();
        dp5.minimumTotal(list);
        
    }
    
}
