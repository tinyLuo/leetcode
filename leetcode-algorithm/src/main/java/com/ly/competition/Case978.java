package com.ly.competition;

public class Case978 {

   public int maxTurbulenceSize(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        // A[i] - A[i-1] > 0 => 1
        // A[i] - A[i-1] < 0 => 0
        int p = -1, max = 0;
        int l = 0, r = l+1;
        return 0;
    }
   
}
