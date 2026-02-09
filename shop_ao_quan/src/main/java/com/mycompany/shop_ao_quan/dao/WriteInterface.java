package com.mycompany.shop_ao_quan.dao;

public interface WriteInterface<T> {
    void save(T entity) throws Exception;
    T update(T entity) throws Exception;
    Boolean delete(int id) throws Exception;
} 
