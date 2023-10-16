package Bt2;

import java.util.TreeMap;

public class Main_bt2 {
    // Viết chương trình Java để tìm phần tử lớn thứ hai trong một mảng các số nguyên sử dụng TreeMap.
    //- B1: Khai báo và khởi tạo một mảng các số nguyên.
    //-	B2: Khai báo một đối tượng TreeMap để lưu trữ các phần tử trong mảng. Với TreeMap, các phần tử sẽ được sắp xếp theo thứ tự tăng dần của khóa.
    //-	B3: Sử dụng một vòng lặp để đưa các phần tử của mảng vào TreeMap. Đối với mỗi phần tử trong mảng, thêm nó vào TreeMap với giá trị là 0.
    //-	B4: Lấy giá trị của phần tử lớn nhất trong TreeMap.
    //-	B5: Xóa phần tử lớn nhất khỏi TreeMap.
    //-	B6: Lúc này phần tử lớn nhất trong treemap sẽ là phần tử lớn thứ 2 trong mảng ban đầu, ta dung phương thức lastKey() để lấy nó ra.

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 45, 6, 67, 7, 2};
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        for (int j : arr) {
//            treeMap.put(j, 0);
//        }
        for (int i = 0; i < arr.length; i++) {
            int j = arr[i];
            treeMap.put(j, 0);
        }
        treeMap.remove(treeMap.lastKey());
        System.out.println("phan tu lon thu 2 la " + treeMap.lastKey());
    }
}
