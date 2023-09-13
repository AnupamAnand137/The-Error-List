import { checkAuthentication } from "./checkAuthenticated.js";
document.addEventListener("DOMContentLoaded", function() {

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

    // Call the updateNavigation function on page load
    updateNavigation();

    // Handle clicking the Cart link
    const cartLink = document.getElementById("cart-link");
    cartLink.addEventListener("click", function(event) {
        event.preventDefault();
        if (checkAuthentication()) {
            console.log("cart authentication")
            window.location.href = "cart.html";
        } else {
            // User is not authenticated, redirect to the Login page
            window.location.href = "login.html"; // Replace with your login page URL
        }
    });
});
