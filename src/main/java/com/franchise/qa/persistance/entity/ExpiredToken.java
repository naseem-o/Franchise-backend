package com.franchise.qa.persistance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.franchise.qa.persistance.utility.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "expired_token")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExpiredToken extends BaseEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String username;
  @Column(name = "token",  columnDefinition = "text")
  private String token;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


}
