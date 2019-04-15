package com.ly.binarysearch;

import java.util.LinkedList;
import java.util.List;

public class Case658 {
    
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new LinkedList<>();
        if(arr == null || arr.length == 0) {
            return list;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            int mv = arr[mid];
            if(mv == x) {
                break;
            }else if (x < mv) {
                right = mid - 1;
            }else {
                left = mid + 1;
            }
            if(left > right) {
                break;
            }
            mid = left + (right - left) / 2;
        }
        
        int len = arr.length;
        if(mid == 0) {
            for(int i = 0 ; i < k; i++) {
                if(i < len) {
                    list.add(arr[i]);
                }
            }
        }else if (mid == len - 1) {
            for(int i = 0 ; i < k; i++) {
                if(len - i - 1 >= 0) {
                    list.add(0, arr[len-i-1]);
                }
            }
        }else {
            int z = mid;
            int y = mid + 1;
            for(int i = 0 ; i < k ; i++) {
                if(y == len && z == -1) {
                    break;
                }
                if(z == -1 && y != len) {
                    list.add(arr[y]);
                    y++;
                    continue;
                }
                if(y == len && z != -1) {
                    list.add(0, arr[z]);
                    z--;
                    continue;
                }
                if(x - arr[z] <= arr[y] - x) {
                    list.add(0, arr[z]);
                    z--;
                }else if(x - arr[z] > arr[y] - x){
                    list.add(arr[y]);
                    y++;
                }else {
                    break;
                }
            }
        }
        return list;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[] {0,0,1,2,3,3,4,7,7,8};
        findClosestElements(arr, 3, 5);
    }
    
}
