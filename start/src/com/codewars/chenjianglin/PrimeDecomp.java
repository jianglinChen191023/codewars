package com.codewars.chenjianglin;

/**
 * @author 陈江林
 * @date 2022/12/3 06:29
 */
public class PrimeDecomp {

    public static void main(String[] args) {
        System.out.println(factors(86240).equals("(2**5)(5)(7**2)(11)"));
//        System.out.println(factors(7775460).equals("(2**2)(3**3)(5)(7)(11**2)(17)"));
    }

    public static String factors2(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; fac++) {
            int count;
            for (count = 0; lst % fac == 0; count++) {
                lst /= fac;
            }

            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }

        return result;
    }

    public static String factors(int n) {
        String resultStr = "";
        // 当前素数
        Integer prime = 2;

        // 如果为 1 结束
        while (n != 1) {
            if (n % prime == 0) {
                Integer count = 0;
                while (n % prime == 0) {
                    // 除以当前素数
                    n /= prime;
                    count++;
                }

                resultStr += "(" + prime + (count > 1 ? "**" + count : "") + ")";
            } else {
                // 下一个素数
                prime = nextPrime(prime);
            }
        }

        return resultStr;
    }

    /**
     * 下一个素数
     *
     * @param prime 素数
     * @return
     */
    public static Integer nextPrime(int prime) {
        if (2 == prime) {
            return 3;
        }

        prime += 2;
        // 素数：除2以外偶数都不是，不能被 3 取余的数
        while (prime % 3 == 0) {
            prime += 2;
        }

        return prime;
    }

}
