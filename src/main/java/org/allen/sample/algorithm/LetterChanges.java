package org.allen.sample.algorithm;


/**
 * Using the Java language, have the function LetterChanges(str) take the str parameter being passed and modify it using the following algorithm. Replace every letter in the string with the letter following it in the alphabet (ie. c becomes d, z becomes a).
 * Then capitalize every vowel in this new string (a, e, i, o, u) and finally return this modified string.
 */
public class LetterChanges {


    public static String LetterChanges(String str) {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char original = chars[i];
            if ((original >= 'a' && original < 'z')) {
                char next = (char) (Integer.valueOf(original) + 1);
                if (next == 'a' || next == 'e' || next == 'i' || next == 'o' || next == 'u') {
                    next = (char)(Integer.valueOf(next) - 32);
                }
                chars[i] = next;
            } else if (original == 'z') {
                chars[i] = 'a';
            }

        }
        return String.valueOf(chars);

    }

    public static void main(String[] args) {
        System.out.println(LetterChanges("hello*3"));
        System.out.println(LetterChanges("fun times! zone"));
        System.out.println(LetterChanges("this long cake@&"));
    }
}
