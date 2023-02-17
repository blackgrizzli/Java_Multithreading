package Hard_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }
    public static String getPartOfString(String string) {
//        String line = "";
//        Pattern pt = Pattern.compile("(\\s[^\\s.]+){4}");
//        Matcher mat = pt.matcher(string);
//        if (mat.find()) {
//            line+= mat.group();
//        }return line;
//    }
//-------------------------------------------------------
        String line = "";
        try {
        String[] array = string.split("\\s");
            for (int i = 1; i < 5; i++) {
                line += array[i] + " ";
            }
        }catch (IndexOutOfBoundsException | NullPointerException e ){
            throw new TooShortStringException();
        }
        return line.trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
