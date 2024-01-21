package com.example.dao;

import java.util.List;

import com.example.entiry.Type;

public interface TypeDao {

    void updateType(Type type);
    
    void deleteType(Integer typeId);
    
    Type getTypeById(Integer typeId);
    
    List<Type> getAllTypes();
}
