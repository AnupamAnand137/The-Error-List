package com.ecom.orderprocessingsystem.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import com.ecom.orderprocessingsystem.models.Product;

public class ProductDaoImpl implements ProductDao{

	HashSet<Product> productList;
	List<Long> productIds;
	
	
	
	public ProductDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.productList=new HashSet<>();
		this.productIds=new ArrayList<>();
	}



	@Override
	public ProductImportStatus importProducts(HashSet<Product> products, int productsAdded, int productsNotAdded) {
		// TODO Auto-generated method stub
		
		for(Product product : products) {
			if(!productIds.contains(product.getId()))
				{
				productList.add(product);
				productsAdded++;
				}
			else
				productsNotAdded++;
		}
		
		if(productsAdded==0)
		return ProductImportStatus.Failed;
		
		else if(productsNotAdded==0)
			return ProductImportStatus.Completed;
		else
			return ProductImportStatus.Partial;
	}

}
