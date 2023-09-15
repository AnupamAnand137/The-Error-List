package com.ecom.orderprocessingsystem.models;

public class Invoicedetails {

	 private Product Products;
	    private int quantity = 1; // Default quantity is 1

	   

	    // Getters and setters
	    

	    public double getTotalPrice() {
	        return Products.getPrice() * quantity;
	    }

	    public Invoicedetails(Product products) {
			super();
			Products = products;
			
		}

		public Invoicedetails() {
			super();
		}

		public Invoicedetails(Product Products, int quantity) {
			super();
			this.Products = Products;
			this.quantity = quantity;
		}

		public Product getProducts() {
			return Products;
		}

		public void setProducts(Product Products) {
			this.Products = Products;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public double getTotalGST() {
	        return (Products.getPrice() * quantity * Products.getGst()) / 100;
	    }
}
