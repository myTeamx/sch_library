package com.ujn.library.service;

import com.ujn.library.entity.Book;

import java.util.List;

public interface BorrowingRecordService {

    List<String> getBookIdsByUserName(String user_id) throws Exception;

    void borrowBook(String username, String bookId) throws Exception;

    int borrowBookTimes(String username) throws Exception;

    int onBorrowBookCount(String username) throws Exception;

    /**
     *
     * @param curr 当前页码
     * @param limit 每页展示的数据量
     * @return
     * @throws Exception
     */
    List<Book> getBorrowBooks(String curr, String limit, String username) throws Exception;

}
