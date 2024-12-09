package com.example.quanlybanlinhkienmaytinh.models;

import java.time.LocalDate;
import java.util.Date;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

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
	@Column(columnDefinition = "TEXT", name = "Image_file_name")
	private String ImageFileName;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate Created;
	
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
	public LocalDate getCreated() {
		return Created;
	}
	public void setCreated(LocalDate created) {
		Created = created;
	}
	
}
