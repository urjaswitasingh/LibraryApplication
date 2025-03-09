package com.centrallibrary;

import com.centrallibrary.model.Book;
import com.centrallibrary.model.BorrowHistory;
import com.centrallibrary.repository.BorrowHistoryRepository;
import com.centrallibrary.service.LibraryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryServiceTest {

    @Autowired
    private LibraryService libraryService;

    @Autowired
    private BorrowHistoryRepository borrowHistoryRepository;

    @BeforeEach
    void setUp() {
        borrowHistoryRepository.deleteAll();
    }


    @Test
    void testBorrowNullUserId() {
        assertThrows(IOException.class, () -> libraryService.borrow(null, List.of(new Book(1))));
    }

    @Test
    void testBorrowEmptyBookList() throws IOException {
        String result = libraryService.borrow(1, Collections.emptyList());
        assertEquals("Borrowed successfully", result);
    }

    @Test
    void testReturnBookNullUserId() {
        assertThrows(IOException.class, () -> libraryService.returnBook(null, List.of(new Book(1))));
    }

    @Test
    void testReturnBookEmptyBookList() throws IOException {
        String result = libraryService.returnBook(1, Collections.emptyList());
        assertEquals("return successfully", result);
    }

    @Test
    void testBorrowHistory() {
        Integer userId = 1;
        List<BorrowHistory> historyList = libraryService.borrowHistory(userId);
        assertNotNull(historyList);
        assertTrue(historyList.isEmpty(), "For new use borrow history be empty");
    }
}

