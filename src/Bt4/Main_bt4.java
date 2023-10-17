package Bt4;

import java.util.HashMap;
import java.util.Map;

public class Main_bt4 {
    // Viết chương trình Java để đếm số lần xuất hiện của mỗi phần tử trong một mảng và lưu trữ kết quả trong HashMap.
    // -	B1: khai bảo mảng hoặc list phần từ với bất kỳ kdl nào
    // -	B2: Duyệt từng phần tử trong mảng và kiểm tra xem phần tử đó đã có trong HashMap hay chưa.
    // Nếu đã có thì tăng số lần xuất hiện lên 1, nếu chưa có thì thêm phần tử vào HashMap với số lần xuất hiện ban đầu là 1.
    // -	B3: Duyệt qua các phần tử trong HashMap và in ra số lần xuất hiện của từng phần tử.

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
