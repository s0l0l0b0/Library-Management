package com.sololobo.librarymanagement.domain;


import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "borrow_log", uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "book_id"}))
public class BorrowLog {

  @Id
  @Column(name="id", nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;


  @ManyToOne
  @JoinColumn(name = "user_id", insertable = false, updatable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "book_id", insertable = false, updatable = false)
  private Book book;



  @Column(name="user_id", nullable = false)
  private Long userId;

  @Column(name="book_id", nullable = false)
  private long bookId;

  @Column(name="date", nullable = false)
  private LocalDateTime date;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }


  public long getBookId() {
    return bookId;
  }

  public void setBookId(long bookId) {
    this.bookId = bookId;
  }


  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {this.user = user;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

}
