package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * ユーザー情報 Entity
 */
@Entity
@Data
@Table(name = "user")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  /**
   * ID
   */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  /**
   * 名前
   */
  @Column(name = "name")
  private String name;

  /**
   * 住所
   */
  @Column(name = "address")
  private String address;

  /**
   * 電話番号
   */
  @Column(name = "phone")
  private String phone;

  /**
   * 更新日時
   */
  @Column(name = "update_date")
  private LocalDateTime updateDate;

  /**
   * 登録日時
   */
  @Column(name = "create_date")
  private LocalDateTime createDate;

  /**
   * 削除日時
   */
  @Column(name = "delete_date")
  private LocalDateTime deleteDate;
}
