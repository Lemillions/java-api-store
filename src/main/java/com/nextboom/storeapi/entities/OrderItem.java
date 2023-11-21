package com.nextboom.storeapi.entities;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column
  @GeneratedValue()
  private UUID id;

  @Column
  private Integer quantity;

  @Column
  private Double subTotal;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  public OrderItem(Integer quantity, Double subTotal, Product product) {
    this.quantity = quantity;
    this.subTotal = subTotal;
    this.product = product;
  }

  public OrderItem() {}

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public Double getSubTotal() {
    return subTotal;
  }

  public void setSubTotal(Double subTotal) {
    this.subTotal = subTotal;
  }

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof OrderItem) {
      OrderItem other = (OrderItem) obj;
      if(other.getId() == this.getId()) {
        return true;
      }
    } 
    return false;
  }
}
