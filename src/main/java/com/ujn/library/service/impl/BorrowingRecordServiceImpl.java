package com.ujn.library.service.impl;

import com.ujn.library.dao.BookMapper;
import com.ujn.library.dao.BorrowingRecordMapper;
import com.ujn.library.dao.UserMapper;
import com.ujn.library.entity.Book;
import com.ujn.library.entity.BorrowBook;
import com.ujn.library.entity.BorrowingRecord;
import com.ujn.library.service.BorrowingRecordService;
import com.ujn.library.util.BorrowLogger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service("borrowingRecordService")
public class BorrowingRecordServiceImpl implements BorrowingRecordService {

    @Resource
    private BorrowingRecordMapper borrowingRecordMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private BookMapper bookMapper;

    @Override
    public List<String> getBookIdsByUserName(String username) throws Exception {
        String user_id = userMapper.getIdByName(username);
        return borrowingRecordMapper.getBookIdsByUserId(user_id);
    }

    @Override
    public List<Book> getBooksByUserName(String username, String curr, String limit) throws Exception {
        String user_id = userMapper.getIdByName(username);
        int index = Integer.valueOf(curr);
        int pageSize = Integer.valueOf(limit);
        int start = (index - 1) * pageSize;
        return borrowingRecordMapper.getBooksByUserId(user_id, start, pageSize);
    }

    @Override
    public void borrowBook(String username, String bookId) throws Exception {
        String userId = userMapper.getIdByName(username);
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setId(UUID.randomUUID().toString());
        borrowingRecord.setUserId(userId);
        borrowingRecord.setBookId(bookId);
        borrowingRecord.setState(new Byte("0"));
        borrowingRecordMapper.borrowBook(borrowingRecord);
        BorrowLogger.borrowLog(bookMapper, username, userId, bookId, 0);
    }

    @Override
    public void backBook(String username, String bookId) throws Exception {
        String userId = userMapper.getIdByName(username);
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setUserId(userId);
        borrowingRecord.setBookId(bookId);
        borrowingRecordMapper.backBook(borrowingRecord);
        BorrowLogger.borrowLog(bookMapper, username, userId, bookId, 1);
    }

    @Override
    public int borrowBookTimes(String username) throws Exception {
        String user_id = userMapper.getIdByName(username);
        return borrowingRecordMapper.count(user_id);
    }

    @Override
    public int onBorrowBookCount(String username) throws Exception {
        String user_id = userMapper.getIdByName(username);
        return borrowingRecordMapper.onCount(user_id);
    }

    @Override
    public List<Book> getBorrowBooks(String curr, String limit, String username) throws Exception {
        String user_id = userMapper.getIdByName(username);
        int index = Integer.valueOf(curr);
        int pageSize = Integer.valueOf(limit);
        int start = (index - 1) * pageSize;
        List<String> borrowBookIds = borrowingRecordMapper.getBorrowBookIds(start, pageSize, user_id);
        List<Book> books = new ArrayList<>();
        for (String bookId : borrowBookIds) {
            Book book = bookMapper.getByBookId(bookId);
            books.add(book);
        }
        return books;
    }

    @Override
    public List<BorrowBook> getBorrHistory(String curr, String limit, String user_id) throws Exception {
        int index = Integer.valueOf(curr);
        int pageSize = Integer.valueOf(limit);
        int start = (index - 1) * pageSize;
        List<BorrowBook> borrHistoryBooks = borrowingRecordMapper.getBorrHistory(start, pageSize, user_id);
        return borrHistoryBooks;
    }

    @Override
    public int countAll(String user_id) throws Exception {
        return borrowingRecordMapper.countAll(user_id);
    }
}

