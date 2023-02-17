package Hard_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/

public class Solution4 {
    public static void main(String[] args) {
    String[] array = getTokens("привет/амиго!ты крут.как всегда","/!.");
        System.out.println(Arrays.toString(array));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()){
            String line = tokenizer.nextToken();
            list.add(line);
        }
        return list.toArray(new String[0]);
    }
}
