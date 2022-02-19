import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap();

        // First item
        list.add("Тимофей");
        list.add("Алексей");
        list.add("Александр");
        list.add("Павел");
        list.add("Сергей");
        list.add("Тимофей");
        list.add("Сергей");
        list.add("Тимофей");
        list.add("Алексей");
        list.add("Тимофей");

        for (String s : list) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }else{
                map.put(s, 1);
            }
        }
        System.out.println(map);

        //Second item
        telephoneDirectory.add("Тимофей", 1122334455);
        telephoneDirectory.add("Тимофей", 999999999);
        telephoneDirectory.add("Сергей", 1111111);
        System.out.println(telephoneDirectory.get("Тимофей"));
    }
}
