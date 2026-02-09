package com.mycompany.shop_ao_quan.dao;

public interface ReadInterface<T> {
    T getById(int id) throws Exception;
}
