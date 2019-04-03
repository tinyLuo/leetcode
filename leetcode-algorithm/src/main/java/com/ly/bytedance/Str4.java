package com.ly.bytedance;

import java.math.BigDecimal;

/**
 * 
 * https://leetcode-cn.com/explore/interview/card/bytedance/242/string/1015/
 * 字符串相乘
 * @author ly
 *
 */
public class Str4 {
    
    public String multiply(String num1, String num2) {
        BigDecimal big1 = new BigDecimal(num1);
        BigDecimal big2 = new BigDecimal(num2);
        return big1.multiply(big2).toString();
    }
}
