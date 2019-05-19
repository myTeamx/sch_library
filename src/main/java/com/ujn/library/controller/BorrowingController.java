package com.ujn.library.controller;

import com.ujn.library.entity.Book;
import com.ujn.library.entity.BorrowBook;
import com.ujn.library.service.BorrowingRecordService;
import com.ujn.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/borrow")
public class BorrowingController {

    @Resource
    private BorrowingRecordService borrowingRecordService;

    @Resource
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/getBookIdsByUserName.action")
    public List<String> getBookIdsByUserName(String username) throws Exception {
        return borrowingRecordService.getBookIdsByUserName(username);
    }

    @ResponseBody
    @PostMapping(value = "/getBooksByUserName.action")
    public List<Book> getBooksByUserName(String username, String curr, String limit) throws Exception {
        List<Book> books = borrowingRecordService.getBooksByUserName(username, curr, limit);
        return books;
    }

    @ResponseBody
    @PostMapping(value = "/borrowBook.action")
    public void borrowBook(String username, String bookId) throws Exception {
        borrowingRecordService.borrowBook(username, bookId);
    }

    @ResponseBody
    @PostMapping(value = "/backBook.action")
    public void backBook(String username, String bookId) throws Exception {
        borrowingRecordService.backBook(username, bookId);
    }

    /**
     * 借书次数
     * @return
     * @throws Exception
     */
    @ResponseBody
    @PostMapping(value = "/borrowBookTimes.action")
    public int borrowBookTimes(String username) throws Exception {
        return borrowingRecordService.borrowBookTimes(username);
    }

    @ResponseBody
    @PostMapping(value = "/onBorrowBookCount.action")
    public int onBorrowBookCount(String username) throws Exception {
        return borrowingRecordService.onBorrowBookCount(username);
    }

    @ResponseBody
    @PostMapping(value = "/getBorrowBooksTop3.action")
    public List<Book> getBorrowBooksTop3(String curr, String limit, String username) throws Exception {
        return borrowingRecordService.getBorrowBooks(curr, limit, username);
    }

    @ResponseBody
    @PostMapping(value = "/getBorrHistory.action")
    public List<BorrowBook> getBorrHistory(String curr, String limit, String username) throws Exception {
        String user_id = userService.getUserIdByName(username);
        return borrowingRecordService.getBorrHistory(curr, limit, user_id);
    }

    @ResponseBody
    @PostMapping(value = "/countAll.action")
    public int countAll(String username) throws Exception {
        String user_id = userService.getUserIdByName(username);
        return borrowingRecordService.countAll(user_id);
    }

}
