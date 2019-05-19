package com.ujn.library.controller;

import com.ujn.library.entity.Book;
import com.ujn.library.service.RecommendService;
import com.ujn.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/recommend")
public class RecommendController {
    
    @Resource
    private RecommendService recommendService;
    
    @Resource
    private UserService userService;

    @ResponseBody
    @PostMapping(value = "/getRecommendBooks.action")
    public List<Book> getRecommendBooks(String username) throws Exception {
        String user_id = userService.getUserIdByName(username);
        return  recommendService.getRecommendBooks(user_id);
    }


}
