package com.ujn.library.controller;

import com.ujn.library.entity.Book;
import com.ujn.library.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Resource
    private BookService bookService;

    @ResponseBody
    @RequestMapping(value = "/show.action", method = RequestMethod.POST)
    public List<Book> getAllByPage(String curr, String limit, String bookCategory) throws Exception {
        return bookService.getAllByPage(curr, limit, bookCategory);
    }

    @ResponseBody
    @RequestMapping(value = "/count.action", method = RequestMethod.POST)
    public int count() throws Exception {
        return bookService.count();
    }

    @ResponseBody
    @PostMapping(value = "/countByCat.action")
    public int countByCat(String bookCategory) throws Exception {
        return bookService.countByCat(bookCategory);
    }

}
