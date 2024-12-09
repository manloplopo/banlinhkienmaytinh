package com.example.quanlybanlinhkienmaytinh.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.quanlybanlinhkienmaytinh.models.Product;
import com.example.quanlybanlinhkienmaytinh.services.ProductsRepository;

@Controller
@RequestMapping("/Product")

public class ProductsController {
@Autowired 
private ProductsRepository repo;

@GetMapping({"","/"})
public String showProductList(Model model) {
	List<Product> Product = repo.findAll();
	model.addAttribute("Product",Product);
	return "Product/index.html";
}
@GetMapping("/create")
public String showCreateForm(Model model) {
    model.addAttribute("Product", new Product());
    return "Product/create.html";
}

@PostMapping("/create")
public String createProduct(@Validated @ModelAttribute Product Product) {
	repo.save(Product);
    return "redirect:/Product";
}
@GetMapping("/edit/{Id}")
public String editProduct(@PathVariable int Id, Model model) {
    Product Product = repo.findById(Id).orElse(null); // Use the repository to find the product
    if (Product == null) {
        // Log the error
        System.out.println("Product not found for id: " + Id);
        // Optionally, redirect to an error page or show a message
        return "redirect:/error"; // Make sure you have an error handling mechanism
    }
    model.addAttribute("Product", Product);
    return "Product/edit.html";
}

@PostMapping("/edit/{Id}")
public String updateProduct(@PathVariable int Id, @Validated @ModelAttribute Product Product,
         @RequestParam("ImageFile") MultipartFile ImageFile, 
         RedirectAttributes redirectAttributes) {
    // Your update logic here
    return "redirect:/Product"; // Redirect after update
}

@GetMapping ("/delete")
public String deleteProduct(@RequestParam int Id) {
	try {
		Product Product = repo.findById(Id).get();
		
		Path ImagePath = Paths.get("public/image" + Product.getImageFileName());
		
		try {
			Files.delete(ImagePath);
	}
		catch (Exception ex) {
			System.out.println("Exception:" + ex.getMessage());
		}
	repo.delete(Product);
	}
	catch (Exception ex) {
		System.out.println("Exception:" + ex.getMessage());
	}
return "redirect:/Product";
}

    @GetMapping("/edit")
    public String editProduct(Model model) {
        // Your logic here
        return "Product/edit.html"; // This should correspond to a view name
    }
}