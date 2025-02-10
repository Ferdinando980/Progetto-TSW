package model.javabeans;

import java.sql.Date;

public class Users {

    private String id;

    private  String username;

    private Date dataDiNascita;

    private String numeroDiTelefono;

    private String password;

    private String email;

    private String tipo;

    public Users(){}

    public Users(String id, String username, String password, String email, Date dataDiNascita, String numeroDiTelefono){

        this.id=id;
        this.username=username;
        this.password= password;
        this.email=email;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTelefono=numeroDiTelefono;
        this.tipo="user";

    }

    public Users(String username, String password, String email, Date dataDiNascita, String numeroDiTelefono){

        this.username=username;
        this.password= password;
        this.email=email;
        this.dataDiNascita = dataDiNascita;
        this.numeroDiTelefono=numeroDiTelefono;
        this.tipo="user";

    }

    public String getUserId(){
        return this.id;
    }
    
    public void setUserId(String id){
        this.id=id;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getUsername(){
        return this.username;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email= email;
    }

    public void setPassword(String password){
        this.password= password;
    }

    public String getPassword(){
        return this.password;
    }

    public void setDataDiNascita(Date dataDiNascita){
        this.dataDiNascita=dataDiNascita;
    }

    public void setNumeroDiTelefono(String numeroDiTelefono){
        this.numeroDiTelefono=numeroDiTelefono;
    }

    public String getNumeroDiTelefono(){
        return this.numeroDiTelefono;
    }

    public Date getDataDiNascita(){
        return this.dataDiNascita;
    }

    public String getTipo(){
        return this.tipo;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }
}







