package com.security.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.security.demo.entity.Borrow;

public interface BorrowRepository extends JpaRepository<Borrow, Long> {

}
