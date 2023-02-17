package Hard_test;

import java.io.*;
import java.util.*;

/*
Составить цепочку слов
*/

public class So {
    public static void main(String[] args) throws IOException {
        StringBuilder result = null;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader("src/Hard_test/file2.txt"))) {
            while (reader.ready()) {
                String[] line = reader.readLine().split("\s");
                result = getLine(line);
            }
        }
        assert result != null;
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>(List.of(words));
        int RandomIndex = (int) (Math.random() * 5);
        boolean is = true;
        String LastIndexLine = "";

        for (int i = 4; i < list.size(); ) {
            for (int j = 0; j < list.size(); ) {

//                Киев Нью-Йорк Амстердам Вена Мельбурн
                if (LastIndexLine.equalsIgnoreCase(String.valueOf(list.get(j).charAt(0)))) {
                    sb.append(list.get(j)).append(" ");
                    list.remove(list.get(j));
                    LastIndexLine = String.valueOf(sb.charAt(sb.length() - 2));
                    j = 0;

                }else if(is) {
                    if (String.valueOf(list.get(i).charAt(list.get(i).length() - 1))
                            .equalsIgnoreCase(String.valueOf(list.get(j).charAt(0)))) {
                        sb.append(list.get(i)).append(" ").append(list.get(j));
                        sb.append(" ");
                        LastIndexLine = String.valueOf(sb.charAt(sb.length() - 2));
                        list.remove(list.get(i));
                        list.remove(list.get(j));
                        is = false;
                        j = 0;
                    }else{
                        j++;
                    }
                }else {
                    j++;
                }

            }
        }
        ttt:
        System.out.println(RandomIndex);
        return sb;
    }
}

