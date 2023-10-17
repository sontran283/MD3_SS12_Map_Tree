package Exam_Advance_1.ra.bussiness;

import Exam_Advance_1.ra.bussinessImp.Catalog;

import java.util.List;

public interface IShop {
    float RATE = 1.3f;

    public void inputData(List<Catalog> catalogs);

    public void displayData();
}
