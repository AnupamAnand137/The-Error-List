// Define a cart to store selected products
let cart = [];

async function fetchData() {
  if (!isCartInvoicePage()) {
    try {
      const response = await fetch("assets/data/data.json");
      const productsData = await response.json();

      // Load the cart from local storage if available
      const savedCart = JSON.parse(localStorage.getItem("cart"));
      if (savedCart) cart.push(...savedCart);

      // You can use the 'cart' data here
      displayCart(productsData);
    } catch (error) {
      console.error("Error fetching or parsing data:", error);
    }
  }
}

// Function to display the cart
function displayCart(productsData) {
  const cartContainer = document.querySelector(".cart-container");
  cartContainer.innerHTML = "";
  const cartItemsContainer = document.createElement("div");
  cartItemsContainer.classList.add("cart-items-container");

  cart.forEach((cartItem) => {
    const product = productsData.products.find(
      (item) => item.product_id === cartItem.product_id
    );

    if (product) {
      const cartItemElement = document.createElement("div");
      cartItemElement.classList.add("cart-item");

      const productName = document.createElement("p");
      productName.textContent = product.name;

      const productImg = document.createElement("img");
      productImg.src = product.image_src;
      productImg.width = 200;
      productImg.height = 200;

      const productPrice = document.createElement("p");
      productPrice.textContent = product.price;

      const quantityDisplay = document.createElement("p");
      quantityDisplay.textContent = `Quantity: ${cartItem.quantity}`;

      const removeButton = document.createElement("button");
      removeButton.textContent = "Remove";
      removeButton.addEventListener("click", () =>
        removeFromCart(cartItem, productsData)
      );

      cartItemElement.appendChild(productName);
      cartItemElement.appendChild(productImg);
      cartItemElement.appendChild(productPrice);
      cartItemElement.appendChild(quantityDisplay);
      cartItemElement.appendChild(removeButton);
      cartItemsContainer.appendChild(cartItemElement);
    }
  });
  cartContainer.appendChild(cartItemsContainer);
  if (cart.length === 0) {
    const message = document.createElement("div");
    message.classList.add("empty-message");
    message.textContent = "Your Cart is Empty";
    cartContainer.append(message);
  } else {
    // Display the "Buy Now" button only when the cart is not empty
    const buyNowDiv = document.createElement("div");
    buyNowDiv.classList.add("buy-now");
    const buyNowButton = document.createElement("button");
    buyNowButton.textContent = "Buy Now";
    buyNowButton.id = "buyNowButton";
    buyNowButton.addEventListener("click", () => {
      handleBuyNow(productsData);
    });
    buyNowDiv.appendChild(buyNowButton);
    cartContainer.appendChild(buyNowDiv);
  }
}

// Function to add a product to the cart
function addToCart(product, productsData) {
  const existingCartItem = cart.find(
    (item) => item.product_id === product.product_id
  );
  if (existingCartItem) {
    // If the product already exists in the cart, increase its quantity
    existingCartItem.quantity += 1;
  } else {
    // If it doesn't exist, add it to the cart with a quantity of 1
    cart.push({ ...product, quantity: 1 });
  }

  localStorage.setItem("cart", JSON.stringify(cart));
  displayCart(productsData);
}

// Function to remove a product from the cart
function removeFromCart(cartItem, productsData) {
  const productIndex = cart.findIndex(
    (item) => item.product_id === cartItem.product_id
  );

  if (productIndex !== -1) {
    if (cart[productIndex].quantity > 1) {
      // If the product quantity is greater than 1, decrease the quantity
      cart[productIndex].quantity -= 1;
    } else {
      // If the product quantity is 1 or less, remove it from the cart entirely
      cart.splice(productIndex, 1);
    }

    localStorage.setItem("cart", JSON.stringify(cart));
    displayCart(productsData);
  }
}

