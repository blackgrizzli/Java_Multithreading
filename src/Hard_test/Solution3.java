package Hard_test;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/

public class Solution3 {
    public static void main(String[] args) throws IOException {
        StringBuilder result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader("src/Hard_test/file2.txt"))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split("\\s");
                result = getLine(line);
            }
        }
        assert result != null;
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(List.of(words));
        String RandomIndex = list.get((int) (Math.random() * 5));
        String LastIndexLine = "";
        for (int i = 0; i < list.size(); i++) {
            if (String.valueOf(RandomIndex.charAt(RandomIndex.length() - 1))
                    .equalsIgnoreCase(String.valueOf(list.get(i).charAt(0)))) {
                sb.append(RandomIndex).append(" ").append(list.get(i)).append(" ");
                list.remove(list.get(i));
                LastIndexLine = String.valueOf(sb.charAt(sb.length() - 2));
                break;
            }
        }
        list.remove(RandomIndex);

        for (int i = 0; i < list.size(); ) {
            if (LastIndexLine.equalsIgnoreCase(String.valueOf(list.get(i).charAt(0)))) {
                sb.append(list.get(i)).append(" ");
                list.remove(list.get(i));
                LastIndexLine = String.valueOf(sb.charAt(sb.length() - 2));
                i=0;
            }else {
                i++;
            }
        }
        sb.deleteCharAt(sb.lastIndexOf(" "));
        return sb;
    }
}
