package com.example.quanlybanlinhkienmaytinh.models;

import java.util.Date;

import jakarta.persistence.*;
import jakarta.persistence.Id;

@Entity
@Table(name = "Product")
public class Product {

	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	private String Name;
	private String Brand;
	private String Category;
	private double Price;
	@Column(columnDefinition = "TEXT")
	private String ImageFileName;
	private Date Created;
	
	
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBrand() {
		return Brand;
	}
	public void setBrand(String brand) {
		Brand = brand;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
	public String getImageFileName() {
		return ImageFileName;
	}
	public void setImageFileName(String imageFileName) {
		ImageFileName = imageFileName;
	}
	public Date getCreated() {
		return Created;
	}
	public void setCreated(Date created) {
		Created = created;
	}
	
	
	
	
	
	
	
	
	
}
