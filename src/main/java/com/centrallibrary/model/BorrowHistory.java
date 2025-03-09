package com.centrallibrary.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowHistory {
    @Id
    Integer issueId;
    Integer userId;
    Integer bookId;
    LocalDate returnDate;
    String returnStatus;

}
