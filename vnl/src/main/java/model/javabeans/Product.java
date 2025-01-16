package model.javabeans;

public class Product {

    private String id;

    private String name;

    private String desc;

    private float price;

    private String status;

    private Category cat;

    public Product(){
    }

    public Product(String name, float price, String id){

        this.name=name;
        this.price=price;
        this.id=id;
        this.desc="";
        this.status="Unknown";
        this.cat=new Category();

    }
    public Product(String name, String desc, float price, String status, Category cat, String id){

        this.id=id;
        this.name=name;
        this.desc=desc;
        this.price=price;
        this.status=status;
        this.cat=cat;

    }


    public void setId(String id){this.id=id;}

    public String getId(){return this.id; }

    public void setName(String name){this.name=name;}

    public Category getCat(){return this.cat;}

    public void setcat(Category cat){this.cat=cat;}

    public String getdesc(){return this.desc; }

    public void setdesc(String desc){this.desc=desc;}

    public String getName(){return this.name;}

}
