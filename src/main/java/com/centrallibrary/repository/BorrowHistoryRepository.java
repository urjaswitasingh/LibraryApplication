package com.centrallibrary.repository;

import com.centrallibrary.model.BorrowHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowHistoryRepository extends MongoRepository<BorrowHistory, Integer> {
    List<BorrowHistory> findAllByUserId(int userId);
    BorrowHistory findByUserIdAndBookId(int user_id, int book_id);


}
