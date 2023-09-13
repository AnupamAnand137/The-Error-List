let checkAuthentication = () => {
    if (sessionStorage.getItem("is_Logged_In") === "true" && sessionStorage.getItem("token") !== null) {
        return true;
    } else {
        return false;
    }
}


export {checkAuthentication};