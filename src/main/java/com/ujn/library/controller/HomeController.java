package com.ujn.library.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = "/")
    public String index() throws Exception {
        return "/login";
    }

    @RequestMapping(value = "/book_show.action", method = RequestMethod.GET)
    public String bookShow() throws Exception {
        return "/book_show";
    }

    @RequestMapping(value = "/my_borrows.action")
    public String myBorrows() throws Exception {
        return "/my_borrows";
    }

    @RequestMapping(value = "/bor_history.action")
    public String borHistory() throws Exception {
        return "/bor_history";
    }

}
