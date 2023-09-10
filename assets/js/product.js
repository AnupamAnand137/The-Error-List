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