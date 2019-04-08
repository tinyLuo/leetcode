package com.ly.stack;

import java.util.Stack;

public class Case394 {

    public static String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Stack<Character> khStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> dataStack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == ']') {
                int num = numStack.pop();
                khStack.pop();
                String data = dataStack.pop();
                StringBuilder builder2 = new StringBuilder();
                for (int j = 0; j < num; j++) {
                    builder2.append(data);
                }
                if (!khStack.isEmpty() && khStack.peek() == '[') {
                    if (!dataStack.isEmpty() && dataStack.size() == khStack.size()) {
                        data = dataStack.pop() + builder2.toString();
                    } else {
                        data = builder2.toString();
                    }
                    dataStack.push(data);
                } else {
                    builder.append(builder2);
                }
            } else if (cur == '[') {
                khStack.push(cur);
            } else if ((int) (cur - '0') >= 0 && (int) (cur - '0') <= 9) {
                int j = i + 1;
                while (j < s.length() && isDigit(s.charAt(j))) {
                    j++;
                }
                int num = Integer.parseInt(s.substring(i, j));
                numStack.push(num);
                i = --j;
            } else {
                // 字母
                int j = i + 1;
                while (j < s.length() && !isDigit(s.charAt(j)) && s.charAt(j) != ']' && s.charAt(j) != '[') {
                    j++;
                }
                String data = s.substring(i, j);
                if (khStack.isEmpty()) {
                    builder.append(data);
                    continue;
                }
                if (!dataStack.isEmpty() && dataStack.size() == khStack.size()) {
                    dataStack.push(dataStack.pop() + data);
                } else {
                    dataStack.push(data);
                }
                i = --j;
            }
        }
        if (!dataStack.isEmpty()) {
            builder.append(dataStack.pop());
        }
        return builder.toString();
    }

    public static boolean isDigit(char c) {
        if ((int) (c - '0') >= 0 && (int) (c - '0') <= 9) {
            return true;
        }
        return false;
    }

    public String decodeString2(String s) {
        if (s == null || s.length() == 0)
            return "";
        Stack<String> strST = new Stack<>();
        Stack<Integer> numST = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9')
                i = getNum(i, s, numST);
            else if (c >= 'a' && c <= 'z')
                i = getStr(i, s, strST);
            else if (c >= 'A' && c <= 'Z')
                i = getStr(i, s, strST);
            else if (c == ']') {
                calculate(numST, strST);
                i++;
            } else {
                strST.push("[");
                i++;
            }
        }
        String ans = "";
        while (!strST.isEmpty()) {
            String t = strST.pop();
            ans = t + ans;
        }
        return ans;
    }

    private int getNum(int i, String s, Stack<Integer> st) {
        String num = "";
        int j = i;
        for (; j < s.length() && s.charAt(j) >= '0' && s.charAt(j) <= '9'; j++)
            num += s.charAt(j);
        st.push(Integer.valueOf(num));
        return j;
    }

    private int getStr(int i, String s, Stack<String> st) {
        String str = "";
        int j = i;
        for (; j < s.length()
                && ((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')); j++)
            str += s.charAt(j);
        st.push(str);
        return j;
    }

    private void calculate(Stack<Integer> numST, Stack<String> strST) {
        StringBuilder S = new StringBuilder();
        int x = numST.pop();
        String s = "";
        while (!strST.isEmpty()) {
            String t = strST.pop();
            if (t.equals("["))
                break;
            s = t + s;
        }
        for (int i = 0; i < x; i++)
            S.append(s);
        strST.push(S.toString());

    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[z]2[2[y]pq4[2[jk]e1[f]]]ef"));
        // System.out.println(decodeString("3[a2[c]]"));
        // System.out.println(decodeString("2[abc]3[cd]ef"));
    }
}
