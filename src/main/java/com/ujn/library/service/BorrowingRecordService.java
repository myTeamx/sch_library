package com.ujn.library.service;

import com.ujn.library.entity.Book;
import com.ujn.library.entity.BorrowBook;

import java.util.List;

public interface BorrowingRecordService {

    List<String> getBookIdsByUserName(String username) throws Exception;

    List<Book> getBooksByUserName(String username, String curr, String limit) throws Exception;

    void borrowBook(String username, String bookId) throws Exception;

    void backBook(String username, String bookId) throws Exception;

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

    List<BorrowBook> getBorrHistory(String curr, String limit, String user_id) throws Exception;

    int countAll(String user_id) throws Exception;

}
