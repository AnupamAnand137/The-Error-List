// Function to fetch and display products
import { checkAuthentication } from "./checkAuthenticated.js";

async function fetchAndDisplayProducts() {
  try {
    const response = await fetch("assets/data/data.json");
    const productsData = await response.json();
    const products = productsData.products;
    const cart = productsData.cart;
    //   console.log(products);
    const productsContainer = document.querySelector(".products-container");
    function addToCart(product) {
      cart.push(product);
      // You can also save the cart in local storage to persist it across page reloads
      localStorage.setItem("cart", JSON.stringify(cart));
    }

    // Function to update the navigation links based on authentication status
    function updateNavigation() {
      const dynamicNav = document.getElementById("dynamicNav");

      if (checkAuthentication()) {
        // User is authenticated, add Orders and Logout links
        dynamicNav.innerHTML = `
                  <li><a href="orders.html" id="orders-link">Orders</a></li>
                  <li><a href="javascript:void(0);" id="logout" onclick="logout()">Logout</a></li>
          `;

        // Remove the Login link
        const loginLink = document.getElementById("login-link");
        loginLink.style.display = "none";
      } else {
        // User is not authenticated, remove dynamic links
        dynamicNav.innerHTML = "";
      }
    }

      localStorage.setItem('cart', JSON.stringify(cart));
    }
    });

    // Loop through the products and create product boxes
    products.forEach((product, index) => {
      const productBox = document.createElement("div");
      productBox.classList.add("product-box");

      const image = document.createElement("div");
      image.classList.add("image");
      const img = document.createElement("img");
      img.src = product.image_src;
      img.alt = `Product ${index + 1}`;
      image.appendChild(img);

      const info = document.createElement("div");
      info.classList.add("info");
      const name = document.createElement("p");
      name.classList.add("name");
      name.textContent = product.name;
      const price = document.createElement("p");
      price.classList.add("price");
      price.textContent = product.price;
      const category = document.createElement("p");
      category.classList.add("category");
      category.textContent = product.category;
      const productId = document.createElement("p");
      productId.classList.add("product-id");
      productId.textContent = `Product ID: ${product.product_id}`;
      const addToCartButton = document.createElement("button");
      addToCartButton.textContent = "Add to Cart";
      addToCartButton.addEventListener("click", () => {
        addToCart(product);
        alert("Added to Cart Successfully");
      });
      info.appendChild(name);
      info.appendChild(price);
      info.appendChild(category);
      info.appendChild(productId);
      info.appendChild(addToCartButton);
      productBox.appendChild(image);
      productBox.appendChild(info);
      productsContainer.appendChild(productBox);
    });
  } catch (error) {
    console.error("Error fetching or displaying products:", error);
  }
}

// Call the function to fetch and display products when the page loads
window.addEventListener("load", fetchAndDisplayProducts);
