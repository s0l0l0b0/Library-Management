package com.sololobo.librarymanagement.domain;

import com.sololobo.librarymanagement.domain.enumeration.Role;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", nullable = false)
  private long id;

  @Column(name="email", nullable = false)
  private String email;

  @Column(name="name", nullable = false)
  private String name;

  @Enumerated(value = EnumType.STRING)
  @Column(name="role", nullable = false)
  private Role role;

  @Column(name="password", nullable = false)
  private String password;

  @Column(name = "is_active", nullable = false)
  private Boolean isActive;

  @OneToMany(mappedBy = "userId")
  private Set<BorrowLog> borrowLogs;

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean active) {
    isActive = active;
  }

  public long getId() {
    return id;
  }
  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  public Role getRole() {
    return role;
  }
  public void setRole(Role role) {
    this.role = role;
  }


  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public Set<BorrowLog> getBorrowLogs() {
    return borrowLogs;
  }

  public void setBorrowLogs(Set<BorrowLog> borrowLogs) {
    this.borrowLogs = borrowLogs;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
