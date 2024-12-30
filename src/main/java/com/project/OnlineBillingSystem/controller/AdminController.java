package com.project.OnlineBillingSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.OnlineBillingSystem.model.Product;
import com.project.OnlineBillingSystem.service.ProductService;

@RestController
@RequestMapping("admin")
public class AdminController {
	
	@Autowired 
	private ProductService ps;
	
	@GetMapping()
	public List<Product> getAll() {
		return ps.getAll();
	}
	
	@GetMapping("{id}")
	public Product getInfo(@PathVariable Long id) {
		return ps.getInfo(id);
	}
	
	@PostMapping()
	public String post(@RequestBody Product p) {
		return ps.post(p);
	}
	
	@PutMapping("{id}")
	public String put(@PathVariable Long id, @RequestBody Product prod) {
		return ps.put(id,prod);
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id) {
		return ps.delete(id);
	}
	
}
