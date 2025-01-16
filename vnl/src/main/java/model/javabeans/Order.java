package model.javabeans;

import java.util.GregorianCalendar;

public class Order {

    private String id;

    private GregorianCalendar doo;

    private String status;

    private float  totAmount;

    private Users user;

    public Order(){}

    public Order(String id, String status, float totAmount, Users user){

        this.id=id;
        this.status=status;
        this.totAmount=totAmount;
        this.user=user;


    }

    public String getId(String id){ return this.id;}
    public void setId(String id){this.id=id;}

    public String getStatus(){return this.status;}

    public void setStatus(String status){this.status=status;}

    public float getTotAmount(){ return this.totAmount;}

    public GregorianCalendar getDoo() {
        return this.doo;
    }

    public void setDoo(GregorianCalendar doo){ this.doo=doo;}
}
