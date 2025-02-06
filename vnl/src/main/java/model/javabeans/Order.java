package model.javabeans;


import java.util.Date;

public class Order {

    private String id;
    private String users;
    private String stato;
    private Date dataOrdine;
    private float totAmount;
    private String nome;
    private String cognome;
    private String via;
    private String civico;
    private String cap;
    private String paese;

    public Order() {
    }

    public Order(String id, String users, String stato, Date dataOrdine, float totAmount, String nome, String cognome, String via, String civico, String cap, String paese) {
        this.id = id;
        this.users = users;
        this.stato = stato;
        this.dataOrdine = dataOrdine;
        this.totAmount = totAmount;
        this.nome = nome;
        this.cognome = cognome;
        this.via = via;
        this.civico = civico;
        this.cap = cap;
        this.paese = paese;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Date getDataOrdine() {
        return dataOrdine;
    }

    public void setDataOrdine(Date dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public float getTotAmount() {
        return totAmount;
    }

    public void setTotAmount(float totAmount) {
        this.totAmount = totAmount;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }
}
