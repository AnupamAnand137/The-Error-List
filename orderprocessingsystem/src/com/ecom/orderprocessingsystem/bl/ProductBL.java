package com.ecom.orderprocessingsystem.bl;

import java.util.HashSet;

import com.ecom.orderprocessingsystem.dao.ProductImportStatus;
import com.ecom.orderprocessingsystem.models.Product;

public interface ProductBL {
	 ProductImportStatus importProducts(HashSet<Product> products);
	
}
