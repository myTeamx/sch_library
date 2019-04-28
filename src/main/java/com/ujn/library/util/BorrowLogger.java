package com.ujn.library.util;

import com.ujn.library.dao.BookMapper;
import com.ujn.library.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BorrowLogger {

    /**
     * 记录借阅/归还信息
     * @param bookMapper
     * @param username
     * @param bookId
     * @param isBorrow 0->借阅, 1->归还
     * @throws Exception
     */
    public static void borrowLog(BookMapper bookMapper, String username, String userId, String bookId, int isBorrow) throws Exception {
        Logger logger = LogManager.getLogger();
        Book book = bookMapper.getByBookId(bookId);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        logger.info("{borrowInfo: " +
                "[userId="+userId+"]," +
                "[username="+username+"]," +
                "[bookId="+bookId+"]," +
                "[bookName="+book.getBookName()+"]," +
                "[author="+book.getAuthor()+"]," +
                "[press="+book.getPress()+"]," +
                "[category="+book.getCategory()+"]," +
                "[isBorrow="+isBorrow+"]," +
                "[time="+time+"]}");
    }

}
