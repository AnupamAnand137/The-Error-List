document.addEventListener("DOMContentLoaded", function () {
    // Fetch the JSON data
    fetch("assets/data/data.json")
        .then((response) => response.json())
        .then((data) => {
            const products = data.products;

            // Create a container to hold the product cards
            const productContainer = document.getElementById("productContainer");          
            // Loop through the products and create dynamic product cards
            products.forEach((product) => {
                const productCard = document.createElement("div");
                // It was checking that if the description length is more than 100 then element should be scroll else hidden
                // checkDescriptionLength(product, productCard);  
                productCard.classList.add("product-card");
                productCard.innerHTML = `
                    <div class="product-id">${product.id}
                    </div>
                    <div class="product-details">
                        <h2>${product.name}</h2>
                        <p class="product-price" id="product-price">${product.price}</p>
                        <p class="product-level" id="product-level">${product.category}</p>
                        <div class="nextSteps">
                            <button class="add-to-cart">Add to Cart</button>
                            <a href="${product.buyNowLink}" class="buy-now" target="_blank">Buy Now</a>
                        </div>
                    </div>
                `;


                // Append the product card to the container
                productContainer.appendChild(productCard);
            });
        })
        .catch((error) => {
            console.error("Error fetching data:", error);
        });
});