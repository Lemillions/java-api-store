package com.nextboom.storeapi.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @Column(unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Column()
  private String name;

  @Column()
  private String description;

  @Column
  private Double price;

  @ManyToMany
  @JoinTable(name = "product_category", joinColumns = { @JoinColumn(name = "product_id") }, inverseJoinColumns = {
      @JoinColumn(name = "category_id") })
  private List<Category> categories = new ArrayList<Category>();

  public Product(String name, String description, Double price, List<Category> categories) {
    this.name = name;
    this.description = description;
    this.price = price;
    this.categories = categories;
  }

  public Product() {
  }

  public static long getSerialversionuid() {
    return serialVersionUID;
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

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public List<Category> getCategories() {
    return categories;
  }

  public void setCategories(List<Category> categories) {
    this.categories = categories;
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
    if (obj != null && obj instanceof Product) {
      Product other = (Product) obj;
      if (other.getId() == this.getId()) {
        return true;
      }
    }
    return false;
  }
}
