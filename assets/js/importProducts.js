document.getElementById("importForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form submission

    var fileInput = document.getElementById("fileInput");
    var file = fileInput.files[0];

    if (file) {
        var reader = new FileReader();

        reader.onload = function(e) {
            var contents = e.target.result;
            var products = parseFileContents(contents);

            if (products.length > 0) {
                displayProducts(products);
                displayMessage("Products imported successfully", "success");
            } else {
                displayMessage("No products found in the JSON file", "error");
            }
        };

        reader.readAsText(file);
    } else {
        displayMessage("Please select a file", "error");
    }
});

function parseFileContents(contents) {
    var products = [];

    try {
        var jsonData = JSON.parse(contents);

        if (Array.isArray(jsonData)) {
            products = jsonData;
        } else {
            throw new Error("Invalid JSON data");
        }
    } catch (error) {
        console.error("Error parsing JSON data:", error);
    }

    return products;
}

function displayProducts(products) {
    var tableBody = document.querySelector("#productTable tbody");
    tableBody.innerHTML = "";

    products.forEach(function(product) {
        var row = document.createElement("tr");
        var idCell = document.createElement("td");
        var nameCell = document.createElement("td");
        var companyCell = document.createElement("td"); // Change "categoryCell" to "companyCell"

        idCell.textContent = product.id;
        nameCell.textContent = product.name;
        companyCell.textContent = product.company; // Change "category" to "company"

        row.appendChild(idCell);
        row.appendChild(nameCell);
        row.appendChild(companyCell); // Change "categoryCell" to "companyCell"

        tableBody.appendChild(row);
    });
}

function displayMessage(message, type) {
    var messageDiv = document.getElementById("message");
    messageDiv.textContent = message;
    messageDiv.className = type;
}
