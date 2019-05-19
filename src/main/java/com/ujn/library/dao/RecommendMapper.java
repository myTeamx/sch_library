package com.ujn.library.dao;

import com.ujn.library.entity.Book;

import java.util.List;

public interface RecommendMapper {

    List<Book> getRecommendBooks(String user_id) throws Exception;

}
