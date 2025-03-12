package model.javabeans;

public class OrderItems {

    private String ordine_id;

    private String ordine_users;

    private String prodotto;

    private int quantita;

    private float prezzo;

    public OrderItems() {
    }

    public OrderItems(String ordine_users, String ordine_id, String prodotto, int quantita, float prezzo) {
        this.ordine_users = ordine_users;
        this.ordine_id = ordine_id;
        this.prodotto = prodotto;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public String getOrdine_id() {
        return ordine_id;
    }

    public void setOrdine_id(String ordine_id) {
        this.ordine_id = ordine_id;
    }

    public String getOrdine_users() {
        return ordine_users;
    }

    public void setOrdine_users(String ordine_users) {
        this.ordine_users = ordine_users;
    }

    public String getProdotto() {
        return prodotto;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
