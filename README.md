# codewars
# 一 算法
## Convert string to camel case
> Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as Pascal case). The next words should be always capitalized.

Examples:
"the-stealth-warrior" gets converted to "theStealthWarrior"
"The_Stealth_Warrior" gets converted to "TheStealthWarrior"

### 第一种解法
```java
package com.codewars.chenjianglin;

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
        String[] split = s.split("(_|-)");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(split[0]);
        for (int i = 1; i < split.length; i++) {
            String str = split[i];
            String substring = str.substring(0, 1);
            stringBuilder.append(substring.toUpperCase() + str.substring(1));
        }

        return stringBuilder.toString();
    }

}
```

### 第二种解法-`steam`
```java
import java.util.Arrays;

class Solution{

    static String toCamelCase(String str){
        String[] words = str.split("[-_]");
        return Arrays.stream(words, 1, words.length)
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                .reduce(words[0], String::concat);
    }
}
```

### 第三种解法-正则表达式
```java
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.StringBuilder;

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
```