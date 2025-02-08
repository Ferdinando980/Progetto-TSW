function caricaNazioni() {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "xml/nazioni.xml", true);

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            const xml = xhr.responseXML;

            // Verifica se il file XML è stato caricato correttamente
            if (!xml) {
                console.error("Errore nel caricamento del file XML");
                return;
            }

            // Trova la sezione <string-array name="CountryCodes"> nel file XML
            const countryCodesArray = xml.querySelector('string-array[name="CountryCodes"]');
            
            if (!countryCodesArray) {
                console.error("Sezione <string-array name='CountryCodes'> non trovata.");
                return;
            }

            const codes = countryCodesArray.getElementsByTagName("item");
            const selectElement = document.getElementById("Nazione");

            // Itera su tutte le voci per creare le opzioni
            for (let i = 0; i < codes.length; i++) {
                const codeData = codes[i].textContent.trim();  // Ottieni il contenuto dell'item
                const [countryCode, countryName] = codeData.split(",");  // Splitta il dato in codice e nome

                if (!countryCode || !countryName) {
                    console.error(`Dati non validi nell'item ${i + 1}: ${codeData}`);
                    continue;  // Passa al prossimo item
                }

                // Crea un'opzione nel menu a tendina
                const optionElement = document.createElement("option");
                optionElement.value = countryCode;  // Imposta il codice come valore
                optionElement.textContent = `${countryName} (${countryCode})`;  // Imposta il nome come testo
                selectElement.appendChild(optionElement);
            }
        }
    };

    xhr.send();
}

// Carica le nazioni quando la pagina è pronta
window.onload = caricaNazioni;
