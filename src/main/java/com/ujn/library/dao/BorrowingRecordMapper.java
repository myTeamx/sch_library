package com.ujn.library.dao;

import com.ujn.library.entity.BorrowingRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BorrowingRecordMapper {

    List<String> getBookIdsByUserId(String user_id) throws Exception;

    void borrowBook(BorrowingRecord borrowingRecord) throws Exception;

    int count(String user_id) throws Exception;

    int onCount(String user_id) throws Exception;

    /**
     * 按分页获取不区分是否在借的书籍ID
     * @param start
     * @param pageSize
     * @return
     * @throws Exception
     */
    List<String> getBorrowBookIds(@Param("start") int start, @Param("pageSize") int pageSize, @Param("user_id") String user_id) throws Exception;

}
