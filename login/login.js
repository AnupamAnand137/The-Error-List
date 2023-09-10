document.addEventListener("DOMContentLoaded", function () {
    const employeeButton = document.querySelector(".login[data-target='employee']");
    const userButton = document.querySelector(".login[data-target='user']");
    const slider = document.querySelector(".slider");
    const formSection = document.querySelector(".form-section");

    employeeButton.addEventListener("click", () => {
        slider.style.left = "20%"; // Adjust this value based on your design
        formSection.style.left = "0";
    });

    userButton.addEventListener("click", () => {
        slider.style.left = "50%"; // Adjust this value based on your design
        formSection.style.left = "-100%"; // Adjust this value based on your design
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

    // Function to generate a secure token
    function generateToken(user) {
        const currentTime = new Date();
        const randomness = new Date(currentTime.getTime() + 10 * 60 * 1000);

        const tokenData = {
            username: user.username,
            password: user.password,
            randomness: randomness
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
            sessionStorage.setItem("token", token);
            window.location.href = employee-home.html;
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
            sessionStorage.setItem("token", token);
            window.location.href = customer-home.html;
        } else {
            alert('Invalid credentials');
        }
    });

});
