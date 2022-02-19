import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, ArrayList<Integer>> map = new HashMap<>();

    public void add(String name, int number) {
        if (map.containsKey(name)) {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(map.get(name));
            list.add(number);
            map.put(name, list);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(number);
            map.put(name, list);
        }
    }

    public ArrayList<Integer> get(String name) {

        return map.get(name);
    }
}
