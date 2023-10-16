package AtClass.LinkedHashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DemoLinkedHashMap {
    public static void main(String[] args) {
        // Map la tap hop cau truc du lieu,
        // đánh chỉ mục theo key nên tim ra nhanh hon. ko dam bao thu tu, hieu suat nhanh hon
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(4, 4);
        hashMap.put(2, 2);
        hashMap.put(3, 3);
        hashMap.put(1, 1);

        // dam bao thu tu, hieu suat cham hon
        Map<Integer, Integer> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(4, 4);
        linkedHashMap.put(2, 2);
        linkedHashMap.put(3, 3);
        linkedHashMap.put(1, 1);
    }
}
