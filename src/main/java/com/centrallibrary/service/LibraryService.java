package com.centrallibrary.service;

import com.centrallibrary.controller.LibraryController;
import com.centrallibrary.model.Book;
import com.centrallibrary.model.BorrowHistory;
import com.centrallibrary.repository.BorrowHistoryRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Service
public class LibraryService {
    private static final Logger logger = LogManager.getLogger(LibraryController.class);
    @Autowired
    BorrowHistoryRepository borrowHistoryRepository;


    @Transactional
    public String borrow(Integer userId, List<Book> bookList) throws IOException {
        if (userId == null) {
            throw new IOException("userId is null");
        }
        List<BorrowHistory> borrowHistoryList = new ArrayList<>();
        for (Book book : bookList) {
            int bookId = book.getBookId();
            logger.debug("borrow()-bookId: {}", bookId);
            BorrowHistory borrowHistory = new BorrowHistory();
            borrowHistory.setBookId(bookId);
            borrowHistory.setUserId(userId);
            borrowHistory.setReturnDate(LocalDate.now().plusWeeks(2L));
            borrowHistoryList.add(borrowHistory);
        }

        try {
            borrowHistoryRepository.saveAll(borrowHistoryList);
        } catch (Exception ex) {
            logger.error("borrow book failed");
            throw ex;
        }
        logger.debug("borrow()-book saved");
        return "Borrowed successfully";
    }

    @Transactional
    public String returnBook(Integer userId, List<Book> bookList) throws IOException {
        if (userId == null) {
            throw new IOException("userId is null");
        }
        List<BorrowHistory> borrowHistoryList = new ArrayList<>();
        for (Book book : bookList) {
            int bookId = book.getBookId();
            logger.debug("returnBook()-bookId: {}", bookId);
            BorrowHistory borrowHistory = borrowHistoryRepository.findByUserIdAndBookId(userId, bookId);
            borrowHistory.setReturnStatus("RETURNED");
            borrowHistoryList.add(borrowHistory);

        }
        try {
            borrowHistoryRepository.saveAll(borrowHistoryList);
        } catch (Exception ex) {
            logger.error("book return failed");
            throw ex;
        }
        logger.debug("returnBook()-returned");
        return "return successfully";
    }

    public List<BorrowHistory> borrowHistory(int userId) {
        try {
            return borrowHistoryRepository.findAllByUserId(userId);
        }catch(Exception ex){
            logger.error("Error in finding history");
            throw ex;
        }
    }
}
