package Hard_test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Формируем WHERE
*/
//{name=Ivanov, country=Ukraine, city=Kiev, age=null}
public class Solution2 {
    public static void main(String[] args) {
    Map<String,String> map = new LinkedHashMap<>();

        map.put("name","Ivanov");
        map.put("country","Ukraine");
        map.put("city","Kiev");
        map.put("age",null);

        String line = getQuery(map);
        System.out.println(line);
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder("");
        for(Map.Entry<String, String> x : params.entrySet()){
            String form = String.format("%s = '%s'",x.getKey(),x.getValue());
            if(x.getKey()!=null && x.getValue()!=null) {
                sb.append(form);
                sb.append(" and ");
            }
        }
        return sb.substring(0,sb.lastIndexOf("and"));
    }
}
//name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'