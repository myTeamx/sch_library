package com.ujn.library.service.impl;

import com.ujn.library.dao.BookMapper;
import com.ujn.library.entity.Book;
import com.ujn.library.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    private BookMapper bookMapper;

    @Override
    public List<Book> getAllByPage(String curr, String limit, String bookCategory) throws Exception {
        int index = Integer.valueOf(curr);
        int pageSize = Integer.valueOf(limit);
        int start = (index - 1) * pageSize;
        return bookMapper.getAllByPage(start, pageSize, bookCategory);
    }

    @Override
    public int count() throws Exception {
        return bookMapper.count();
    }

    @Override
    public int countByCat(String bookCategory) throws Exception {
        return bookMapper.countByCat(bookCategory);
    }

    @Override
    public List<Book> getByBookName(String bookName) throws Exception {
        return null;
    }

    @Override
    public Book getByBookId(String bookId) throws Exception {
        return bookMapper.getByBookId(bookId);
    }
}
