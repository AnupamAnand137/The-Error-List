function logout() {
    // Perform the logout action here (e.g., clear session, remove user data)
    sessionStorage.clear();
    localStorage.clear();

    // After performing the logout action, you can redirect the user to the login page or any other desired page.
    window.location.href = "login.html"; // Replace "login.html" with the actual login page URL.
}