package com.project.OnlineBillingSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.OnlineBillingSystem.model.Product;
import com.project.OnlineBillingSystem.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository pr;
	
	public List<Product> getAll(){
		return pr.findAll();
	}
	
	public Product getInfo(Long id) {
		Optional<Product> p=pr.findById(id);
		if(p.isPresent()) {
			Product pr=p.get();
			return pr;
		}
		return null;
	}
	
	public String post(Product p) {
		p.gstPrice();
		pr.save(p);
		return "Posted Successfully";
	}
	
	public String put(Long id, Product prod) {
		Optional<Product> p=pr.findById(id);
		if(p.isPresent()) {
			Product product=p.get();
			product.setProductName(prod.getProductName());
			product.setManufactureDate(prod.getManufactureDate());
			product.setGst(prod.getGst());
			prod.gstPrice();
			product.setPrice(prod.getPrice());
			pr.save(product);
			return "Updated Successfully";
		}
		return "Not Found";
	}
	
	public String delete(Long id) {
		if(pr.existsById(id)){
			pr.deleteById(id);
			return "Deleted Successfully";
		}
		return "Not Found";
	}
}
