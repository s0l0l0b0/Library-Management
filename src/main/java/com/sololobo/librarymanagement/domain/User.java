package com.sololobo.librarymanagement.domain;

import com.sololobo.librarymanagement.domain.enumeration.Role;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="id", nullable = false)
  private long id;

  @Column(name="name", nullable = false)
  private String name;

  @Enumerated(value = EnumType.STRING)
  @Column(name="role", nullable = false)
  private Role role;

  @Column(name="password", nullable = false)
  private String password;



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

}
