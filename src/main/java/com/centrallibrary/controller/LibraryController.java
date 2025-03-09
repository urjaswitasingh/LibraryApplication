package com.centrallibrary.controller;

import ch.qos.logback.core.model.INamedModel;
import com.centrallibrary.model.Book;
import com.centrallibrary.model.BorrowHistory;

import com.centrallibrary.service.LibraryService;
import jakarta.servlet.http.HttpServletRequest;


import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class LibraryController {
    private static final Logger logger = LogManager.getLogger(LibraryController.class);

    @Autowired
   private LibraryService libraryService;
    @PostMapping("/borrow")
    public String borrow(@RequestParam Integer userId, @RequestBody List<Book> bookList) throws IOException {
        if(bookList.size()>3){
            logger.debug("borrow()-Book list: {},userId:{}",bookList,userId);
            return "More then 3 book not allowed";
        }
       logger.debug("borrow()-Book list: {},userId:{}",bookList,userId);
        return libraryService.borrow(userId, bookList);

    }

    @PostMapping("/return")
    public String returnBook(@RequestParam Integer userId , @RequestBody List<Book> bookList) throws IOException {
        logger.debug("returnBook()-Book list: {},userId:{}",bookList,userId);
        return libraryService.returnBook(userId, bookList);
    }

    @GetMapping("/borrowHistory/{userId}")
    public List<BorrowHistory> viewBorrowHistory(@PathVariable int  userId){
        logger.debug("viewBorrowHistory()-userId:{}",userId);
        return libraryService.borrowHistory(userId);

    }

}
