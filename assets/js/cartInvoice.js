// Parse the JSON object from your localStorage or any other source
const orderData = JSON.parse(localStorage.getItem("cartInvoiceOrder"));
const invoiceData = JSON.parse(localStorage.getItem("cartInvoice"));
// Function to populate the invoice details
function populateInvoiceDetails(invoiceData) {
  // Populate the invoice header information
  document.getElementById("invoiceId").textContent = invoiceData.invoice_id;
  document.getElementById("invoiceDate").textContent = invoiceData.invoice_date;
  document.getElementById("orderNumber").textContent = orderData.orderID;
  document.getElementById("orderDate").textContent = orderData.orderDate;
  document.getElementById("shippingAddress").textContent = orderData.shippingAddress;
  document.getElementById("billingAddress").textContent = orderData.billingAddress;

  // Populate the customer information
  document.getElementById("customerName").textContent = orderData.customerName;
  document.getElementById("customerEmail").textContent = orderData.customerEmail;
  document.getElementById("customerPhone").textContent = orderData.phone;

  // Populate the invoice items
  const tableBody = document.querySelector("table tbody");
  tableBody.innerHTML = ""; // Clear existing rows

  // Iterate through the products in the invoiceData and add rows to the table
  invoiceData.products.forEach((product) => {
    const row = document.createElement("tr");
    row.innerHTML = `
      <td>${product.product_name}</td>
      <td>${product.quantity}</td> <!-- You can modify this to match your data -->
      <td>${product.unit_price}</td>
      <td>${invoiceData.gst_type}</td> <!-- You can modify this to match your data -->
      <td>${invoiceData.total_gst_amount}</td>

    `;
    tableBody.appendChild(row);
  });

  // Populate the total amount
  const totalAmountSpan = document.getElementById("totalAmount");
  totalAmountSpan.textContent = invoiceData.total_invoice_value;
  localStorage.removeItem("cartInvoiceOrder");
}

// Call the function to populate the invoice details
populateInvoiceDetails(invoiceData);
