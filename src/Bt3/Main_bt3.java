package Bt3;

import java.util.Map;
import java.util.TreeMap;

public class Main_bt3 {
    // Viết chương trình Java để tìm phần tử nhỏ nhất trong TreeMap.
    //-	B1: Khai báo và khởi tạo một đối tượng TreeMap.
    //-	B2: Đưa các phần tử vào TreeMap.
    //-	B3: Lấy giá trị của phần tử nhỏ nhất trong TreeMap bằng cách sử dụng phương thức firstEntry() của đối tượng TreeMap.
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 45, 6, 67, 7, 2};
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int j : arr) {
            treeMap.put(j, 0);
        }
//        for (int i = 0; i < arr.length; i++) {
//            int j = arr[i];
//            treeMap.put(j, 0);
//        }

        Map.Entry<Integer, Integer> min = treeMap.firstEntry();
        System.out.println("phan tu nho nhat la " + min.getKey());
    }
}
