// Sample login functionality for the login page

// This function will be called when the login button is clicked
function login() {
    // Get the username and password input values
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // You should implement logic here to validate the credentials
    // and generate and store tokens securely

    // For this example, let's assume a simple check for a valid username and password
    if (username === 'employee' && password === 'password') {
        alert('Login successful as an employee.');
        // Redirect to the employee's page
        window.location.href = 'manage_orders.html';
    } else if (username === 'customer' && password === 'password') {
        alert('Login successful as a customer.');
        // Redirect to the customer's page
        window.location.href = 'order_management.html';
    } else {
        alert('Invalid username or password. Please try again.');
    }
}

// Attach the login function to the login button's click event
document.getElementById('login-button').addEventListener('click', login);
