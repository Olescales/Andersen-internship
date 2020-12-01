package com.andersenlab.katokoleg.servlets.mapper;

public interface Mapper<T,E> {

    E fromDTOToEntity (T t);

    T fromEntityToDTO (E e);
}
