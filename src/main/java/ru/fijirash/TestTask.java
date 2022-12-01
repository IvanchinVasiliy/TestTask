package ru.fijirash;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestTask {
    public static void main(String[] args) {
        String str = ")(()()())";
        System.out.println(getCount(str));
    }


    public static StringBuilder getCount(String str) {
        char[] chars= str.toCharArray();
        List<Character> charArray = Stream.generate(() -> '0')
                .limit(chars.length)
                .collect(Collectors.toList());

        int counter = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            if (chars[i-1] == '(' && chars[i] == ')') {
                charArray.add(i-1, chars[i-1]);
                charArray.add(i, chars[i]);
                chars[i-1] = '0';
                chars[i] = '0';
                counter++;
            }
        }

        for (int j = 0; j < chars.length - 1; j++) {
            for (int k = chars.length - 1; k > j; k--) {
                if (chars[j] == '(' && chars[k] == ')') {
                    charArray.add(j, chars[j]);
                    charArray.add(k, chars[k]);
                    chars[j] = '0';
                    chars[k] = '0';
                    counter++;
                }
            }
        }

        StringBuilder newStr = new StringBuilder();
        if (counter != 0) {
            newStr.append(counter * 2);
            newStr.append(" - \"");
            for (char c: charArray) {
                if (c != '0') {
                    newStr.append(c);
                }
            }
            newStr.append("\"");
        } else {
            newStr.append(counter);
        }

        return newStr;
    }
}
