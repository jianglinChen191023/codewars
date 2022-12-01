package com.codewars.chenjianglin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串增量器
 * ● 说明：您的工作是编写一个函数，使字符串递增，以创建一个新字符串。
 * ○ 如果字符串已以数字结尾，则数字应递增1。
 * ○ 如果字符串不以数字结尾。数字1应附加到新字符串。
 * ● 示例：
 * foo -> foo1
 * foobar23 -> foobar24
 * foo0042 -> foo0043
 * foo9 -> foo10
 * foo099 -> foo100
 * 注意：如果数字有前导零，则应考虑位数。
 *
 * @author 陈江林
 * @date 2022/12/1 13:39
 */
public class Kata {

    public static void main(String[] args) {
        System.out.println(incrementString("").equals("1"));
        System.out.println(incrementString("foo12").equals("foo13"));
        System.out.println(incrementString("foobar23").equals("foobar24"));
        System.out.println(incrementString("foo0042").equals("foo0043"));
        System.out.println(incrementString("foobar000").equals("foobar001"));
        System.out.println(incrementString("foobar099").equals("foobar100"));
        System.out.println(incrementString("XOnrXQO~XA@@l-;ZFtW0Eu9|:'/Tu:{>2313419851783033058206379529").equals("XOnrXQO~XA@@l-;ZFtW0Eu9|:'/Tu:{>2313419851783033058206379530"));
    }

    public static String incrementString(String str) {
        // [0-8]?：匹配0到8，0次或1次
        // [9]*$：匹配在最后所有的9（* 0次或多次，$ 匹配最后的）
        Matcher m = Pattern.compile("([0-8]?[9]*$)").matcher(str);
        StringBuffer sb = new StringBuffer();
        if (m.find() && !"".equals(m.group())) {
            m.appendReplacement(sb, String.valueOf(Integer.parseInt(m.group()) + 1));
            return sb.toString();
        } else {
            return str + "1";
        }
    }

}
