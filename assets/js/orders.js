document.addEventListener("DOMContentLoaded", function () {
    if(!sessionStorage.getItem("is_Logged_In"))
    {
        window.location.href = "login.html";
    }

    const orderContainer = document.getElementById("orderContainer");

    // Define a Set to store unique order IDs
    const uniqueOrderIds = new Set();

    // Fetch orders from the JSON file
    fetch("assets/data/data.json")
        .then((response) => response.json())
        .then((data) => {
            const orders = data.ordersData;
            // Loop through the orders and create order cards
            orders.forEach((order) => {
                const orderId = order.orderID;

                // Check if the order ID is unique
                if (!uniqueOrderIds.has(orderId)) {
                    uniqueOrderIds.add(orderId);

                    const orderCard = document.createElement("div");
                    orderCard.classList.add("order-card");

                    const orderDetails = document.createElement("div");
                    orderDetails.classList.add("order-details");

                    // Build the order details
                    for (const key in order) {
                        const detail = document.createElement("p");
                        detail.innerHTML = `<strong>${key}:</strong> ${order[key]}`;
                        orderDetails.appendChild(detail);
                    }
                    const viewInvoice = document.createElement("button");
                    viewInvoice.textContent = "View Invoice";
                    viewInvoice.addEventListener("click", function () {
                        const invoiceUrl = `invoice.html?orderID=${orderId}`;
                        window.open(invoiceUrl, "_blank");
                    });


                    const status = document.createElement("div");
                    orderCard.classList.add("view-invoice-btn")
                    status.classList.add("status", `status-${order.status.toLowerCase()}`);
                    status.textContent = order.status;

                    orderCard.appendChild(orderDetails);
                    orderCard.appendChild(status);
                    orderCard.appendChild(viewInvoice);
                    orderContainer.appendChild(orderCard);
                } else {
                    console.warn(`Order with duplicate orderId (${orderId}) skipped.`);
                }
            });
        })
        .catch((error) => {
            console.error("Error fetching orders:", error);
        });
});
