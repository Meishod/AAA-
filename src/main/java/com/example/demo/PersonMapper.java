package com.example.demo;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonMapper {

    @Select("SELECT id, name FROM person ORDER BY id")
    List<PersonController.Person> findAll();

    @Insert("INSERT INTO person(name) VALUES(#{name})")
    int insertByName(@Param("name") String name);

    @Select("SELECT last_insert_rowid()")
    Long lastInsertId();
}