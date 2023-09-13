// Define a cart to store selected products
let cart = []
async function fetchData() {
    try {
        const response = await fetch("assets/data/data.json");
        const productsData = await response.json();
        // Load the cart from local storage if available
        const savedCart = JSON.parse(localStorage.getItem('cart'));
        cart.push(...savedCart); 
        displayCart();       
        // You can use the 'cart' data here
    } catch (error) {
        console.error('Error fetching or parsing data:', error);
    }
}
// Function to display the cart
function displayCart() {
    console.log(cart);
    const cartContainer = document.querySelector('.cart-container');
    cartContainer.innerHTML = '';

    cart.forEach((product) => {
        const cartItem = document.createElement('div');
        cartItem.classList.add('cart-item');

        const productName = document.createElement('p');
        productName.textContent = product.name;

        const productImg = document.createElement('img');
        productImg.src = product.image_src;
        productImg.width = 200;
        productImg.height = 200;

        const productPrice = document.createElement('p');
        productPrice.textContent = product.price;

        const removeButton = document.createElement('button');
        removeButton.textContent = 'Remove';
        removeButton.addEventListener('click', () => removeFromCart(product));

        cartItem.appendChild(productName);
        cartItem.appendChild(productImg);
        cartItem.appendChild(productPrice);
        cartItem.appendChild(removeButton);
        cartContainer.appendChild(cartItem);
    });
}

// Function to remove a product from the cart
function removeFromCart(product) {
    const productIndex = cart.findIndex((item) => item.product_id === product.product_id);
    if (productIndex !== -1) {
        cart.splice(productIndex, 1);
        localStorage.setItem('cart', JSON.stringify(cart));
        displayCart();
    }
}

window.addEventListener('load', fetchData);

