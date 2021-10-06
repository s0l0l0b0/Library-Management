package com.sololobo.librarymanagement.domain;


import com.sololobo.librarymanagement.domain.enumeration.TypeOfBook;

import javax.persistence.*;

@Entity
public class Book {

  @Id
  @Column(name = "id", nullable = false)
  private long id;
  @Column(name = "isbn", nullable = false)
  private String isbn;
  @Column(name = "title", nullable = false)
  private String title;
  @Column(name = "writer")
  private String writer;

  @Enumerated(value = EnumType.STRING)
  @Column(name = "type")
  private TypeOfBook type;

  @Column(name = "available")
  private long available;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }


  public TypeOfBook getType() {
    return type;
  }

  public void setType(TypeOfBook type) {
    this.type = type;
  }

  public long getAvailable() {
    return available;
  }

  public void setAvailable(long available) {
    this.available = available;
  }

}
