package org.allen.sample.algorithm;

/**
 * Using the Java language, have the function LetterCapitalize(str) take the str parameter being passed and capitalize the first letter of each word.
 * Words will be separated by only one space.
 */
public class LetterCapitalize {

    public static String LetterCapitalize(String str) {
        String[] array = str.split(" ");

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < array.length; i++) {
            char[] chars = array[i].toCharArray();
            chars[0] -= 32;
            sb.append(new String(chars));
            if (i < array.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(LetterCapitalize("hello world"));
        System.out.println(LetterCapitalize("i ran there"));
    }
}
