package model.javabeans;

public class Product {

    private String id;
    private float prezzo;
    private String descrizione;
    private String condizione;
    private String tipo;
    private String marca;
    private String modello;
    private String nomeVnl;
    private String artista;
    private String genere;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getCondizione() {
        return condizione;
    }

    public void setCondizione(String condizione) {
        this.condizione = condizione;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public String getNomeVnl() {
        return nomeVnl;
    }

    public void setNomeVnl(String nomeVnl) {
        this.nomeVnl = nomeVnl;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public Product() {
    }

    public Product(String id, float prezzo, String descrizione, String condizione, String tipo, String marca, String modello, String nomeVnl, String artista, String genere) {
        this.id = id;
        this.prezzo = prezzo;
        this.descrizione = descrizione;
        this.condizione = condizione;
        this.tipo = tipo;
        this.marca = marca;
        this.modello = modello;
        this.nomeVnl = nomeVnl;
        this.artista = artista;
        this.genere = genere;
    }
}