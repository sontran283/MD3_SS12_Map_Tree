package Bt4;

import java.util.HashMap;
import java.util.Map;

public class Main_bt4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 6, 6, 5, 5, 5, 7};
        Map<Integer, Integer> arrMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            if (arrMap.containsKey(arr[i])) {
                continue;
            }
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    count++;
                }
            }
            arrMap.put(arr[i], count);
        }

        int maxCount = 0;
        int max = 0;
        for (int key : arrMap.keySet()) {
            int count = arrMap.get(key);
            System.out.println("Phan tu " + key + " xuat hien " + count + " lan");
            if (count > maxCount) {
                maxCount = count;
                max = key;
            }
        }
        System.out.println("So xuat hien nhieu nhat la: " + max);
    }
}
