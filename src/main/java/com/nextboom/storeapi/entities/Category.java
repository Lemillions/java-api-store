package com.nextboom.storeapi.entities;

import java.util.UUID;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column
  private String name;

  @ManyToMany(mappedBy = "categories")
  private List<Product> products = new ArrayList<Product>();

  public Category(String name) {
    setName(name);
  }

  public Category() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
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
    if (obj != null && obj instanceof Category) {
      Category other = (Category) obj;
      if(other.getId() == this.getId()) {
        return true;
      }
    } 
    return false;
  }

}
