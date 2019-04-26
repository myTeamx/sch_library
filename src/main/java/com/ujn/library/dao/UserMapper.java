package com.ujn.library.dao;

public interface UserMapper {

    String getPasswordByName(String name) throws Exception;

    String getIdByName(String name) throws Exception;

}
