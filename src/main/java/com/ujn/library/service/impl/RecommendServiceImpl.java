package com.ujn.library.service.impl;

import com.ujn.library.dao.RecommendMapper;
import com.ujn.library.entity.Book;
import com.ujn.library.service.RecommendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("recommendService")
public class RecommendServiceImpl implements RecommendService {

    @Resource
    private RecommendMapper recommendMapper;

    @Override
    public List<Book> getRecommendBooks(String user_id) throws Exception {
        return recommendMapper.getRecommendBooks(user_id);
    }

}
