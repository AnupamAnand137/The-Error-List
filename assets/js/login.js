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
    return btoa(`${user.username}:${user.password}`);
}

document.getElementById('employee-login').addEventListener('click', () => {
    document.getElementById('employee-login-form').style.display = 'block';
    document.getElementById('customer-login-form').style.display = 'none';
});

document.getElementById('customer-login').addEventListener('click', () => {
    document.getElementById('employee-login-form').style.display = 'none';
    document.getElementById('customer-login-form').style.display = 'block';
});

document.getElementById('employee-submit').addEventListener('click', () => {
    const username = document.getElementById('employee-username').value;
    const password = document.getElementById('employee-password').value;

    const user = employees.find((e) => e.username === username && e.password === password);

    if (user) {
        const token = generateToken(user);
        alert(`Employee login successful. Token: ${token}`);
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
        alert(`Customer login successful. Token: ${token}`);
    } else {
        alert('Invalid credentials');
    }
});
