package com.ecom.orderprocessingsystem.models;


import java.util.List;


public class InvoiceGeneration  {

	 private int invoiceID;
	    private String invoiceDate;
	    private Customer customer;
	    private List<Invoicedetails> invoicedetails;
	    private double totalGST;
	    private double totalInvoiceValue;
	    private String status;
		public int getInvoiceID() {
			return invoiceID;
		}
		public void setInvoiceID(int invoiceID) {
			this.invoiceID = invoiceID;
		}
		public String getInvoiceDate() {
			return invoiceDate;
		}
		public void setInvoiceDate(String invoiceDate) {
			this.invoiceDate = invoiceDate;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public List<Invoicedetails> getLineItems() {
			return invoicedetails;
		}
		public void setLineItems(List<Invoicedetails> invoicedetails) {
			this.invoicedetails = invoicedetails;
		}
		public double getTotalGST() {
			return totalGST;
		}
		public void setTotalGST(double totalGST) {
			this.totalGST = totalGST;
		}
		public double getTotalInvoiceValue() {
			return totalInvoiceValue;
		}
		public void setTotalInvoiceValue(double totalInvoiceValue) {
			this.totalInvoiceValue = totalInvoiceValue;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public InvoiceGeneration(int invoiceID, String invoiceDate, Customer customer, List<Invoicedetails> invoicedetails,
				double totalGST, double totalInvoiceValue, String status) {
			super();
			this.invoiceID = invoiceID;
			this.invoiceDate = invoiceDate;
			this.customer = customer;
			this.invoicedetails = invoicedetails;
			this.totalGST = totalGST;
			this.totalInvoiceValue = totalInvoiceValue;
			this.status = status;
		}
		public InvoiceGeneration() {
			super();
		}
		@Override
		public String toString() {
			return "InvoiceGeneration [invoiceID=" + invoiceID + ", invoiceDate=" + invoiceDate + ", customer="
					+ customer + ", invoicedetails=" + invoicedetails + ", totalGST=" + totalGST
					+ ", totalInvoiceValue=" + totalInvoiceValue + ", status=" + status + ", getInvoiceID()="
					+ getInvoiceID() + ", getInvoiceDate()=" + getInvoiceDate() + ", getCustomer()=" + getCustomer()
					+ ", getLineItems()=" + getLineItems() + ", getTotalGST()=" + getTotalGST()
					+ ", getTotalInvoiceValue()=" + getTotalInvoiceValue() + ", getStatus()=" + getStatus() + "]";
		}
		
	    
	    
}
