package com.ly.array;

import java.util.ArrayList;
import java.util.List;

public class Case118 {
    
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows <= 0) {
            return res;
        }
        List<Integer> one = new ArrayList<>();
        one.add(1);
        res.add(one);
        
        for(int i = 1 ; i < numRows ; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0 ; j < i+1 ; j++) {
                if(j == 0) {
                    list.add(1);
                }else if (j == i) {
                    list.add(1);
                }else {
                    list.add(res.get(i-1).get(j) + res.get(i-1).get(j-1));
                }
            }
            res.add(list);
        }
        return res;
    }
    
}
