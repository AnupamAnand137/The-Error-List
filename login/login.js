document.addEventListener("DOMContentLoaded", function () {
    const employeeButton = document.querySelector(".login[data-target='employee']");
    const userButton = document.querySelector(".login[data-target='user']");
    const slider = document.querySelector(".slider");
    const formSection = document.querySelector(".form-section");

    employeeButton.addEventListener("click", () => {
        slider.style.left = "100px"; // Adjust this value based on your design
        formSection.style.left = "0";
    });

    userButton.addEventListener("click", () => {
        slider.style.left = "250px"; // Adjust this value based on your design
        formSection.style.left = "-500px"; // Adjust this value based on your design
    });
});
