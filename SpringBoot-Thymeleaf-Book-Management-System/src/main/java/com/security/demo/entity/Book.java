package com.security.demo.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "library_book")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NonNull
    private String bookname;
@NonNull
    private String title;
@NonNull
    private String description;
@NonNull
    private String price;

    // Existing field
@NonNull
    private Integer bookCount;

    // New fields

    private Integer availableBookCount;

@NonNull
    private String author;
@NonNull
    private String category;

    @OneToMany(mappedBy = "book")
    private List<Borrow> borrows;
}