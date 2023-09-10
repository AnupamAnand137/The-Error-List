  // Function to fetch and display products
  async function fetchAndDisplayProducts() {
    try {
      const response = await fetch('assets/data/data.json');
      const productsData = await response.json();
      const products = productsData.products;
    //   console.log(products);
      const productsContainer = document.querySelector('.products-container');

      // Loop through the products and create product boxes
      products.forEach((product, index) => {
        const productBox = document.createElement('div');
        productBox.classList.add('product-box');

        const image = document.createElement('div');
        image.classList.add('image');
        const img = document.createElement('img');
        img.src = product.image_src;
        img.alt = `Product ${index + 1}`;
        image.appendChild(img);

        const info = document.createElement('div');
        info.classList.add('info');
        const name = document.createElement('p');
        name.classList.add('name');
        name.textContent = product.name;
        const price = document.createElement('p');
        price.classList.add('price');
        price.textContent = product.price;
        const category = document.createElement('p');
        category.classList.add('category');
        category.textContent = product.category;
        const productId = document.createElement('p');
        productId.classList.add('product-id');
        productId.textContent = `Product ID: ${product.product_id}`;
        
        info.appendChild(name);
        info.appendChild(price);
        info.appendChild(category);
        info.appendChild(productId);

        productBox.appendChild(image);
        productBox.appendChild(info);

        productsContainer.appendChild(productBox);
      });
    } catch (error) {
      console.error('Error fetching or displaying products:', error);
    }
  }

  // Call the function to fetch and display products when the page loads
  window.addEventListener('load', fetchAndDisplayProducts);









// document.addEventListener("DOMContentLoaded", function () {
//     // Fetch the JSON data
//     fetch("assets/data/data.json")
//         .then((response) => response.json())
//         .then((data) => {
//             const products = data.products;

//             // Create a container to hold the product cards
//             const productContainer = document.getElementById("productContainer");          
//             // Loop through the products and create dynamic product cards
//             products.forEach((product) => {
//                 const productCard = document.createElement("div");
//                 // It was checking that if the description length is more than 100 then element should be scroll else hidden
//                 // checkDescriptionLength(product, productCard);  
//                 productCard.classList.add("product-card");
//                 productCard.innerHTML = `
//                     <div class="product-id">${product.id}
//                     </div>
//                     <div class="product-details">
//                         <h2>${product.name}</h2>
//                         <p class="product-price" id="product-price">${product.price}</p>
//                         <p class="product-level" id="product-level">${product.category}</p>
//                         <div class="nextSteps">
//                             <button class="add-to-cart">Add to Cart</button>
//                             <a href="${product.buyNowLink}" class="buy-now" target="_blank">Buy Now</a>
//                         </div>
//                     </div>
//                 `;


//                 // Append the product card to the container
//                 productContainer.appendChild(productCard);
//             });
//         })
//         .catch((error) => {
//             console.error("Error fetching data:", error);
//         });
// });