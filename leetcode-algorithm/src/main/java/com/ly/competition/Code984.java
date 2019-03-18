package com.ly.competition;

/**
 * 
 * https://leetcode-cn.com/contest/weekly-contest-121/problems/string-without-aaa-or-bbb/
 * 
 * @author ly
 *
 */
public class Code984 {

    public static void main(String[] args) {
        Code984 code984 = new Code984();
        System.out.println(code984.strWithout3a3b(10, 20));
    }

    public String strWithout3a3b(int A, int B) {
        if (2 * (A + 1) < B || 2 * (B + 1) < A) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int aNum = 0;
        int bNum = 0;
        while (A != 0 || B != 0) {
            if (A > B && aNum < 2) {
                // A 的长度大于 B，并且连续写少于 2 次
                builder.append("a");
                aNum++;
                bNum = 0;
                A--;
            } else if (A > B && aNum == 2) {
                builder.append("b");
                aNum = 0;
                bNum++;
                B--;
            } else if (B > A && bNum < 2) {
                builder.append("b");
                bNum++;
                aNum = 0;
                B--;
            } else if (B > A && bNum == 2) {
                builder.append("a");
                bNum = 0;
                aNum++;
                A--;
            } else {
                if (aNum < 2 && A != 0) {
                    builder.append("a");
                    aNum++;
                    bNum = 0;
                    A--;
                } else {
                    builder.append("b");
                    bNum++;
                    aNum = 0;
                    B--;
                }
            }
        }
        return builder.toString();
    }

}
