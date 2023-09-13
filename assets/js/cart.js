// // Define a cart to store selected products
// let cart = []
// async function fetchData() {
//     try {
//         const response = await fetch("assets/data/data.json");
//         const productsData = await response.json();
//         // Load the cart from local storage if available
//         const savedCart = JSON.parse(localStorage.getItem('cart'));
//         if(savedCart) cart.push(...savedCart);
//         displayCart();
//         // You can use the 'cart' data here
//     } catch (error) {
//         console.error('Error fetching or parsing data:', error);
//     }
// }
// // Function to display the cart
// function displayCart() {
//     // console.log(cart);
//     const cartContainer = document.querySelector('.cart-container');
//     cartContainer.innerHTML = '';
//     if(cart.length === 0)
//     {
//         const message = document.createElement('div');
//         message.classList.add('empty-message');
//         message.textContent = "Your Cart is Empty"
//         cartContainer.append(message);
//     }
//     cart.forEach((product) => {
//         const cartItem = document.createElement('div');
//         cartItem.classList.add('cart-item');

//         const productName = document.createElement('p');
//         productName.textContent = product.name;

//         const productImg = document.createElement('img');
//         productImg.src = product.image_src;
//         productImg.width = 200;
//         productImg.height = 200;

//         const productPrice = document.createElement('p');
//         productPrice.textContent = product.price;

//         const removeButton = document.createElement('button');
//         removeButton.textContent = 'Remove';
//         removeButton.addEventListener('click', () => removeFromCart(product));

//         cartItem.appendChild(productName);
//         cartItem.appendChild(productImg);
//         cartItem.appendChild(productPrice);
//         cartItem.appendChild(removeButton);
//         cartContainer.appendChild(cartItem);
//     });
// }

// // Function to remove a product from the cart
// function removeFromCart(product) {
//     const productIndex = cart.findIndex((item) => item.product_id === product.product_id);
//     if (productIndex !== -1) {
//         cart.splice(productIndex, 1);
//         localStorage.setItem('cart', JSON.stringify(cart));
//         displayCart();
//     }
// }

// window.addEventListener('load', fetchData);

// Define a cart to store selected products
let cart = []

async function fetchData() {
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

// Function to display the cart
function displayCart(productsData) {
  const cartContainer = document.querySelector(".cart-container");
  cartContainer.innerHTML = "";
  if (cart.length === 0) {
    const message = document.createElement("div");
    message.classList.add("empty-message");
    message.textContent = "Your Cart is Empty";
    cartContainer.append(message);
  }
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
      cartContainer.appendChild(cartItemElement);
    }
  });
}

// Function to add a product to the cart
function addToCart(product, productsData) {
  const existingCartItem = cart.find(
    (item) => item.product_id === product.product_id
  );
  console.log(product);
  if (existingCartItem) {
    // If the product already exists in the cart, increase its quantity
    existingCartItem.quantity += 1;
  } else {
    // If it doesn't exist, add it to the cart with a quantity of 1
    console.log(product);
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

window.addEventListener("load", () => {
  fetchData(); // Call fetchData on load
});
