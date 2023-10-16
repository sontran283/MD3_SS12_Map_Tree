package Th1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main_th1 {
    // Luyện tập sử dụng HashMap, LinkedHashMap, TreeMap
    // Tạo HashMap, LinkedHashMap, TreeMap để lưu danh sách sinh viên theo độ tuổi.
    // Chương trình đầu tiên tạo ra một HashMap lưu tên sinh viên như là khoá (key)
    // và tuổi của mỗi sinh viên đó. Chương trình sau đó tạo ra một
    // TreeMap hiển thị toàn bộ key theo thứ tự giảm/tăng. Cuối cùng,
    // chương trình tạo ra một LinkedHashMap để lưu danh sách tương tự như HashMap và hiển thị dữ liệu.

    public static void main(String[] args) {
        // HashMap
        System.out.println("______ HashMap ______");
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("tuan anh", 12);
        hashMap.put("bang nguyen", 13);
        hashMap.put("duc anh", 14);
        System.out.println(hashMap);

        // linkedHashMap
        System.out.println("______ linkedHashMap  ______");
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        System.out.println("\nThe age for " + "Smith is " + linkedHashMap.get("Smith"));

        // TreeMap
        System.out.println("______ TreeMap ______");
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println(treeMap);
    }
}