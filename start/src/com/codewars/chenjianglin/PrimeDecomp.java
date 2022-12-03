package com.codewars.chenjianglin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 陈江林
 * @date 2022/12/3 06:29
 */
public class PrimeDecomp {

    public static void main(String[] args) {
        System.out.println(factors(86240).equals("(2**5)(5)(7**2)(11)"));
        System.out.println(factors(7775460).equals("(2**2)(3**3)(5)(7)(11**2)(17)"));
    }

    public static String factors(int lst) {
        String result = "";
        for (int fac = 2; fac <= lst; ++fac) {
            int count;
            for (count = 0; lst % fac == 0; ++count) {
                lst /= fac;
            }

            if (count > 0) {
                result += "(" + fac + (count > 1 ? "**" + count : "") + ")";
            }
        }

        return result;
    }

    public static String factors1(int n) {
        StringBuilder resultStr = new StringBuilder();
        // 存储所有素数
        List<Integer> list = new ArrayList();
        // 当前素数
        Integer prime = 2;

        // 如果为 1 结束
        while (n != 1) {
            if (n % prime == 0) {
                // 添加当前素数
                list.add(prime);
                // 除以当前素数
                n /= prime;
            } else {
                // 下一个素数
                prime = nextPrime(prime);
            }
        }

        // 排列格式： "(p1**n1)(p2**n2)...(pk**nk)"
        list.stream()
                // 分组
                .collect(Collectors.groupingBy(item -> item))
                // 排序
                .entrySet().stream().sorted(java.util.Map.Entry.comparingByKey())
                .forEach(item -> {
                    Integer key = item.getKey();
                    int size = item.getValue().size();
                    if (size > 1) {
                        resultStr.append("(" + key + "**" + size + ")");
                    } else {
                        resultStr.append("(" + key + ")");
                    }
                });

        return resultStr.toString();
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
