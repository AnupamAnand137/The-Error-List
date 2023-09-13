// Function to fetch invoice data from a JSON file
function fetchInvoiceData() {
    return fetch('assets/data/data.json')
        .then(response => response.json())
        .catch(error => {
            console.error('Error fetching JSON data:', error);
        });
}

// Function to fill invoice details into the HTML template
function fillInvoiceDetails() {
    fetchInvoiceData().then(invoiceData => {
        const invoices = data.invoiceData;

        // Fill invoice header details
        document.getElementById("invoiceId").textContent = invoiceData.invoice_id;
        document.getElementById("invoiceDate").textContent = invoiceData.invoice_date;
        document.getElementById("orderNumber").textContent = invoiceData.order_details.order_number;
        document.getElementById("orderDate").textContent = invoiceData.order_details.order_date;
        document.getElementById("shippingAddress").textContent = invoiceData.order_details.shipping_address;
        document.getElementById("billingAddress").textContent = invoiceData.order_details.billing_address;
        document.getElementById("customerName").textContent = invoiceData.customer_details.customer_name;
        document.getElementById("customerEmail").textContent = invoiceData.customer_details.customer_email;
        document.getElementById("customerPhone").textContent = invoiceData.customer_details.customer_phone;
        
        // Fill invoice product details
        const tbody = document.querySelector("tbody");
        invoiceData.products.forEach(product => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${product.product_name}</td>
                <td>${product.quantity}</td>
                <td>$${product.unit_price.toFixed(2)}</td>
                <td>${invoiceData.gst_type}</td>
                <td>$${(product.quantity * product.unit_price * (product.gst_percentage / 100)).toFixed(2)}</td>
            `;
            tbody.appendChild(row);
        });
        
        // Fill total invoice value
        document.getElementById("totalAmount").textContent = `$${invoiceData.total_invoice_value.toFixed(2)}`;
    });
}

// Call the function to fill invoice details when the page loads
window.addEventListener("load", fillInvoiceDetails);









// document.addEventListener("DOMContentLoaded", function () {
//     // Fetch invoice data from a JSON file (replace with your data source)
//     fetch("path/to/invoice-data.json")
//         .then((response) => response.json())
//         .then((invoiceData) => {
//             const invoiceTemplate = document.getElementById("invoiceTemplate");

//             // Replace placeholders with actual data
//             invoiceTemplate.innerHTML = invoiceTemplate.innerHTML
//                 .replace("{{invoiceNumber}}", invoiceData.invoiceNumber)
//                 .replace("{{invoiceDate}}", invoiceData.invoiceDate)
//                 .replace("{{customerName}}", invoiceData.customerName);

//             // Populate invoice items
//             const tbody = invoiceTemplate.querySelector("tbody");
//             invoiceData.items.forEach((item) => {
//                 const row = document.createElement("tr");
//                 row.innerHTML = `
//                     <td>${item.description}</td>
//                     <td>${item.quantity}</td>
//                     <td>$${item.unitPrice.toFixed(2)}</td>
//                     <td>$${(item.quantity * item.unitPrice).toFixed(2)}</td>
//                 `;
//                 tbody.appendChild(row);
//             });

//             // Calculate and display the total amount
//             const totalAmountElement = invoiceTemplate.querySelector("#totalAmount");
//             const totalAmount = invoiceData.items.reduce((total, item) => total + item.quantity * item.unitPrice, 0);
//             totalAmountElement.textContent = totalAmount.toFixed(2);
//         })
//         .catch((error) => {
//             console.error("Error loading invoice data:", error);
//         });
// });
