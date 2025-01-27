package model.javabeans;


import java.util.Date;

public class Order {

    private String id;

    private Date dateOfOrder;

    private String status;

    private float  totAmount;

    private Users user;

    public Order(){}

    public Order(String id, String status, float totAmount, Users user){

        this.id=id;
        this.status=status;
        this.totAmount=totAmount;
        this.user=user;
        this.dateOfOrder= new Date();


    }


    public String getId(String id){ 

        return this.id;

    }
    public void setId(String id){

        this.id=id;

    }

    public String getStatus(){
        return this.status;
    }

    public void setStatus(String status){
        this.status=status;
    }

    public float getTotAmount(){ 
        return this.totAmount;
    }

    public Date getDateOfOrder() {
        return this.dateOfOrder;
    }

    public void setDoo(Date dateOfOrder){ 
        this.dateOfOrder=dateOfOrder;
    }
}
