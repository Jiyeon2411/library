package com.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.entity.RecBook;

public interface RecBookRepository extends JpaRepository<RecBook, Long>{

}
