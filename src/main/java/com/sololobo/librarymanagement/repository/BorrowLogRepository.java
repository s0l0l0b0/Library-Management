package com.sololobo.librarymanagement.repository;

import com.sololobo.librarymanagement.domain.BorrowLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowLogRepository extends JpaRepository<BorrowLog, Long> {
}
