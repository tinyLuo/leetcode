package com.ly.string;

public class Case67 {
    
    public static String addBinary(String a, String b) {
        if(a == null || b == null) {
            return "";
        }
        StringBuilder builder = new StringBuilder();
        int jw = 0;
        int aLen = a.length();
        int bLen = b.length();
        int minLen = Math.min(aLen, bLen);
        for(int i = 0; i < minLen ; i++) {
            int ac = a.charAt(aLen - i - 1) - '0';
            int bc = b.charAt(bLen - i - 1) - '0';
            int sum = ac + bc + jw;
            if(sum == 0) {
                builder.append(0);
                jw = 0;
            }else if (sum == 1) {
                builder.append(1);
                jw = 0;
            }else if (sum > 1) {
                builder.append(sum % 2);
                jw = 1;
            }
        }
        if(aLen == bLen) {
            if(jw == 1) {
                builder.append(1);
            }
        }else {
            build(builder, minLen, jw, a);
            build(builder, minLen, jw, b);
        }
        return builder.reverse().toString();
        
    }
    
    public static void build(StringBuilder builder, int start, int jw, String s) {
        if(s.length() == start) {
            return ;
        }
        for(int i = s.length() - start - 1; i >= 0 ; i--) {
            int sc = s.charAt(i) - '0';
            int sum = sc + jw;
            if(sum == 0) {
                builder.append(0);
                jw = 0;
            }else if (sum == 1) {
                jw = 0;
                builder.append(1);
            }else if (sum > 1) {
                builder.append(sum % 2);
                jw = 1;
            }
        }
        if(jw == 1) {
            builder.append(1);
        }
    }
    
    public static void main(String[] args) {
        System.out.println(addBinary("100", "110010"));
    }
    
}
