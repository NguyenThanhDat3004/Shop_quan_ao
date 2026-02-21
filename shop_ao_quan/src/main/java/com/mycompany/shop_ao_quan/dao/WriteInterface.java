package com.mycompany.shop_ao_quan.dao;

public interface WriteInterface<T> {
    boolean save(T entity) throws Exception;
    T update(T entity) throws Exception;
    Boolean delete(int id) throws Exception;
} 
