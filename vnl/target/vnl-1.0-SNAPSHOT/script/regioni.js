function caricaNazioni() {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "xml/nazioni.xml", true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const xml = xhr.responseXML;


            if (!xml) {
                console.error("Errore nel caricamento del file XML");
                return;
            }

     
            const countryCodesArray = xml.querySelector('string-array[name="CountryCodes"]');
            
            if (!countryCodesArray) {
                console.error("Sezione <string-array name='CountryCodes'> non trovata.");
                return;
            }

            const codes = countryCodesArray.getElementsByTagName("item");
            const selectElement = document.getElementById("Nazione");

            for (let i = 0; i < codes.length; i++) {
                const codeData = codes[i].textContent.trim();  
                const [countryCode, countryName] = codeData.split(",");  

                if (!countryCode || !countryName) {
                    console.error(`Dati non validi nell'item ${i + 1}: ${codeData}`);
                    continue;  
                }


                const optionElement = document.createElement("option");
                optionElement.value = countryCode;  
                optionElement.textContent = `${countryName} (${countryCode})`;
                selectElement.appendChild(optionElement);
            }
        }
    };

    xhr.send();
}


window.onload = caricaNazioni;
