package com.itenorio.products_stock_v1.modules.products.schema;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
public class Supplier {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long supplier_id;

  @Column(length = 50, nullable = false)
  private String supplier_name;

  @Column(length = 300)
  private String supplier_address;

  @Column(length = 20)
  private String supplier_phone;

  @Column(length = 50)
  private String supplier_email;

  @Column(nullable = false, updatable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp supplier_create_at;

  @Column(nullable = false)
  @Temporal(TemporalType.TIMESTAMP)
  private Timestamp supplier_update_at;

  public Supplier() {
  }

  public Supplier(String supplierName, String supplierAddress, String supplierPhone, String supplierEmail) {
    this.supplier_name = supplierName;
    this.supplier_address = supplierAddress;
    this.supplier_phone = supplierPhone;
    this.supplier_email = supplierEmail;
  }
}