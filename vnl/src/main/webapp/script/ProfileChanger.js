document.addEventListener("DOMContentLoaded", function () {
    let profileSection = document.getElementById("profile-section");


    if (isLoggedIn) {

        profileSection.innerHTML = `
                <a href="EditProfile">
                <img src="assets/images/profilo.png" alt="Profilo">
            </a>
            <button class="logout-button" onclick="logout()">Logout</button>
        `;
    } else {
        profileSection.innerHTML = `
            <a href="Login">
                <img src="assets/images/profilo.png" alt="Profilo">
            </a>
        `;
    }
        

});


function logout() {
    fetch("Logout", {
        method: "GET"
    })
        .then(response => {
            if (response.ok) {
                location.reload();
            }
        })
        .catch(error => console.error("Errore nel logout:", error));
}