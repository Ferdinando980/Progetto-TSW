package model.javabeans;

public class OrderItems {

    private Order ord;

    private Product prod;

    private String id;

    private int quantity;

    private float price;

    public OrderItems(){

    }

    public OrderItems(Order ord, Product prod, String id, int quantity, float price){

        this.ord=ord;
        this.prod=prod;
        this.id=id;
        this.quantity=quantity;
        this.price=price;

    }

    public void setOrd(Order ord){
        this.ord=ord;
    }
    public void setProd(Product prod){
        this.prod=prod;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return this.price;
    }

    public Order getOrd() {
        return this.ord;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public Product getProd() {
        return this.prod;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
