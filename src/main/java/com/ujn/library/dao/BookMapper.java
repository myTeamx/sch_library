package com.ujn.library.dao;

import com.ujn.library.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    List<Book> getAllByPage(@Param("start") int start, @Param("pageSize") int pageSize) throws Exception;

    int count() throws Exception;

    List<Book> getByBookName(@Param("bookName") String bookName) throws Exception;

    Book getByBookId(String bookId) throws Exception;

}