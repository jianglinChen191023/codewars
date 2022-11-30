package com.codewars.chenjianglin;

/**
 * @author 陈江林
 * @date 2022/11/30 20:42
 */
public class BitCounting {

    public static void main(String[] args) {
//        1234的二进制表示是10011010010，因此在这种情况下，函数应该返回5
        System.out.println(countBits(1234) == 5);
    }

    public static int countBits(int n) {
//        int res = 0;
//        // 转换成二进制
//        String s = Integer.toBinaryString(n);
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            res += chars[i] - '0';
//        }
//
//        return res;
        return Integer.bitCount(n);
    }

}
