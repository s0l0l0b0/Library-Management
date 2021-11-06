package com.sololobo.librarymanagement.model;

import com.sololobo.librarymanagement.domain.BorrowLog;

public class BorrowLogFineDTO {
    private BorrowLog borrowLog;
    private int fine;

    public BorrowLogFineDTO(BorrowLog borrowLog, int fine) {
        this.borrowLog = borrowLog;
        this.fine = fine;
    }

    public BorrowLog getBorrowLog() {
        return borrowLog;
    }

    public void setBorrowLog(BorrowLog borrowLog) {
        this.borrowLog = borrowLog;
    }

    public int getFine() {
        return fine;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }
}