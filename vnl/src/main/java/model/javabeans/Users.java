package model.javabeans;

public class Users {

    private String id;

    private  String username;

    private String password;

    private String email;

    public Users(){}

    public Users(String id, String username, String password, String email){

        this.id=id;

        this.username=username;

        this.password= password;

        this.email=email;

    }

    public String getUserId(){
        return this.id;
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


}







