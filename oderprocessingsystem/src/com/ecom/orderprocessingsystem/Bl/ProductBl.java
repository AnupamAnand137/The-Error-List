package com.ecom.orderprocessingsystem.Bl;

import java.util.HashSet;

import com.ecom.orderprocessingsystem.dao.ProductImportStatus;
import com.ecom.orderprocessingsystem.models.Product;

public interface ProductBl {
	 ProductImportStatus importProducts(HashSet<Product> products);
	
}