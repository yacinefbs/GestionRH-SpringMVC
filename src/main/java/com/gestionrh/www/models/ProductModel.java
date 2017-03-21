package com.gestionrh.www.models;

import java.util.ArrayList;

import com.gestionrh.www.entities.Product;

import antlr.collections.List;

public class ProductModel {
	
	
	
	public java.util.List<Product> findAll(){
		java.util.List<Product> listProduct = new ArrayList<Product>();
		
		listProduct.add(new Product("p1", "Name 1 ", 5, 1000));
		listProduct.add(new Product("p2", "Name 2 ", 5, 2000));
		listProduct.add(new Product("p3", "Name 3 ", 5, 3000));
		listProduct.add(new Product("p4", "Name 4 ", 5, 4000));
		listProduct.add(new Product("p5", "Name 5 ", 5, 5000));
		return listProduct;
	}
}
