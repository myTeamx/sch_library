package com.ujn.library.service;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    boolean login(String name, String password, HttpServletRequest request) throws Exception;

}