function createOrder(cart) {
  const orderID = generateOrderID();
  const orderDate = new Date().toISOString().split("T")[0];
  const customerName = "Krishna Rathi"; // You can replace this with actual customer data
  const customerEmail = "krishnarathi@gmail.com"; // Replace with actual email
  const billingAddress = "HSBC Software Development, Pune"; // Replace with actual address
  const shippingAddress = "HSBC Software Development, Pune"; // Replace with actual address
  const phone = "7487999183"; // Replace with actual phone number
  const totalOrderValue = calculateTotalOrderValue(cart);
  const shippingCost = "₹10.00"; // Replace with actual shipping cost
  const shippingAgency = "Shipping Express"; // Replace with actual shipping agency
  const status = "Approved"; // You can set the initial status

  return {
    orderID,
    orderDate,
    customerName,
    customerEmail,
    billingAddress,
    shippingAddress,
    products: cart.map((item) => item.name), // Assuming you have a 'name' property in your cart items
    phone,
    totalOrderValue,
    shippingCost,
    shippingAgency,
    status,
  };
}

function createInvoice(order) {
  const invoiceID = generateInvoiceID();
  const invoiceDate = new Date().toISOString().split("T")[0];
  const orderNumber = order.orderID;
  const products = cart.map((item) => ({
    product_id: item.product_id,
    product_name: item.name, // Assuming you have a 'name' property in your cart items
    quantity: item.quantity,
    unit_price: parseFloat(item.price.replace("₹ ", "")), // Parse the price to a float
    gst_percentage: 18.0, // Replace with actual GST percentage
  }));
  const gst_type = "Inter-State"; // Replace with actual GST type
  const total_gst_amount = calculateTotalGSTAmount(products); // Implement this function
  const total_invoice_value =
    parseFloat(order.totalOrderValue.replace("₹", "")) +
    parseFloat(order.shippingCost.replace("₹", "")) +
    total_gst_amount;
  console.log(total_invoice_value);
  return {
    invoice_id: invoiceID,
    invoice_date: invoiceDate,
    order_number: orderNumber,
    products,
    gst_type,
    total_gst_amount,
    total_invoice_value,
  };
}

function generateOrderID() {
  // Implement a function to generate a unique order ID, e.g., using a timestamp or a random string.
  return "ORD" + Math.floor(Math.random() * 100000);
}

function generateInvoiceID() {
  // Implement a function to generate a unique invoice ID, e.g., using a timestamp or a random string.
  return "INV" + Math.floor(Math.random() * 100000);
}

function calculateTotalOrderValue(cart) {
  // Implement a function to calculate the total order value based on cart items.
  // You need to iterate through the cart and sum up the prices.
  // Make sure to handle the currency symbol and convert to a numeric value.
  let total = 0;
  for (const item of cart) {
    total += parseFloat(item.price.replace("₹ ", "")) * item.quantity;
  }
  return "₹" + total.toFixed(2); // Format the total value as a currency string
}

function calculateTotalGSTAmount(products) {
  // Implement a function to calculate the total GST amount based on products.
  // You need to iterate through the products and calculate GST for each item.
  let totalGST = 0;
  for (const product of products) {
    totalGST +=
      ((product.unit_price * product.gst_percentage) / 100) * product.quantity;
  }
  return totalGST;
}

// Function to handle the "Buy Now" button click
function handleBuyNow(productsData) {
  // Create an order and add it to the ordersData array
  const order = createOrder(cart);
  // productsData.ordersData.push(order);

  // Create an invoice and add it to the invoiceData array
  const invoice = createInvoice(order);
  // productsData.invoiceData.push(invoice);

  // Clear the cart and update localStorage
  cart = [];
  localStorage.setItem("cart", JSON.stringify(cart));
  console.log(order);
  // Display the updated cart and show a success message
  // displayCart(productsData);
  alert("Order placed successfully!");
  localStorage.setItem("cartInvoiceOrder", JSON.stringify(order));
  localStorage.setItem("cartInvoice", JSON.stringify(invoice));
  window.location.href = "cartInvoice.html";
}

function isCartInvoicePage() {
  return window.location.pathname.endsWith("cartInvoice.html");
}

window.addEventListener("load", () => {
  fetchData(); // Call fetchData on load

});
