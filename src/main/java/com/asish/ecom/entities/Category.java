package com.asish.ecom.entities;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	private boolean status;

	@OneToMany
	private List<Product> product;

	@CreationTimestamp
	private Timestamp createdAt;

	@UpdateTimestamp
	private Timestamp updatedAt;

	@Transient
	private String image = "newproduct.jpg";

	@Transient
	private String topProductName = "new category";

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTopProductName() {
		return topProductName;
	}

	public void setTopProductName(String topProductName) {
		this.topProductName = topProductName;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", status=" + status + ", product=" + product + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
