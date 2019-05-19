package com.ujn.library.service;

import com.ujn.library.entity.Book;

import java.util.List;

public interface RecommendService {

    List<Book> getRecommendBooks(String user_id) throws Exception;

}
