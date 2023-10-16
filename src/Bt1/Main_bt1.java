package Bt1;

import java.util.HashMap;
import java.util.Map;

public class Main_bt1 {
    // Viết chương trình Java để đếm số lần xuất hiện của mỗi phần tử trong một mảng và lưu trữ kết quả trong HashMap.
    // -	B1: khai bảo mảng hoặc list phần từ với bất kỳ kdl nào
    // -	B2: Duyệt từng phần tử trong mảng và kiểm tra xem phần tử đó đã có trong HashMap hay chưa.
    // Nếu đã có thì tăng số lần xuất hiện lên 1, nếu chưa có thì thêm phần tử vào HashMap với số lần xuất hiện ban đầu là 1.
    // -	B3: Duyệt qua các phần tử trong HashMap và in ra số lần xuất hiện của từng phần tử.
    public static void main(String[] args) {
        int[] arr = {1, 23, 44, 5, 6, 75, 5, 6, 6, 7};
        Map<Integer, Integer> studentMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (studentMap.containsKey(arr[i])) {
                int count = studentMap.get(arr[i]);
                studentMap.put(arr[i], count + 1);
            } else {
                studentMap.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> studentEntry : studentMap.entrySet()) {
            System.out.printf("so %d lan xuat hien %d lan \n", studentEntry.getKey(), studentEntry.getValue());
        }
    }
}
