// JavaScript code to fetch and display orders and invoices
import { getLastLogin } from './loginTimeFunc.js';
const ordersData = [
    {
        id: 1,
        customerName: "Customer A",
        orderDate: "2023-09-08",
        orderValue: "$500",
        customerCity: "City A",
        status: "Approved"
    },
    {
        id: 2,
        customerName: "Customer B",
        orderDate: "2023-09-09",
        orderValue: "$800",
        customerCity: "City B",
        status: "Completed"
    },
    // Add more order data as needed
];
document.getElementById("last-login").textContent = getLastLogin();

document.getElementById("view-orders").addEventListener("click", function () {
    const ordersList = document.getElementById("orders");
    ordersList.innerHTML = "";
    ordersData.forEach((order) => {
        const listItem = document.createElement("li");
        listItem.className = "order-item";
        listItem.innerHTML = `
            <h3>Order ID: ${order.id}</h3>
            <p>Customer Name: ${order.customerName}</p>
            <p>Order Date: ${order.orderDate}</p>
            <p>Order Value: ${order.orderValue}</p>
            <p>Customer City: ${order.customerCity}</p>
            <p>Status: ${order.status}</p>
        `;
        ordersList.appendChild(listItem);
    });
    const invoice = document.getElementById("invoice");
    invoice.style.display = "block";
    invoice.innerHTML = `
        <h2>Invoice</h2>
        <p>Invoice details go here.</p>
    `;
});
