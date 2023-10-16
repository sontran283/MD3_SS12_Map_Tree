package AtClass.Map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DemoMap {
    public static void main(String[] args) {
        // replace  neu ton tai key thi replace value moi
        // rentry tao ra mot entry moi
        // set  tra ra cac rntry cua map
        // get  tra ra value theo ley truyen vao
        // collection tra ra tap hop cac gia tri cua map

        Map<Integer, String> map = new HashMap<>();
        System.out.println(map.isEmpty() ? "map dang rong" : "map dang chua du lieu");
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");

        map.replace(1, "100");  // thay the luon cai thu 1
        map.replace(5, "1000");

        map.remove(1, "1");

        Set<Integer> keySet = map.keySet();
        System.out.println("cac cap key-value cua map la: ");
        for (Integer key : keySet) {
            System.out.println(key + " : " + map.get(key));
        }
    }
}
