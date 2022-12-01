package com.codewars.chenjianglin;

/**
 * 数字和/数字根
 * <p>
 * 说明：
 * 数字根是数字中所有数字的递归和。
 * 给定n，取n的位数之和。如果该值超过一位数，则继续以这种方式减少，直到产生一个位数。输入将是非负整数。
 * <p>
 * 示例:
 * 16  -->  1 + 6 = 7
 * 942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 *
 * @author 陈江林
 * @date 2022/12/1 08:29
 */
public class SumOfDigits {

    public static void main(String[] args) {
        System.out.println(digital_root(16) == 7);
        System.out.println(digital_root(942) == 6);
        System.out.println(digital_root(132189) == 6);
    }

    public static int digital_root(int n) {
        int value = getSum(n);
        // 如果它们的和大于 9，再次计算
        while (value > 9) {
            value = getSum(value);
        }

        return value;
    }

    /**
     * 将每个整数循环相加
     *
     * @param n 整数
     * @return 和
     */
    public static int getSum(int n) {
        // 定义一个整数
        int sum = 0;
        // 将整数转为字符数组
        char[] chars = String.valueOf(n).toCharArray();
        // 循环数组
        for (int i = 0; i < chars.length; i++) {
            // 将字符转为整数
            int charsInt = chars[i] - '0';
            // 将每个整数循环相加
            sum += charsInt;
        }

        // 返回每个整数的和
        return sum;
    }

}
