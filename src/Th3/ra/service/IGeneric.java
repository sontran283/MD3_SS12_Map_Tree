package Th3.ra.service;

import java.util.List;

public interface IGeneric<T> {
    List<T> findAll();

    void save(T t);

    void update(T t);


    void deleteById(int id);

    T findById(int id);

    void updateData();
}
