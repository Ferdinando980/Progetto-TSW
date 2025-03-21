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
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "Logout", true);
    xhr.onload = function() {
        if (xhr.status === 200) {
            location.reload();
        }
    };
    xhr.onerror = function() {
        console.error("Errore nel logout:", xhr.statusText);
    };
    xhr.send();
}