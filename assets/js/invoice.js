// Function to fetch invoice data from a JSON file
function fetchInvoiceData() {
  return fetch("assets/data/data.json")
    .then((response) => response.json())
    .catch((error) => {
      console.error("Error fetching JSON data:", error);
    });
}

// Function to fill invoice details into the HTML template
function fillInvoiceDetails() {
  const urlParams = new URLSearchParams(window.location.search);
  const orderID = urlParams.get("orderID");

  fetchInvoiceData().then((data) => {
    const invoiceData = data.invoiceData;
    const orderData = data.ordersData;
    console.log(invoiceData[0].order_details);
    // Fill invoice header details

    const matchingInvoice = invoiceData.find(
      (invoice) => invoice.order_number.trim() === orderID.trim()
    );
    // console.log(matchingInvoice);
    if (matchingInvoice) {
        const matchingOrder = data.ordersData.find(order => order.orderID === orderID);
        document.getElementById("invoiceId").textContent = matchingInvoice.invoice_id;
      document.getElementById("invoiceDate").textContent =
        matchingInvoice.invoice_date;
      document.getElementById("orderNumber").textContent =
        matchingInvoice.order_number;
      document.getElementById("orderDate").textContent =
        matchingOrder.orderDate;
      document.getElementById("shippingAddress").textContent =
        matchingOrder.shippingAddress;
      document.getElementById("billingAddress").textContent =
        matchingOrder.billingAddress;
      document.getElementById("customerName").textContent =
        matchingOrder.customerName;
      document.getElementById("customerEmail").textContent =
        matchingOrder.customerEmail;
      document.getElementById("customerPhone").textContent =
        matchingOrder.phone;

      // Fill invoice product details
      const tbody = document.querySelector("tbody");
      matchingInvoice.products.forEach((product) => {
        const row = document.createElement("tr");
        row.innerHTML = `
                <td>${product.product_name}</td>
                <td>${product.quantity}</td>
                <td>$${product.unit_price.toFixed(2)}</td>
                <td>${matchingInvoice.gst_type}</td>
                <td>$${(
                  product.quantity *
                  product.unit_price *
                  (product.gst_percentage / 100)
                ).toFixed(2)}</td>
            `;
        tbody.appendChild(row);
      });

      // Fill total invoice value
      document.getElementById(
        "totalAmount"
      ).textContent = `${matchingInvoice.total_invoice_value.toFixed(2)}`;
    }
    else{

    }
  });
}

// Call the function to fill invoice details when the page loads
window.addEventListener("load", fillInvoiceDetails);
