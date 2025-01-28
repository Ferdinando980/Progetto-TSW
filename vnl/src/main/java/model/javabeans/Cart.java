 package model.javabeans;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private int cartID;
    private int userID;
    private Map<String, Long> mao= new HashMap<>();
    private Date createdAt;
    private Date updatedAt;
    public int getCartID() {
        return cartID;
    }
    public void setCartID(int cartID) {
        this.cartID = cartID;
    }
    public int getUserID() {
        return userID;
    }
    public void setUserID(int userID) {
        this.userID = userID;
    }
    public Map<String, Long> getMao() {
        return mao;
    }
    public void setMao(Map<String, Long> mao) {
        this.mao = mao;
    }
    public Date getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
