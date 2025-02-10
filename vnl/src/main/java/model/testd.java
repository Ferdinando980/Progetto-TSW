package model;

public class testd {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver Loaded Successfully!");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver NOT Found!");
            e.printStackTrace();
        }
    }
}