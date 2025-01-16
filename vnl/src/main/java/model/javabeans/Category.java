package model.javabeans;

public class Category {

    private String id;

    private String name;


    public Category(){}

    public Category(String id, String name){

        this.id=id;
        this.name=name;


    }

    public void setId(String id){this.id=id;}

    public String getId(){return this.id; }

    public void setName(String name){this.name=name;}

    public String getName(){return this.name;}

}
