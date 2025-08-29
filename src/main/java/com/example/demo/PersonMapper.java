package com.example.demo;

import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface PersonMapper {

    List<Person> findAll();

    int insertByName(@Param("name") String name);

    Long lastInsertId();
}