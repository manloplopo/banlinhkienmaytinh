package com.example.quanlybanlinhkienmaytinh.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.quanlybanlinhkienmaytinh.models.Product;
import com.example.quanlybanlinhkienmaytinh.services.ProductsRepository;

@Controller
@RequestMapping("/Product")

public class ProductsController {
@Autowired 
private ProductsRepository repo;

@GetMapping({"","/"})
public String showProductList(Model model) {
	List<Product> Product = repo.findAll(Sort.by(Sort.Direction.DESC,"Id"));
	model.addAttribute("Product",Product);
	return "Product/index.html";
}



}
