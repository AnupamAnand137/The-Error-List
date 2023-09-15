package com.ecom.orderprocessingsystem.dao;

import java.util.HashSet;

import com.ecom.orderprocessingsystem.models.Product;

public interface ProductDao {
 ProductImportStatus importProducts(HashSet<Product> products, int productsAdded, int productsNotAdded);
}
