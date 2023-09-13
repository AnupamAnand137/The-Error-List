// Function to store the last login timestamp in localStorage
export function setLastLogin() {
    const lastLoginTime = new Date().toLocaleTimeString();
    localStorage.setItem('lastLogin', lastLoginTime);
  }
  
  // Function to retrieve the last login timestamp from localStorage
  export function getLastLogin() {
    const lastLogin = localStorage.getItem('lastLogin');
    return lastLogin;
  }
  