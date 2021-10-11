package com.sololobo.librarymanagement.repository;

import com.sololobo.librarymanagement.domain.BorrowLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowLogRepository extends JpaRepository<BorrowLog, Long> {

    @Query("SELECT count(b) FROM BorrowLog b WHERE b.userId = :userId")
    Integer getBorrowCountByUserId(Long userId);

    @Query("SELECT b FROM BorrowLog b WHERE b.userId = :userId")
    List<BorrowLog> getBorrowLogBy(Long userId);
}
