package com.sololobo.librarymanagement.domain;

import javax.persistence.*;

@Entity
@Table(name="book")
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", nullable = false)
  private long id;

  @Column(name="title")
  private String title;

  @Column(name="writer")
  private String writer;

  @Column(name="type")
  private String type;

  @Column(name="total_amount", nullable = false)
  private int totalAmount;

  @Column(name="available_amount", nullable = false)
  private int availableAmount;


  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
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


  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }


  public int getTotalAmount() {
    return totalAmount;
  }
  public void setTotalAmount(int total_amount) {
    this.totalAmount = total_amount;
  }


  public int getAvailable() {
    return availableAmount;
  }
  public void setAvailable(int available) {
    this.availableAmount = available;
  }

}
