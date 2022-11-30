package com.codewars.chenjianglin;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution{

    static String toCamelCase(String s){
        Matcher m = Pattern.compile("[_|-](\\w)").matcher(s);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, m.group(1).toUpperCase());
        }

        return m.appendTail(sb).toString();
    }
}

/**
 * @author 陈江林
 * @date 2022/11/30 13:04
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(toCamelCase("the-stealth-warrior").equals("theStealthWarrior"));
        System.out.println("--");
        System.out.println(toCamelCase("The_Stealth_Warrior").equals("TheStealthWarrior"));
    }

    /**
     * "the-stealth-warrior"转换为"theStealthWarrior"
     * "The_Stealth_Warrior"转换为"TheStealthWarrior"
     *
     * @param s
     * @return
     */
    static String toCamelCase(String s) {
//        String[] split = s.split("(_|-)");
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(split[0]);
//        for (int i = 1; i < split.length; i++) {
//            String str = split[i];
//            String substring = str.substring(0, 1);
//            stringBuilder.append(substring.toUpperCase() + str.substring(1));
//        }
//
//        return stringBuilder.toString();

        String[] split = s.split("(_|-)");
        return Arrays.stream(split, 1, split.length)
                .map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
                .reduce(split[0], String::concat);
    }


}
