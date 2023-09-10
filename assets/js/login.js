// Function to show login form based on selected tab
function showLoginForm(userType) {
    document.getElementById('employee-login-form').style.display = userType === 'employee' ? 'block' : 'none';
    document.getElementById('customer-login-form').style.display = userType === 'customer' ? 'block' : 'none';
}

// Event listeners for tab buttons
document.getElementById('employee-tab').addEventListener('click', () => {
    showLoginForm('employee');
});

document.getElementById('customer-tab').addEventListener('click', () => {
    showLoginForm('customer');
});

// Dummy user data (replace with actual data)
const employees = [
    { username: 'employee1', password: 'password1' },
    { username: 'employee2', password: 'password2' },
];

const customers = [
    { username: 'customer1', password: 'password1' },
    { username: 'customer2', password: 'password2' },
];

// Function to generate a secure token (replace with a secure token generation method)
function generateToken(user) {
    const currentTime = new Date();
    const expirationTime = new Date(currentTime.getTime() + 10 * 60 * 1000); // 10 minutes from now

    const tokenData = {
        username: user.username,
        expiration: expirationTime.getTime(),
    };

    const token = btoa(JSON.stringify(tokenData));
    return token;
}


// Event listeners for login buttons
document.getElementById('employee-submit').addEventListener('click', () => {
    const username = document.getElementById('employee-username').value;
    const password = document.getElementById('employee-password').value;

    const user = employees.find((e) => e.username === username && e.password === password);

    if (user) {
        const token = generateToken(user);
        localStorage.setItem("token", token);
    } else {
        alert('Invalid credentials');
    }
});

document.getElementById('customer-submit').addEventListener('click', () => {
    const username = document.getElementById('customer-username').value;
    const password = document.getElementById('customer-password').value;

    const user = customers.find((e) => e.username === username && e.password === password);

    if (user) {
        const token = generateToken(user);
        localStorage.setItem("token", token);
    } else {
        alert('Invalid credentials');
    }
});

// Initially, show the employee login form
showLoginForm('employee');
